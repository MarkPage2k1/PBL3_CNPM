package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.Model.Person;
import com.appdesktop.StudentManagement.Service.AccountService;
import com.appdesktop.StudentManagement.Service.AccountServiceImpl;
import com.appdesktop.StudentManagement.Service.TeacherService;
import com.appdesktop.StudentManagement.Service.TeacherServiceImpl;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TeacherManagementController {
    private JFrame parentForm;
    private JTable jTableTeacher;
    private JTextField jtfSearch;
    private DefaultTableModel tblModle;
    private TableRowSorter<TableModel> rowSorter = null;
    private TeacherService teacherService = null;
    private static String idTeacher;
    
    public TeacherManagementController(JFrame parentForm, JTable jTableTeacher, JTextField jtfSearch) {
        this.parentForm = parentForm;
        this.jTableTeacher = jTableTeacher;
        this.jtfSearch = jtfSearch;
        teacherService = new TeacherServiceImpl();
    }
    
    public void initTable() {
        tblModle = new DefaultTableModel();
        tblModle.setColumnIdentifiers(new String[] {"Mã giảng viên", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Tình trạng", "Email", "Số điện thoại"});
        jTableTeacher.setModel(tblModle);
    }
    public void loadDataTable() {
        try {
            List<Person> list = teacherService.getAllTeacher();
            tblModle.setRowCount(0);
            for (Person it : list) {
                tblModle.addRow(new Object[] {
                it.getId(),
                it.getName(),
                it.getBrithday(),
                it.isGender() == true ? "Nam" : "Nữ",
                it.getAddress(),
                it.isStatus() == true ? "Bình thường" : "Khóa",
                it.getEmail(),
                it.getPhone()
            });
            tblModle.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTableTeacher.getModel());
            jTableTeacher.setRowSorter(rowSorter);
            
            jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String text = jtfSearch.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    } 
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String text = jtfSearch.getText();
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
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    public void deleteTeachers(int rows[]){
        try {    
            if (rows.length > 0) {
                for (int s : rows) {
                    idTeacher = (String) jTableTeacher.getValueAt(s, 0); 
                    TeacherService teacherService = new TeacherServiceImpl();
                    if (!teacherService.deleteTeacher(idTeacher)) {
                        MessageDialogHelper.showErrorDialog(parentForm, "Xóa không thành công!", "Cảnh báo");
                        MessageDialogHelper.showErrorDialog(parentForm, idTeacher + rows.length, "Cảnh báo");
                        return;
                    } else {
                        AccountService accountService = new AccountServiceImpl();
                        accountService.deleteAcount(idTeacher);
                    }
                }
            } else {
                MessageDialogHelper.showErrorDialog(parentForm, "Bạn chưa chọn giảng viên cần xóa!", "Cảnh báo");  
            } 
            loadDataTable();
            MessageDialogHelper.showMessageDialog(parentForm, "Xóa thành công!", "Thông báo");     
        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
}
