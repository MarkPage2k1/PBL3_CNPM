package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.Model.studentOfClass;
import com.appdesktop.StudentManagement.Service.Class_TeacherService;
import com.appdesktop.StudentManagement.Service.Class_TeacherServiceImpl;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Information_TeacherController {
    private String idClass;
    private Class_TeacherService cTeacherService = null;
    private JFrame parentForm;
    private JTable jTable1;
    private DefaultTableModel tblModle;
    private TableRowSorter<TableModel> rowSorter = null;

    public Information_TeacherController (String idClass, JFrame parentForm, JTable jTable1) {
        this.idClass = idClass;
        this.parentForm = parentForm;
        this.jTable1 = jTable1;
        cTeacherService = new Class_TeacherServiceImpl();
    }



    public void initTableStudent() {
        tblModle = new DefaultTableModel();
        tblModle.setColumnIdentifiers(new String[] {"Mã sinh viên", "Tên sinh viên", "Mã lớp học", "Tên lớp học", "Ngày đăng ký", "Mã khóa học"});
        jTable1.setModel(tblModle);
    }
    

    public void loadDataTableStudentOfClass(String idClass) {
        try {
            Class_TeacherService cTeacherService = new Class_TeacherServiceImpl();
            List<studentOfClass> list = cTeacherService.getAllStudentOfClass(idClass);
            tblModle.setRowCount(0);
            for (studentOfClass i : list) {
                tblModle.addRow(new Object[] {
                    i.getIdStudent(),
                    i.getNameStudent(),
                    i.getIdClass(),
                    i.getNameClass(),
                    i.getRegisterdate(),
                    i.getIdCourse()
                });
            tblModle.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTable1.getModel());
            jTable1.setRowSorter(rowSorter);
                
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    
    

}
