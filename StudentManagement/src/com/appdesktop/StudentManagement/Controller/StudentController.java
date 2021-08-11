package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.ImageHelper;
import com.appdesktop.StudentManagement.Model.Account;
import com.appdesktop.StudentManagement.Model.Person;
import com.appdesktop.StudentManagement.Service.AccountService;
import com.appdesktop.StudentManagement.Service.AccountServiceImpl;
import com.appdesktop.StudentManagement.Service.StudentService;
import com.appdesktop.StudentManagement.Service.StudentServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentController {
    private byte[] personalImage;
    private boolean statusEdit;
    private StudentService studentService = null;
    private String id = null;
    private JTextField jtfIdStudent, jtfName, jtfEmail, jtfPhone;
    private JDateChooser jBrithday;
    private JRadioButton jrbtnMale, jrbtnFemale;
    private JCheckBox jCheckBox;
    private JTextArea jAddress;
    private JLabel jlbAvatar;
    
    public StudentController(String idStudent, JTextField jtfIdStudent, JTextField jtfName, JDateChooser jBrithday,
            JRadioButton jrbtnMale, JRadioButton jrbtnFemale, JCheckBox jCheckBox, JTextArea jAddress,
            JTextField jtfEmail, JTextField jtfPhone, JLabel jlbAvatar, boolean statusEdit, byte[] personalImage) {
        this.id = idStudent;
        this.jtfIdStudent = jtfIdStudent;
        this.jtfName = jtfName;
        this.jBrithday = jBrithday;
        this.jrbtnMale = jrbtnMale;
        this.jrbtnFemale = jrbtnFemale;
        this.jCheckBox = jCheckBox;
        this.jAddress = jAddress;
        this.jtfEmail = jtfEmail;
        this.jtfPhone = jtfPhone;
        this.jlbAvatar = jlbAvatar;
        this.statusEdit = statusEdit;
        this.personalImage = personalImage;
        
        studentService = new StudentServiceImpl();
    }
    
    
    public void LoadInforStudent() {
        try {
            Person st = studentService.getStudent(id);

            if (st != null) {
            
                jtfIdStudent.setText(st.getId());
                jtfIdStudent.setEnabled(false);
                jtfName.setText(st.getName());
                jBrithday.setDate(st.getBrithday());
                if (st.isGender() == true) {
                    jrbtnMale.setSelected(true);
                } else {
                    jrbtnFemale.setSelected(true);
                }
                jCheckBox.setSelected(st.isStatus());
                jAddress.setText(st.getAddress());
                jtfEmail.setText(st.getEmail());
                jtfPhone.setText(st.getPhone());

                if (st.getAvatar()!= null) {
                    Image img = ImageHelper.creImageFromByteArray(st.getAvatar(), "jpg");
                    jlbAvatar.setIcon(new ImageIcon(img));
                    personalImage = st.getAvatar();
                } else {
                    personalImage = st.getAvatar();
                    ImageIcon icon = new ImageIcon(getClass().getResource("/images/MaleStudent.png"));
                    jlbAvatar.setIcon(icon);
                }
            }
        } catch (Exception e) {
        }
    } 
    
    public boolean updateInforStudent(byte[] personalImage){
        try {
            Person st = new Person();
            st.setId(jtfIdStudent.getText());
            st.setName(jtfName.getText());
            st.setBrithday(convertDateToDateSql(jBrithday.getDate()));
            st.setGender(jrbtnMale.isSelected() ? true : false);
            st.setStatus(jCheckBox.isSelected());
            st.setAddress(jAddress.getText());
            st.setEmail(jtfEmail.getText());
            st.setPhone(jtfPhone.getText());
            st.setAvatar(personalImage);
            st.setAccount_username(jtfIdStudent.getText());
          
            if (statusEdit){
                return studentService.updateStudent(st);             
            } else {
                AccountService accountService = new AccountServiceImpl();
                Account account = new Account();
                account.setUsername(jtfIdStudent.getText());
                account.setPassword("1234");
                account.setPosition("Học Viên");
                return (accountService.inserAcount(account)) ? studentService.inserStudent(st) : false;
            }              
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private java.sql.Date convertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
