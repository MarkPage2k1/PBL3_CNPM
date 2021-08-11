package view;

import com.appdesktop.StudentManagement.Controller.ClassController;
import com.appdesktop.StudentManagement.Controller.Class_TeacherController;
import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.DBHelpers.sharedData;
import com.appdesktop.StudentManagement.Model.CBBItem;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static view.StudentManagementJPanel.idStudent;
import static view.StudentManagementJPanel.statusEdit;

public class MarkManagementJPanel extends javax.swing.JPanel {
    private DefaultTableModel tblModle;
    private TableRowSorter<TableModel> rowSorter = null;
    private MainJFrame parentForm;
    
    public static String idStudent;
    public static String nameStudent;
    public static String idClass;
    public static String nameClass;
    public static String idCourse;
    
    Class_TeacherController cTeacherController = null;
    
    public MarkManagementJPanel() {
        initComponents();
        cTeacherController = new Class_TeacherController(cbbClassOfTeacher, parentForm, jTableStudent, jtfSearch);
        cTeacherController.initTableStudent();
        cTeacherController.setCbbOfClass();
        cTeacherController.loadDataTableStudentOfClass(((CBBItem)cbbClassOfTeacher.getSelectedItem()).Value);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbbClassOfTeacher = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudent = new javax.swing.JTable();
        jtfSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        MarkUpdate = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Lớp học phần");

        cbbClassOfTeacher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbClassOfTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbClassOfTeacherActionPerformed(evt);
            }
        });

        jTableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableStudent);

        jtfSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton1.setText("Search");

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menuProfile.png"))); // NOI18N
        jButton2.setText("Xem thông tin");

        MarkUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MarkUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit16.png"))); // NOI18N
        MarkUpdate.setText("Cập nhật điểm");
        MarkUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbClassOfTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                        .addComponent(MarkUpdate)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)
                        .addGap(20, 20, 20))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbClassOfTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(MarkUpdate))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbClassOfTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbClassOfTeacherActionPerformed
  int index = cbbClassOfTeacher.getSelectedIndex();
        if (index >= 0) {
            cTeacherController.loadDataTableStudentOfClass(((CBBItem)cbbClassOfTeacher.getSelectedItem()).Value);
        }
    }//GEN-LAST:event_cbbClassOfTeacherActionPerformed

    private void MarkUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkUpdateActionPerformed
  try {
            int row = jTableStudent.getSelectedRow();
            int count = jTableStudent.getSelectedRowCount();
            if (count == 1) 
            {
                statusEdit = true;
                idStudent = (String) jTableStudent.getValueAt(row, 0);
                nameStudent = (String) jTableStudent.getValueAt(row, 1);
                idClass = (String) jTableStudent.getValueAt(row, 2);
                nameClass = (String) jTableStudent.getValueAt(row, 3);
                idCourse = (String) jTableStudent.getValueAt(row, 5);
                MarkOfStudentJDialog detailJDialog = new MarkOfStudentJDialog(parentForm, true);
                detailJDialog.setVisible(true);
                cTeacherController.loadDataTableStudentOfClass(((CBBItem)cbbClassOfTeacher.getSelectedItem()).Value);
            } else if (count < 1){
                MessageDialogHelper.showMessageDialog(parentForm, "Vui lòng chọn một sinh viên để chỉnh sửa", "Thông báo");
            } else {
                MessageDialogHelper.showMessageDialog(parentForm, "Bạn chọn quá nhiều sinh viên!\nVui lòng chọn một sinh viên để chỉnh sửa", "Thông báo");
            }
            
        } catch (Exception e) {
            MessageDialogHelper.showErrorDialog(parentForm,e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_MarkUpdateActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MarkUpdate;
    private javax.swing.JComboBox<Object> cbbClassOfTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableStudent;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
