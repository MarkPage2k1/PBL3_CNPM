package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.ImageHelper;
import com.appdesktop.StudentManagement.Model.Account;
import com.appdesktop.StudentManagement.Model.Person;
import com.appdesktop.StudentManagement.Service.AccountService;
import com.appdesktop.StudentManagement.Service.AccountServiceImpl;
import com.appdesktop.StudentManagement.Service.TeacherService;
import com.appdesktop.StudentManagement.Service.TeacherServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TeacherController {
    private byte[] personalImage;
    private boolean statusEdit;
    private TeacherService teacherService = null;
    private String id = null;
    private JTextField jtfIdTeacher, jtfName, jtfEmail, jtfPhone;
    private JDateChooser jBrithday;
    private JRadioButton jrbtnMale, jrbtnFemale;
    private JCheckBox jCheckBox;
    private JTextArea jAddress;
    private JLabel jlbAvatar;
    
    public TeacherController(String idTeacher, JTextField jtfIdTeacher, JTextField jtfName, JDateChooser jBrithday,
            JRadioButton jrbtnMale, JRadioButton jrbtnFemale, JCheckBox jCheckBox, JTextArea jAddress,
            JTextField jtfEmail, JTextField jtfPhone, JLabel jlbAvatar, boolean statusEdit, byte[] personalImage) {
        this.id = idTeacher;
        this.jtfIdTeacher = jtfIdTeacher;
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
        this.setPersonalImage(personalImage);
        
        teacherService = new TeacherServiceImpl();
    }
    
    
    public byte[] getPersonalImage() {
        return personalImage;
    }


    public void setPersonalImage(byte[] personalImage) {
        this.personalImage = personalImage;
    }


    public void LoadInforTeacher() {
        try {
            Person tch = teacherService.getIDTeacher(id);

            if (tch != null) {
            
                jtfIdTeacher.setText(tch.getId());
                jtfIdTeacher.setEnabled(false);
                jtfName.setText(tch.getName());
                jBrithday.setDate(tch.getBrithday());
                if (tch.isGender() == true) {
                    jrbtnMale.setSelected(true);
                } else {
                    jrbtnFemale.setSelected(true);
                }
                jCheckBox.setSelected(tch.isStatus());
                jAddress.setText(tch.getAddress());
                jtfEmail.setText(tch.getEmail());
                jtfPhone.setText(tch.getPhone());

                if (tch.getAvatar()!= null) {
                    Image img = ImageHelper.creImageFromByteArray(tch.getAvatar(), "jpg");
                    jlbAvatar.setIcon(new ImageIcon(img));
                    setPersonalImage(tch.getAvatar());
                } else {
                    setPersonalImage(tch.getAvatar());
                    ImageIcon icon = new ImageIcon(getClass().getResource("/images/MaleStudent.png"));
                    jlbAvatar.setIcon(icon);
                }
            }
        } catch (Exception e) {
        }
    } 
    
    public boolean updateInforTeacher(byte[] personalImage){
        try {
            Person tch = new Person();
            tch.setId(jtfIdTeacher.getText());
            tch.setName(jtfName.getText());
            tch.setBrithday(convertDateToDateSql(jBrithday.getDate()));
            tch.setGender(jrbtnMale.isSelected() ? true : false);
            tch.setStatus(jCheckBox.isSelected());
            tch.setAddress(jAddress.getText());
            tch.setEmail(jtfEmail.getText());
            tch.setPhone(jtfPhone.getText());
            tch.setAvatar(personalImage);
            tch.setAccount_username(jtfIdTeacher.getText());
          
            if (statusEdit){
                return teacherService.updateTeacher(tch);             
            } else {
                AccountService accountService = new AccountServiceImpl();
                Account account = new Account();
                account.setUsername(jtfIdTeacher.getText());
                account.setPassword("1234");
                account.setPosition("Giảng Viên");
                return (accountService.inserAcount(account)) ? teacherService.inserTeacher(tch) : false;
            }              
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    private java.sql.Date convertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
