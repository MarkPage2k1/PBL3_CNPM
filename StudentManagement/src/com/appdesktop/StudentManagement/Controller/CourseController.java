package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.Model.Course;
import com.appdesktop.StudentManagement.Service.CourseService;
import com.appdesktop.StudentManagement.Service.CourseServiceImpl;
import com.appdesktop.StudentManagement.Model.CBBItem;
import com.appdesktop.StudentManagement.Model.Classer;
import com.appdesktop.StudentManagement.Service.ClasserService;
import com.appdesktop.StudentManagement.Service.ClasserServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CourseController {
    
    private CourseService courseService = null;
    private String idCourse = null;
    private JTextField jtfCourseName, jtfIdCourse;
    private JCheckBox jcheckStatus;
    private JComboBox comboBox;
    private JDateChooser jDateStartOrReg, jDateEnd;
    private JTextArea jTextNote;
    
    final byte Detail = 0;
    final byte Add = 1;
    final byte Edit = 2;
    
    
    private JFrame parentForm;
    private DefaultTableModel tblModle;
    private JTable jTable;
    private JTextField jtfSearch;
    
    private TableRowSorter<TableModel> rowSorter = null;
    public CourseController( JComboBox comboBox, JFrame parentForm, JTable jTableCourse, JTextField jtfSearch) {
        this.comboBox = comboBox;
        this.parentForm = parentForm;
        this.jTable = jTableCourse;
        this.jtfSearch = jtfSearch;
        courseService = new CourseServiceImpl();
    }
    
    public CourseController(JFrame parentForm, JTable jTableCourse, JTextField jtfSearch) {
        this.parentForm = parentForm;
        this.jTable = jTableCourse;
        this.jtfSearch = jtfSearch;
        courseService = new CourseServiceImpl();
    }
    
    public CourseController(JComboBox comboBox){
        this.comboBox = comboBox;
        courseService = new CourseServiceImpl();
    }
    
        public CourseController(String idCourse, JTextField jtfIdCourse, JTextField jtfCourseName, JCheckBox jcheckStatus, JComboBox jcomboBox,
            JDateChooser jDateStartOrReg, JDateChooser jDateEnd, JTextArea jTextNote) {
        courseService = new CourseServiceImpl();
        this.idCourse = idCourse;
        this.jtfIdCourse = jtfIdCourse;
        this.jtfCourseName = jtfCourseName;
        this.jcheckStatus = jcheckStatus;
        this.comboBox = jcomboBox;
        this.jDateStartOrReg = jDateStartOrReg;
        this.jDateEnd = jDateEnd;
        this.jTextNote = jTextNote;   
    }
    @SuppressWarnings("unchecked")
    public void setCbbOfCourse(){
        try{             
            List<Course> list = courseService.getAllCourses();
            comboBox.removeAllItems();
            for (Course i :  list){    
                comboBox.addItem(new CBBItem(i.getIdCourse(), i.getCourseName()));
            }
            if (comboBox.getSelectedIndex() < 0) {
                MessageDialogHelper.showMessageDialog(parentForm, "Hiện tại hệ thống chưa có khóa học nào!\nVui lòng cập nhật thêm!", "Thông Báo!");
            }
        } catch (java.lang.Exception e){
            e.printStackTrace();
        }
    }
    
    public void initTableOfclass() {
         tblModle = new DefaultTableModel();
         tblModle.setColumnIdentifiers(new String[] {"Mã lớp học", "Tên lớp học", "Ngày tạo lớp học", "Tình trạng", "Ghi chú"});
         jTable.setModel(tblModle);
    } 
   
    public void loadDataTableOfclass() {
        try {
            ClasserService classerService = new ClasserServiceImpl();
            String idCourse = ((CBBItem)comboBox.getSelectedItem()).Value;
            List<Classer> list = classerService.getAllClassOfCourse(idCourse);
            tblModle.setRowCount(0);
            for (Classer i : list) {
                tblModle.addRow(new Object[] {
                    i.getIdClass(),
                    i.getClassName(),
                    i.getRegistrationdate(),
                    i.isStatus() ? "Hoạt động" : "Khóa",
                    i.getRemark()
            });
            tblModle.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTable.getModel());
            jTable.setRowSorter(rowSorter);
            
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
    
    public void initTableOfcourse() {
        tblModle = new DefaultTableModel();
        tblModle.setColumnIdentifiers(new String[] {"Mã khóa học", "Tên khóa học", "Ngày bắt đầu", "Ngày kết thúc", "Tình trạng", "Ghi chú"});
        jTable.setModel(tblModle);
    }

    public void loadDataTableOfcourse() {
        try {
            ClasserService classerService = new ClasserServiceImpl();
            CourseService courseService = new CourseServiceImpl();
            List<Course> list = courseService.getAllCourses();
            tblModle.setRowCount(0);
            for (Course i : list) {
                tblModle.addRow(new Object[] {
                    i.getIdCourse(),
                    i.getCourseName(),
                    i.getStartDate(),
                    i.getEndDate(),
                    i.isStatus() ? "Hoạt động" : "Khóa",
                    i.getDescribe()
            });
            tblModle.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTable.getModel());
            jTable.setRowSorter(rowSorter);
            
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
    
    public void loadInforCourse(){
        try {
            Course course = courseService.getCourse(idCourse);
            if (course != null) {           
                jtfCourseName.setText(course.getCourseName());
                jcheckStatus.setSelected(course.isStatus());
                jDateStartOrReg.setDate(course.getStartDate());
                jDateEnd.setDate(course.getEndDate());
                jTextNote.setText(course.getDescribe());
//                String idCourse = null; 
//                String ID = classer.getCourse_idcourse();
                
            }
        } catch (Exception e) {
        }
    }
    
        public boolean updateInforCourse(byte StatusForForm){
        try {
            Course course = new Course();
            course.setIdCourse(jtfIdCourse.getText());
            course.setCourseName(jtfCourseName.getText());
            course.setStatus(jcheckStatus.isSelected());
            course.setStartDate(convertDateToDateSql(jDateStartOrReg.getDate()));
            course.setEndDate(convertDateToDateSql(jDateEnd.getDate()));
            course.setDescribe(jTextNote.getText());

            if (StatusForForm == Edit){
               // System.out.println( " - " + idCourse);
                return courseService.updateInforCourse(course);
            }  
            
            if (StatusForForm == Add)
                return courseService.insertInforCourse(course);
//            } else {
//                AccountService accountService = new AccountServiceImpl();
//                Account account = new Account();
//                account.setUsername(jtfIdStudent.getText());
//                account.setPassword("1234");
//                account.setPosition("Học Viên");
//                return (accountService.inserAcount(account)) ? studentService.inserStudent(st) : false;
              
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    private java.sql.Date convertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    public void deleteCourse(int rows[]){
        try {    
            if (rows.length > 0) {
                for (int s : rows) {
                    idCourse = (String) jTable.getValueAt(s, 0); 
                    CourseService couseService = new CourseServiceImpl();
                    if (!couseService.deleteCourse(idCourse)) {
                        MessageDialogHelper.showErrorDialog(parentForm, "Xóa không thành công!", "Cảnh báo");
                        return;
                    } 
                }
            } else {
                MessageDialogHelper.showErrorDialog(parentForm, "Bạn chưa chọn khóa học cần xóa!", "Cảnh báo");  
            } 
            loadDataTableOfcourse();
            MessageDialogHelper.showMessageDialog(parentForm, "Xóa thành công!", "Thông báo");     
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    public void deleteClass(int rows[]){
        try { 
            String idClass;
            idCourse = ((CBBItem)comboBox.getSelectedItem()).Value;
            if (rows.length > 0) {
                for (int s : rows) {
                    idClass = (String) jTable.getValueAt(s, 0); 
                    ClasserService classService = new ClasserServiceImpl();
                    if (!classService.deleteClass(idClass, idCourse)) {
                        MessageDialogHelper.showErrorDialog(parentForm, "Xóa không thành công!", "Cảnh báo");
                        return;
                    } 
                }
            } else {
                MessageDialogHelper.showErrorDialog(parentForm, "Bạn chưa chọn lớp học cần xóa!", "Cảnh báo");  
            } 
            loadDataTableOfclass();
            MessageDialogHelper.showMessageDialog(parentForm, "Xóa thành công!", "Thông báo");     
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
}
