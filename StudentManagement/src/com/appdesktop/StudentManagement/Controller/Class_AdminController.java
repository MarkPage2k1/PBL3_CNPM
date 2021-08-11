/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.Model.CBBItem;
import com.appdesktop.StudentManagement.Model.Class_Admin;
import com.appdesktop.StudentManagement.Model.Class_Student;
import com.appdesktop.StudentManagement.Model.Class_Teacher;
import com.appdesktop.StudentManagement.Model.Classer;
import com.appdesktop.StudentManagement.Model.Course;
import com.appdesktop.StudentManagement.Model.ListStudent;
import com.appdesktop.StudentManagement.Model.Person;
import com.appdesktop.StudentManagement.Service.Class_AdminService;
import com.appdesktop.StudentManagement.Service.Class_AdminServiceImpl;
import com.appdesktop.StudentManagement.Service.Class_StudentService;
import com.appdesktop.StudentManagement.Service.Class_StudentServiceImpl;
import com.appdesktop.StudentManagement.Service.Class_TeacherService;
import com.appdesktop.StudentManagement.Service.Class_TeacherServiceImpl;
import com.appdesktop.StudentManagement.Service.ClasserService;
import com.appdesktop.StudentManagement.Service.ClasserServiceImpl;
import com.appdesktop.StudentManagement.Service.CourseService;
import com.appdesktop.StudentManagement.Service.CourseServiceImpl;
import com.appdesktop.StudentManagement.Service.TeacherService;
import com.appdesktop.StudentManagement.Service.TeacherServiceImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Duy Ngoc <duylengoc1111@gmail.com>
 */
public class Class_AdminController {

    private Class_AdminService class_adminservice = null;
    private Class_StudentService class_studentservice = null;
    private Class_TeacherService class_teacherservice = null;
    private CourseService courseService = null;
    private ClasserService classservice = null;
    private TeacherService teacherservice = null;
    private JComboBox combobox;
    private JComboBox combobox_teacher;
    private JComboBox combobox_course;
    private JTextArea textarea;
    private JTextField textfiled;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tblModel;
    private TableRowSorter<TableModel> rowSorter = null;
    final byte Add = 1;
    final byte Edit = 2;

    public Class_AdminController(JComboBox combobox, JTextField textfiled, JFrame frame, JTable table) {
        this.combobox = combobox;
        this.textfiled = textfiled;
        this.frame = frame;
        this.table = table;
        class_adminservice = new Class_AdminServiceImpl();
        class_studentservice = new Class_StudentServiceImpl();
        class_teacherservice = new Class_TeacherServiceImpl();
    }

    public Class_AdminController(JTable table) {
        this.table = table;
        class_adminservice = new Class_AdminServiceImpl();
        class_studentservice = new Class_StudentServiceImpl();
        courseService = new CourseServiceImpl();
        teacherservice = new TeacherServiceImpl();
    }

    /**
     *
     * @param combobox_class
     * @param combobox_teacher
     * @param combobox_course
     * @param frame
     * @param areatext
     */
    public Class_AdminController(JComboBox combobox_class, JComboBox combobox_teacher, JComboBox combobox_course, JFrame frame, JTextArea areatext) {
        this.combobox = combobox_class;
        this.combobox_teacher = combobox_teacher;
        this.combobox_course = combobox_course;
        this.frame = frame;
        this.textarea = areatext;
        class_adminservice = new Class_AdminServiceImpl();
    }

    @SuppressWarnings({"unchecked", "unchecked", "unchecked"})
    public void setCbbDetail() {
        teacherservice = new TeacherServiceImpl();
        courseService = new CourseServiceImpl();
        classservice = new ClasserServiceImpl();
        try {
            for (Person ps : teacherservice.getAllTeacher()) {
                combobox_teacher.addItem(new CBBItem(ps.getId(), ps.getName()));
            }
            for (Course cs : courseService.getAllCourses()) {
                combobox_course.addItem(new CBBItem(cs.getIdCourse(), cs.getCourseName()));
            }
            for (Classer cl : classservice.getAllClassOfCourse(((CBBItem) combobox_course.getSelectedItem()).Value)) {
                combobox.addItem(new CBBItem(cl.getIdClass(), cl.getClassName()));
            }
            combobox_course.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    combobox.removeAllItems();
                    for (Classer cl : classservice.getAllClassOfCourse(((CBBItem) combobox_course.getSelectedItem()).Value)) {
                        combobox.addItem(new CBBItem(cl.getIdClass(), cl.getClassName()));
                    }
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setSelectedValue(JComboBox cbb, String value) {
        CBBItem item;
        for (int i = 0; i < cbb.getItemCount(); ++i) {
            item = (CBBItem) cbb.getItemAt(i);
            if (item.Text.equalsIgnoreCase(value)) {
                cbb.setSelectedIndex(i);
                break;
            }
        }
    }

    public void FillData(String id) {
        Class_Admin ca = class_adminservice.getClass_AdminByID(id);
        setSelectedValue(combobox_course, ca.getNamecourse());
        setSelectedValue(combobox, ca.getClassname());
        setSelectedValue(combobox_teacher, ca.getTeachername());
    }

    public void inittable_liststudent() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        tblModel.setColumnIdentifiers(new String[]{"Mã lớp học", "Tên lớp học", "Mã học viên", "Tên học viên", "STD", "Khóa học"});
        table.setModel(tblModel);
    }

    public void inittable_class() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        tblModel.setColumnIdentifiers(new String[]{"Mã Lớp HP", "Mã lớp học", "Tên lớp", "Khóa học",
            "Giảng Viên", "Trạng Thái", "Ngày đăng kí"});
        table.setModel(tblModel);
    }

    public void loadtableAllclass(String id, String position) {
        try {
            if (position.equals("Học Viên")) {
                List<Class_Student> list = class_studentservice.getAllClassOfStudent(id);
                tblModel.setRowCount(0);
                for (Class_Student i : list) {
                    tblModel.addRow(new Object[]{
                        i.getId_class_student(),
                        i.getIdClass(),
                        i.getClassName(),
                        i.getCourseName(),
                        i.getTchName(),
                        i.isStatus() ? "Hoạt động" : "Khóa",
                        i.getRegisterDate()
                    });
                    tblModel.fireTableDataChanged();
                }
            } else if (position.equals("Giảng Viên")) 
            {
                List<Class_Teacher> list = class_teacherservice.getAllClassOfTeacher(id);
                tblModel.setRowCount(0);
                table.removeColumn(table.getColumnModel().getColumn(4));
                for (Class_Teacher i : list) {
                    tblModel.addRow(new Object[]
                    {
                        i.getId_class_teacher(),
                        i.getIdClass(),
                        i.getClassName(),
                        i.getCourseName(),
                        i.getCourseName(), //  chỉ là bia đỡ,để xóa cột mà không làm mất dữ liệu - line 190 resolved
                        i.isStatus() ? "Hoạt động" : "Khóa",
                        i.getRegisterDate()
                    });
                    tblModel.fireTableDataChanged();
                }
                rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Loadtable_liststudent(String id_class_teacher) {
//        String idcourse = courseService.getIdCourse(coursename);
//        String idteacher = teacherservice.getIdTeacher(nameTeacher);
        tblModel.setRowCount(0);
        try {
            for (ListStudent ls : class_studentservice.getAllStudent(id_class_teacher)) {
                tblModel.addRow(new Object[]{
                    ls.getIdclass(),
                    ls.getClassname(),
                    ls.getId_student(),
                    ls.getNamestudent(),
                    ls.getPhonenumb(),
                    ls.getCoursename()
                });
                tblModel.fireTableDataChanged();
                rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inittable() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        tblModel.setColumnIdentifiers(new String[]{"Mã Lớp HP", "Mã lớp học", "Tên lớp", "Khóa học",
            "Giảng Viên", "Trạng Thái", "Ngày bắt đầu", "Ngày kết thúc"});
        table.setModel(tblModel);
    }

    @SuppressWarnings({"unchecked", "unchecked"})
    public void setCombobox() {
        try {
            courseService = new CourseServiceImpl();
            for (ActionListener al : combobox.getActionListeners()) {
                combobox.removeActionListener(al);
            }
            combobox.removeAllItems();
            combobox.addItem(new CBBItem("0", "All"));
            for (Course cr : courseService.getAllCourses()) {
                combobox.addItem(new CBBItem(cr.getIdCourse(), cr.getCourseName()));
            }
            combobox.setSelectedIndex(0);
            if (combobox.getSelectedIndex() < 0) {
                MessageDialogHelper.showMessageDialog(frame, "Hiện tại giảng viên chưa đăng ký lớp học nào!\nVui lòng cập nhật thêm!", "Thông Báo!");
            }
            ActionListener ac = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = ((CBBItem) combobox.getSelectedItem()).Value;
                    Loadtable(id);

                }
            };
            combobox.addActionListener(ac);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Loadtable(String idcourse) {

        tblModel.setRowCount(0);
        try {
            for (Class_Admin class_ad : class_adminservice.getAll_ClassAdminbyID(idcourse)) {
                tblModel.addRow(new Object[]{
                    class_ad.getId_class_teacher(),
                    class_ad.getId_class(),
                    class_ad.getClassname(),
                    class_ad.getNamecourse(),
                    class_ad.getTeachername(),
                    class_ad.isStatus() ? "Hoạt Động" : "Khóa",
                    class_ad.getStartdate(),
                    class_ad.getEnddate()
                });
            }
            tblModel.fireTableDataChanged();
            rowSorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(rowSorter);
            textfiled.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String text = textfiled.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String text = textfiled.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAdd(byte statusform, String id) {
        if (statusform == Add) {
            return class_adminservice.InsertClass(((CBBItem) combobox.getSelectedItem()).Value, ((CBBItem) combobox_course.getSelectedItem()).Value, ((CBBItem) combobox_teacher.getSelectedItem()).Value);
        } else if (statusform == Edit) {
            return class_adminservice.UpdateClass(((CBBItem) combobox.getSelectedItem()).Value, ((CBBItem) combobox_course.getSelectedItem()).Value, ((CBBItem) combobox_teacher.getSelectedItem()).Value, id);
        } else {
            return false;
        }
    }

    public void DeleteClass_Admin(int[] row) {
        String id_class_teacher = null;
        try {
            if (row.length > 0) {
                if (MessageDialogHelper.showConfirmDialog(frame, "Bạn có muốn hủy đăng ký lớp học này?", "Hỏi")
                        == JOptionPane.NO_OPTION) {
                    return;
                }
                for (int s : row) {
                    id_class_teacher = (String) table.getValueAt(s, 0);
                    if (!class_adminservice.DeleteClass(id_class_teacher)) {
                        MessageDialogHelper.showErrorDialog(frame, "Xóa không thành công!", "Cảnh báo");
                        return;
                    }
                }
                Loadtable("0");
                MessageDialogHelper.showMessageDialog(frame, "Xóa thành công!", "Thông báo");
            } else {
                MessageDialogHelper.showErrorDialog(frame, "Bạn chưa chọn lớp cần xóa!", "Cảnh báo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(frame, e.getMessage(), "Lỗi");
        }
    }

}
