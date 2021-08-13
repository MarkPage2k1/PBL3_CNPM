package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.DBHelpers.sharedData;
import com.appdesktop.StudentManagement.Model.CBBItem;
import com.appdesktop.StudentManagement.Model.Class_Teacher;
import com.appdesktop.StudentManagement.Model.studentOfClass;
import com.appdesktop.StudentManagement.Service.Class_TeacherService;
import com.appdesktop.StudentManagement.Service.Class_TeacherServiceImpl;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import view.FormDetailClass;

public class Class_TeacherController {

    private Class_TeacherService cTeacherService = null;
    private JFrame parentForm;
    private JTable jTableStudent;
    private DefaultTableModel tblModle;
    private JTextField jtfSearch;
    private JTable jTableClass;
    private JComboBox jcomboBox;
    private TableRowSorter<TableModel> rowSorter = null;

    final private String IDUSER = sharedData.userLogin.getUsername();

    public Class_TeacherController(JFrame parentForm, JTable jTableClass) {
        this.parentForm = parentForm;
        this.jTableClass = jTableClass;
        cTeacherService = new Class_TeacherServiceImpl();
    }

    public Class_TeacherController(JComboBox comboBox, JFrame parentForm, JTable jTableStudent, JTextField jtfSearch) {
        this.jcomboBox = comboBox;
        this.parentForm = parentForm;
        this.jTableStudent = jTableStudent;
        this.jtfSearch = jtfSearch;
        cTeacherService = new Class_TeacherServiceImpl();
    }

    public void initTableClass() {
        tblModle = new DefaultTableModel();
        tblModle.setColumnIdentifiers(new String[]{"Mã lớp học", "Tên lớp học", "Mã khóa học", "Tên khóa học", "Tình trạng", "Ngày đăng ký"});
        jTableClass.setModel(tblModle);
    }

    public void initTableStudent() {
        tblModle = new DefaultTableModel();
        tblModle.setColumnIdentifiers(new String[]{"Mã sinh viên", "Tên sinh viên", "Mã lớp học", "Tên lớp học", "Ngày đăng ký","Mã Khóa học"});
        jTableStudent.setModel(tblModle);
    }

    @SuppressWarnings("unchecked")
    public void setCbbOfClass() {
        try {
            List<Class_Teacher> list = cTeacherService.getAllClassOfTeacher(IDUSER);
            for (Class_Teacher i : list) {
                jcomboBox.addItem(new CBBItem(i.getIdClass(), i.getClassName()));
            }
            if (jcomboBox.getSelectedIndex() < 0) {
                MessageDialogHelper.showMessageDialog(parentForm, "Hiện tại hệ giảng viên chưa đăng ký lớp học nào!\nVui lòng cập nhật thêm!", "Thông Báo!");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataTable() {
        try {
            Class_TeacherService cTeacherService = new Class_TeacherServiceImpl();
            List<Class_Teacher> list = cTeacherService.getAllClassOfTeacher(IDUSER);
            //ClasserService classerService = new ClasserServiceImpl();
            tblModle.setRowCount(0);
            for (Class_Teacher i : list) {
                tblModle.addRow(new Object[]{
                    i.getIdClass(),
                    i.getClassName(),
                    i.getIdCourse(),
                    i.getCourseName(),
                    i.isStatus() ? "Hoạt động" : "Khóa",
                    i.getRegisterDate()
                });
                tblModle.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTableClass.getModel());
            jTableClass.setRowSorter(rowSorter);

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }

    public void loadDataTableStudentOfClass() {
        try {
            Class_TeacherService cTeacherService = new Class_TeacherServiceImpl();
            List<studentOfClass> list = cTeacherService.getAllStudentOfClass("l01");
            System.out.println("OK!");
            tblModle.setRowCount(0);
            for (studentOfClass i : list) {
                tblModle.addRow(new Object[]{
                    i.getIdStudent(),
                    i.getNameStudent(),
                    i.getIdClass(),
                    i.getNameClass(),
                    i.getRegisterdate()
                });
                tblModle.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTableStudent.getModel());
            jTableStudent.setRowSorter(rowSorter);

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    public void loadDataTableStudentOfClass(String idClass) {
        try {
            Class_TeacherService cTeacherService = new Class_TeacherServiceImpl();
            List<studentOfClass> list = cTeacherService.getAllStudentOfClass(idClass);
            tblModle.setRowCount(0);
            for (studentOfClass i : list) {
                tblModle.addRow(new Object[]{
                    i.getIdStudent(),
                    i.getNameStudent(),
                    i.getIdClass(),
                    i.getNameClass(),
                    i.getRegisterdate(),
                    i.getIdCourse()
                });
                tblModle.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTableStudent.getModel());
            jTableStudent.setRowSorter(rowSorter);

        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }

    public void deleteClassOfTeacher(int rows[]) {
        String idClass, idCourse = null;
        try {
            if (rows.length > 0) {
                if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn hủy đăng ký lớp học này?", "Hỏi")
                        == JOptionPane.NO_OPTION) {
                    return;
                }
                for (int s : rows) {
                    idClass = (String) jTableClass.getValueAt(s, 0);
                    idCourse = (String) jTableClass.getValueAt(s, 2);
                    if (!cTeacherService.deleteClassOfTeacher(idClass, idCourse, IDUSER)) {
                        MessageDialogHelper.showErrorDialog(parentForm, "Xóa không thành công!", "Cảnh báo");
                        return;
                    }
                }
                MessageDialogHelper.showMessageDialog(parentForm, "Xóa thành công!", "Thông báo");
                loadDataTable();
                if(FormDetailClass.it != null)
                {
                FormDetailClass.it.loadtableforclass();
                }
            } else {
                MessageDialogHelper.showErrorDialog(parentForm, "Bạn chưa chọn lớp cần xóa!", "Cảnh báo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }

    public void registerClassOfTeacher(String idClass, String idCourse) {
        try {
            if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn đăng ký lớp học này?", "Hỏi")
                    == JOptionPane.NO_OPTION) {
                return;
            }
            if (!cTeacherService.registerClassOfTeacher(idClass, idCourse, IDUSER)) {
                MessageDialogHelper.showErrorDialog(parentForm, "Đăng ký không thành công!\nLỗi: Lớp này đã có giảng viên khác đăng ký!", "Cảnh báo");
                return;
            }
            MessageDialogHelper.showMessageDialog(parentForm, "Đăng ký thành công!", "Thông báo");
            loadDataTable();
            if(FormDetailClass.it != null)
            {
            FormDetailClass.it.loadtableforclass();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
}
