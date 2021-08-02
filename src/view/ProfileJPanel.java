package view;

import com.appdesktop.StudentManagement.DBHelpers.DataValiDator;
import com.appdesktop.StudentManagement.DBHelpers.ImageHelper;
import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.DBHelpers.sharedData;
import com.appdesktop.StudentManagement.Model.Person;
import com.appdesktop.StudentManagement.Service.AdminService;
import com.appdesktop.StudentManagement.Service.AdminServiceImpl;
import com.appdesktop.StudentManagement.Service.StudentService;
import com.appdesktop.StudentManagement.Service.StudentServiceImpl;
import com.appdesktop.StudentManagement.Service.TeacherService;
import com.appdesktop.StudentManagement.Service.TeacherServiceImpl;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author MinhPhu
 */
public class ProfileJPanel extends javax.swing.JPanel {

    private MainJFrame parentForm;
    private byte[] personalImage;
    private final String POSITION = sharedData.userLogin.getPosition();
    
    public ProfileJPanel() throws Exception {
        initComponents();
        if ("Giảng Viên".equals(POSITION)){
            LoadInforUserTeacher();
        } else if ("Học Viên".equals(POSITION)){
            LoadInforUserStudent();
        } else if ("Admin".equals(POSITION)){
            LoadInforUserAdmin();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateBrith = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jrbtnMale = new javax.swing.JRadioButton();
        jrbtnFemale = new javax.swing.JRadioButton();
        jCheck = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfProfileEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfProfilePhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAddress = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jlbAvatar = new javax.swing.JLabel();
        btnLoadImg = new javax.swing.JButton();
        btnProfileUpdate = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Thông tin cá nhân");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mã số");

        jtfID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Họ tên");

        jtfName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Giới tính");

        buttonGroup1.add(jrbtnMale);
        jrbtnMale.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbtnMale.setSelected(true);
        jrbtnMale.setText("Nam");

        buttonGroup1.add(jrbtnFemale);
        jrbtnFemale.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbtnFemale.setText("Nữ");

        jCheck.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheck.setText("Kích hoạt");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tình trạng");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Số điện thoại");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Địa chỉ");

        jAddress.setColumns(20);
        jAddress.setRows(5);
        jScrollPane1.setViewportView(jAddress);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jlbAvatar.setBackground(new java.awt.Color(204, 204, 204));
        jlbAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MaleStudent.png"))); // NOI18N
        jlbAvatar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnLoadImg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLoadImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/openfile16.png"))); // NOI18N
        btnLoadImg.setText("Mở ảnh");
        btnLoadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoadImg)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLoadImg)
                .addContainerGap())
        );

        btnProfileUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnProfileUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit16.png"))); // NOI18N
        btnProfileUpdate.setText("Cập nhật");
        btnProfileUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileUpdateActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Avatar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateBrith, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfID, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jtfName))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jrbtnMale)
                                        .addGap(35, 35, 35)
                                        .addComponent(jrbtnFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfProfileEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnProfileUpdate))
                                    .addComponent(jtfProfilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfProfileEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProfileUpdate)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfProfilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateBrith, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jrbtnFemale)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jrbtnMale)
                                .addComponent(jLabel5)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jCheck))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void LoadInforUserAdmin() throws IOException, Exception {
        String id = sharedData.userLogin.getUsername();
        AdminService adminService = new AdminServiceImpl();
        Person ps = adminService.getAdmin(id);
        if (ps != null) {
            
            jtfID.setText(ps.getId());
            jtfID.setEnabled(false);
            jtfName.setText(ps.getName());
            jtfName.setEnabled(false);
            jDateBrith.setDate(ps.getBrithday());
            jDateBrith.setEnabled(false);
            if (ps.isGender() == true) {
                jrbtnMale.setSelected(true);
            } else {
                jrbtnFemale.setSelected(true);
            }
            jrbtnMale.setEnabled(false);
            jrbtnFemale.setEnabled(false);
            jCheck.setSelected(ps.isStatus());
            jCheck.setEnabled(false);
            jAddress.setText(ps.getAddress());
            jAddress.setEnabled(false);
            jtfProfileEmail.setText(ps.getEmail());
            jtfProfilePhone.setText(ps.getPhone());

            if (ps.getAvatar()!= null) {
                Image img = ImageHelper.creImageFromByteArray(ps.getAvatar(), "jpg");
                jlbAvatar.setIcon(new ImageIcon(img));
                personalImage = ps.getAvatar();
            } else {
                personalImage = ps.getAvatar();
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/MaleStudent.png"));
                jlbAvatar.setIcon(icon);
            }

        }
    }
    
    private void LoadInforUserStudent() throws IOException, Exception {
        String id = sharedData.userLogin.getUsername();
        StudentService studentService = new StudentServiceImpl();
        Person ps = studentService.getStudent(id);

        if (ps != null) {
            
            jtfID.setText(ps.getId());
            jtfID.setEnabled(false);
            jtfName.setText(ps.getName());
            jtfName.setEnabled(false);
            jDateBrith.setDate(ps.getBrithday());
            jDateBrith.setEnabled(false);
            if (ps.isGender() == true) {
                jrbtnMale.setSelected(true);
            } else {
                jrbtnFemale.setSelected(true);
            }
            jrbtnMale.setEnabled(false);
            jrbtnFemale.setEnabled(false);
            jCheck.setSelected(ps.isStatus());
            jCheck.setEnabled(false);
            jAddress.setText(ps.getAddress());
            jAddress.setEnabled(false);
            jtfProfileEmail.setText(ps.getEmail());
            jtfProfilePhone.setText(ps.getPhone());

            if (ps.getAvatar()!= null) {
                Image img = ImageHelper.creImageFromByteArray(ps.getAvatar(), "jpg");
                jlbAvatar.setIcon(new ImageIcon(img));
                personalImage = ps.getAvatar();
            } else {
                personalImage = ps.getAvatar();
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/MaleStudent.png"));
                jlbAvatar.setIcon(icon);
            }

        }
    }
    
    private void LoadInforUserTeacher() throws IOException, Exception {
        String id = sharedData.userLogin.getUsername();
        TeacherService teacherService = new TeacherServiceImpl();
        Person ps = teacherService.getIDTeacher(id);

        if (ps != null) {
            
            jtfID.setText(ps.getId());
            jtfID.setEnabled(false);
            jtfName.setText(ps.getName());
            jtfName.setEnabled(false);
            jDateBrith.setDate(ps.getBrithday());
            jDateBrith.setEnabled(false);
            if (ps.isGender() == true) {
                jrbtnMale.setSelected(true);
            } else {
                jrbtnFemale.setSelected(true);
            }
            jrbtnMale.setEnabled(false);
            jrbtnFemale.setEnabled(false);
            jCheck.setSelected(ps.isStatus());
            jCheck.setEnabled(false);
            jAddress.setText(ps.getAddress());
            jAddress.setEnabled(false);
            jtfProfileEmail.setText(ps.getEmail());
            jtfProfilePhone.setText(ps.getPhone());

            if (ps.getAvatar()!= null) {
                Image img = ImageHelper.creImageFromByteArray(ps.getAvatar(), "jpg");
                jlbAvatar.setIcon(new ImageIcon(img));
                personalImage = ps.getAvatar();
            } else {
                personalImage = ps.getAvatar();
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/MaleStudent.png"));
                jlbAvatar.setIcon(icon);
            }

        }
    }
    
    private void btnProfileUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileUpdateActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValiDator.valiDateEmpty(jtfProfileEmail, sb, "Email viên không được để trống");
        DataValiDator.valiDateEmpty(jtfProfilePhone, sb, "Số điện thoại không được để trống");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        
        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn cập nhật lại thông tin không?", "Hỏi") 
                == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            if ("Giảng Viên".equals(POSITION)){
                updateProfileTeacher();
            } else if ("Học Viên".equals(POSITION)){
                updateProfileStudent();
            } else if ("Admin".equals(POSITION)){
                updateProfileAdmin();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnProfileUpdateActionPerformed

    private void updateProfileAdmin(){
        Person ps = new Person();
        ps.setId(jtfID.getText());
        ps.setEmail(jtfProfileEmail.getText());
        ps.setPhone(jtfProfilePhone.getText());
        ps.setAvatar(personalImage);

        AdminService adminService = new AdminServiceImpl();
        if (adminService.updateProfile(ps)) {
            MessageDialogHelper.showMessageDialog(parentForm, "Thông tin đã được cập nhật!", "Thông báo");
        }
        else {
            MessageDialogHelper.showConfirmDialog(parentForm, "Thông tin cập nhật không thành công!", "Cảnh báo");
        }
    }
    private void updateProfileTeacher(){
        Person ps = new Person();
        ps.setId(jtfID.getText());
        ps.setEmail(jtfProfileEmail.getText());
        ps.setPhone(jtfProfilePhone.getText());
        ps.setAvatar(personalImage);

        TeacherService teacherService = new TeacherServiceImpl();
        if (teacherService.updateProfile(ps)) {
            MessageDialogHelper.showMessageDialog(parentForm, "Thông tin đã được cập nhật!", "Thông báo");
        }
        else {
            MessageDialogHelper.showConfirmDialog(parentForm, "Thông tin cập nhật không thành công!", "Cảnh báo");
        }
    }
    private void updateProfileStudent(){
        Person ps = new Person();
        ps.setId(jtfID.getText());
        ps.setEmail(jtfProfileEmail.getText());
        ps.setPhone(jtfProfilePhone.getText());
        ps.setAvatar(personalImage);

        StudentService studentService = new StudentServiceImpl();
        if (studentService.updateProfile(ps)) {
            MessageDialogHelper.showMessageDialog(parentForm, "Thông tin đã được cập nhật!", "Thông báo");
        }
        else {
            MessageDialogHelper.showConfirmDialog(parentForm, "Thông tin cập nhật không thành công!", "Cảnh báo");
        }
    }
    private void btnLoadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImgActionPerformed
        JFileChooser choose = new JFileChooser();
        choose.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()){
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }
            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        
        if (choose.showOpenDialog(parentForm) == JFileChooser.CANCEL_OPTION){
            return;
        }
        
        File file = choose.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 140, 160);
            ImageIcon resizedIcon = new ImageIcon(img);
            jlbAvatar.setIcon(resizedIcon);
            personalImage = ImageHelper.toBytoArray(img, "jpg");
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnLoadImgActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadImg;
    private javax.swing.JButton btnProfileUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea jAddress;
    private javax.swing.JCheckBox jCheck;
    private com.toedter.calendar.JDateChooser jDateBrith;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbAvatar;
    private javax.swing.JRadioButton jrbtnFemale;
    private javax.swing.JRadioButton jrbtnMale;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfProfileEmail;
    private javax.swing.JTextField jtfProfilePhone;
    // End of variables declaration//GEN-END:variables
}
