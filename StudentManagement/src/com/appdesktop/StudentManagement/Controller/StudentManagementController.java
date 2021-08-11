package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.Model.Person;
import com.appdesktop.StudentManagement.Service.AccountService;
import com.appdesktop.StudentManagement.Service.AccountServiceImpl;
import com.appdesktop.StudentManagement.Service.StudentService;
import com.appdesktop.StudentManagement.Service.StudentServiceImpl;
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

public class StudentManagementController {
    private JFrame parentForm;
    private JTable jTableStudent;
    private JTextField jtfSearch;
    private DefaultTableModel tblModle;
    private TableRowSorter<TableModel> rowSorter = null;
    private StudentService studentService = null;
    private static String idStudent;
    
    public StudentManagementController(JFrame parentForm, JTable jTableStudent, JTextField jtfSearch) {
        this.parentForm = parentForm;
        this.jTableStudent = jTableStudent;
        this.jtfSearch = jtfSearch;
        studentService = new StudentServiceImpl();
    }
    
    public void initTable() {
        tblModle = new DefaultTableModel();
        tblModle.setColumnIdentifiers(new String[] {"Mã sinh viên", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Tình trạng", "Email", "Số điện thoại"});
        jTableStudent.setModel(tblModle);
    }
    public void loadDataTable() {
        try {
            List<Person> list = studentService.getAllStudent();
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
            rowSorter = new TableRowSorter<>(jTableStudent.getModel());
            jTableStudent.setRowSorter(rowSorter);
            
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
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    public void deleteStudents(int rows[]){
        try {    
            if (rows.length > 0) {
                for (int s : rows) {
                    idStudent = (String) jTableStudent.getValueAt(s, 0); 
                    StudentService studentService = new StudentServiceImpl();
                    if (!studentService.deleteStudent(idStudent)) {
                        MessageDialogHelper.showErrorDialog(parentForm, "Xóa không thành công!", "Cảnh báo");
                        MessageDialogHelper.showErrorDialog(parentForm, idStudent + rows.length, "Cảnh báo");
                        return;
                    } else {
                        AccountService accountService = new AccountServiceImpl();
                        accountService.deleteAcount(idStudent);
                    }
                }
            } else {
                MessageDialogHelper.showErrorDialog(parentForm, "Bạn chưa chọn sinh viên cần xóa!", "Cảnh báo");  
            } 
            loadDataTable();
            MessageDialogHelper.showMessageDialog(parentForm, "Xóa thành công!", "Thông báo");     
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
}
