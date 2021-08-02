package view;

import java.io.File;
import java.io.FileOutputStream;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.DBHelpers.sharedData;
import com.appdesktop.StudentManagement.Model.Person;
import com.appdesktop.StudentManagement.Service.StudentService;
import com.appdesktop.StudentManagement.Service.StudentServiceImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.apache.poi.ss.usermodel.BorderStyle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainJFrame extends javax.swing.JFrame {
    private ProfileJPanel menuProfileJpanel;
    private AnalytisJPanel menuAnalytisJpanel;
    private StudentManagementJPanel menuSMJpanel;
    private TeacherManagementJPanel menuTMJpanel;
    private MarkManagementJPanel menuMarkMJpanel;
    private FormManagerJPanel formManagerJPanel;
    private FormManagerSub formManagerSub;
    private RegisterForClassJPanel registerForClassJPanel;
    public String IdUserLogin;

    public MainJFrame() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/linux.png"));
        btnMenuProfile.setIcon(icon);
//        setLocationRelativeTo(null); 
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnMenuProfile = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btn3 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnMenuClassManagenent = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnMenuMark = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jMenuChart = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        menubtnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbPosition = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbIDUser = new javax.swing.JLabel();
        tableMainBoard = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuManager = new javax.swing.JMenu();
        jMenuSM = new javax.swing.JMenuItem();
        jMenuTM = new javax.swing.JMenuItem();
        jMenuSubject = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuManagementMark = new javax.swing.JMenuItem();
        jMenuRegisterForClass = new javax.swing.JMenuItem();
        jMenuExport = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuAnalytis = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnMenuProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N
        btnMenuProfile.setText("Trang cá nhân");
        btnMenuProfile.setFocusable(false);
        btnMenuProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuProfile.setMaximumSize(new java.awt.Dimension(89, 57));
        btnMenuProfile.setMinimumSize(new java.awt.Dimension(89, 57));
        btnMenuProfile.setPreferredSize(new java.awt.Dimension(89, 57));
        btnMenuProfile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMenuProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuProfileActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMenuProfile);
        jToolBar1.add(jSeparator1);

        btn1.setText("btn1");
        btn1.setFocusable(false);
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btn1);
        jToolBar1.add(jSeparator2);

        btn2.setText("btn2");
        btn2.setFocusable(false);
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jToolBar1.add(btn2);
        jToolBar1.add(jSeparator3);

        btn3.setText("btn3");
        btn3.setFocusable(false);
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jToolBar1.add(btn3);
        jToolBar1.add(jSeparator4);

        btnMenuClassManagenent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/presentation32.png"))); // NOI18N
        btnMenuClassManagenent.setText("Quản lý lớp học");
        btnMenuClassManagenent.setFocusable(false);
        btnMenuClassManagenent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuClassManagenent.setMaximumSize(new java.awt.Dimension(89, 57));
        btnMenuClassManagenent.setMinimumSize(new java.awt.Dimension(89, 57));
        btnMenuClassManagenent.setPreferredSize(new java.awt.Dimension(89, 57));
        btnMenuClassManagenent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMenuClassManagenent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuClassManagenentActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMenuClassManagenent);
        jToolBar1.add(jSeparator5);

        btnMenuMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/score.png"))); // NOI18N
        btnMenuMark.setText("Quản lý điểm");
        btnMenuMark.setFocusable(false);
        btnMenuMark.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuMark.setMaximumSize(new java.awt.Dimension(89, 57));
        btnMenuMark.setMinimumSize(new java.awt.Dimension(89, 57));
        btnMenuMark.setPreferredSize(new java.awt.Dimension(89, 57));
        btnMenuMark.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMenuMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuMarkActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMenuMark);
        jToolBar1.add(jSeparator6);

        jMenuChart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chartAnalytics.png"))); // NOI18N
        jMenuChart.setText("Thống kê");
        jMenuChart.setFocusable(false);
        jMenuChart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuChart.setMaximumSize(new java.awt.Dimension(89, 57));
        jMenuChart.setMinimumSize(new java.awt.Dimension(89, 57));
        jMenuChart.setPreferredSize(new java.awt.Dimension(89, 57));
        jMenuChart.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuChartActionPerformed(evt);
            }
        });
        jToolBar1.add(jMenuChart);
        jToolBar1.add(jSeparator7);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jButton4.setText("In DS sinh viên");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(89, 57));
        jButton4.setMinimumSize(new java.awt.Dimension(89, 57));
        jButton4.setPreferredSize(new java.awt.Dimension(89, 57));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator8);

        menubtnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        menubtnLogout.setText("Đăng xuất");
        menubtnLogout.setFocusable(false);
        menubtnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menubtnLogout.setMaximumSize(new java.awt.Dimension(89, 57));
        menubtnLogout.setMinimumSize(new java.awt.Dimension(89, 57));
        menubtnLogout.setPreferredSize(new java.awt.Dimension(89, 57));
        menubtnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menubtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtnLogoutActionPerformed(evt);
            }
        });
        jToolBar1.add(menubtnLogout);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Mã số:");

        jlbPosition.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbPosition.setForeground(new java.awt.Color(255, 153, 102));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Chức vụ:");

        jlbIDUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbIDUser.setForeground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(199, 199, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jlbIDUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBar1.add(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableMainBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tableMainBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Hệ thống");

        jMenuManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system16.png"))); // NOI18N
        jMenuManager.setText("Quản lý");

        jMenuSM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student16.png"))); // NOI18N
        jMenuSM.setText("Quản lý sinh viên");
        jMenuSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSMActionPerformed(evt);
            }
        });
        jMenuManager.add(jMenuSM);

        jMenuTM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teacher16.png"))); // NOI18N
        jMenuTM.setText("Quản lý giảng viên");
        jMenuTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTMActionPerformed(evt);
            }
        });
        jMenuManager.add(jMenuTM);

        jMenuSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/course16.png"))); // NOI18N
        jMenuSubject.setText("Quản lý khóa học");
        jMenuSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSubjectActionPerformed(evt);
            }
        });
        jMenuManager.add(jMenuSubject);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/class16.png"))); // NOI18N
        jMenuItem4.setText("Quản lý lớp học");
        jMenuManager.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/class_teacher16.png"))); // NOI18N
        jMenuItem5.setText("Quản lý lớp học phần");
        jMenuManager.add(jMenuItem5);

        jMenuManagementMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/score16.png"))); // NOI18N
        jMenuManagementMark.setText("Quản lý điểm");
        jMenuManagementMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuManagementMarkActionPerformed(evt);
            }
        });
        jMenuManager.add(jMenuManagementMark);

        jMenu1.add(jMenuManager);

        jMenuRegisterForClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add16.png"))); // NOI18N
        jMenuRegisterForClass.setText("Đăng ký lớp học phần");
        jMenuRegisterForClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegisterForClassActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuRegisterForClass);

        jMenuExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer16.png"))); // NOI18N
        jMenuExport.setText("In danh sách");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export16.png"))); // NOI18N
        jMenuItem7.setText("In danh sách sinh viên");
        jMenuExport.add(jMenuItem7);

        jMenu1.add(jMenuExport);

        jMenuAnalytis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chart_analytics16.png"))); // NOI18N
        jMenuAnalytis.setText("Thống kê");
        jMenu1.add(jMenuAnalytis);

        jMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jMenuExit.setText("Thoát");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Trợ giúp");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        processLoginSecusessful();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void menubtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtnLogoutActionPerformed
        this.dispose();
        LoginJDialog loginDialog = new LoginJDialog(this, true);
//        // Logout thi an form chinh
//        this.setVisible(false);
        loginDialog.setVisible(true);
//        processLoginSecusessful();
//        // Login lại thì hiện form chính
//        
//        this.setVisible(true);
        
        //btnMenuProfileActionPerformed(evt);       
    }//GEN-LAST:event_menubtnLogoutActionPerformed

    private void btnMenuProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuProfileActionPerformed
        if (menuProfileJpanel == null) {
            try {
                menuProfileJpanel = new ProfileJPanel();
            } catch (Exception ex) {
                Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/menuProfile.png"));
            tableMainBoard.addTab("Thông tin cá nhân ", icon, menuProfileJpanel, "Thông tin cá nhân");
        }
        tableMainBoard.setSelectedComponent(menuProfileJpanel);
    }//GEN-LAST:event_btnMenuProfileActionPerformed

    private void jMenuChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuChartActionPerformed
        if (menuAnalytisJpanel != null) {
            tableMainBoard.remove(menuAnalytisJpanel);
        }
        try {
            menuAnalytisJpanel = new AnalytisJPanel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/chart_analytics16.png"));
        tableMainBoard.addTab("Thống kê ", icon, menuAnalytisJpanel, "Thống kê");            
        tableMainBoard.setSelectedComponent(menuAnalytisJpanel);
    }//GEN-LAST:event_jMenuChartActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Học viên");

            XSSFRow row = null;
            Cell cell = null;
            CellStyle cellStyleTitle = createStyleForTitle(spreadsheet);
            CellStyle cellStyleHeader = createStyleForHeader(spreadsheet);
            row = spreadsheet.createRow((short) 2);
            // độ cao của hàng
            row.setHeight((short) 500);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("DANH SÁCH HỌC VIÊN");
            cell.setCellStyle(cellStyleTitle);

            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã sinh viên");
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Họ và tên");
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày sinh");
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Giới tính");        
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa chỉ");
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tình trạng");
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Email");
            cell.setCellStyle(cellStyleHeader);
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell.setCellStyle(cellStyleHeader);

            StudentService stService = new StudentServiceImpl();
            List<Person> listItem = stService.getListExport();

            for (int i = 0; i < listItem.size(); i++) {
                Person st = listItem.get(i);
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(st.getId());
                row.createCell(2).setCellValue(st.getName());
                row.createCell(3).setCellValue(st.getBrithday().toString());
                row.createCell(4).setCellValue(st.isGender() ? "Nam" : "Nữ");
                row.createCell(5).setCellValue(st.getAddress());
                row.createCell(6).setCellValue(st.isStatus() ? "Bình thường" : "Khóa");
                row.createCell(7).setCellValue(st.getEmail());
                row.createCell(8).setCellValue(st.getPhone());            
                spreadsheet.autoSizeColumn(i);
            }
            FileOutputStream out = new FileOutputStream(new File("D:/hv.xlsx"));
            workbook.write(out);
            out.close();
            MessageDialogHelper.showMessageDialog(jPanel1, "Danh sách sinh viên đã được in ra thành công!\nĐịa chỉ: D:/hv.xlsx", "Thông báo!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnMenuMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuMarkActionPerformed
        
    }//GEN-LAST:event_btnMenuMarkActionPerformed

    private void btnMenuClassManagenentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuClassManagenentActionPerformed
        if ( formManagerJPanel != null) {
            tableMainBoard.remove(formManagerJPanel);
        }
        try {
            formManagerJPanel = new FormManagerJPanel();
        } catch (Exception ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/class16.png"));
        tableMainBoard.addTab("Quản lý lớp học ", icon, formManagerJPanel, "Quản lý lớp học");          
        tableMainBoard.setSelectedComponent(formManagerJPanel);
    }//GEN-LAST:event_btnMenuClassManagenentActionPerformed

    private void jMenuTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTMActionPerformed
       if (menuTMJpanel != null) {
           tableMainBoard.remove(menuTMJpanel);
       }
        try {
            menuTMJpanel = new TeacherManagementJPanel();
        } catch (Exception ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/teacher16.png"));
        tableMainBoard.addTab("Quản lý giảng viên ", icon, menuTMJpanel, "Quản lý giảng viên");          
        tableMainBoard.setSelectedComponent(menuTMJpanel);
    }//GEN-LAST:event_jMenuTMActionPerformed

    private void jMenuSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSMActionPerformed
        if (menuSMJpanel != null) {
            tableMainBoard.remove(menuSMJpanel);
        }
        try {
            menuSMJpanel = new StudentManagementJPanel();
        } catch (Exception ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/student16.png"));
        tableMainBoard.addTab("Quản lý sinh viên ", icon, menuSMJpanel, "Quản lý sinh viên");          
        tableMainBoard.setSelectedComponent(menuSMJpanel);
    }//GEN-LAST:event_jMenuSMActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if ("Admin".equals(sharedData.userLogin.getPosition())){
            jMenuSMActionPerformed(evt);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void jMenuRegisterForClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegisterForClassActionPerformed
        if (registerForClassJPanel != null) {
            tableMainBoard.remove(registerForClassJPanel);
        }
        try {
            registerForClassJPanel = new RegisterForClassJPanel();
        } catch (Exception ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/add16.png"));
        tableMainBoard.addTab("Đăng ký lớp học phần ", icon, registerForClassJPanel, "Đăng ký lớp học phần");          
        tableMainBoard.setSelectedComponent(registerForClassJPanel);
    }//GEN-LAST:event_jMenuRegisterForClassActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if ("Admin".equalsIgnoreCase(sharedData.userLogin.getPosition())){
            jMenuTMActionPerformed(evt);
        } else if ("Học Viên".equalsIgnoreCase(sharedData.userLogin.getPosition()) || 
            "Giảng Viên".equalsIgnoreCase(sharedData.userLogin.getPosition())    ){
           jMenuRegisterForClassActionPerformed(evt);
        }   
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if ("Admin".equalsIgnoreCase(sharedData.userLogin.getPosition())){
            jMenuSubjectActionPerformed(evt);
        } else if ("Giảng Viên".equalsIgnoreCase(sharedData.userLogin.getPosition())    ){
            jMenuManagementMarkActionPerformed(evt);
        }  
    }//GEN-LAST:event_btn3ActionPerformed

    private void jMenuSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSubjectActionPerformed
        if ( formManagerSub != null) {
            tableMainBoard.remove(formManagerSub);
        }
        try {
            formManagerSub = new FormManagerSub();
        } catch (Exception ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/course16.png"));
        tableMainBoard.addTab("Quản lý khóa học ", icon, formManagerSub, "Quản lý khóa học");          
        tableMainBoard.setSelectedComponent(formManagerSub);
    }//GEN-LAST:event_jMenuSubjectActionPerformed

    private void jMenuManagementMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuManagementMarkActionPerformed
        if (menuMarkMJpanel != null) {
            tableMainBoard.remove(menuMarkMJpanel);
        }
        try {
                menuMarkMJpanel = new MarkManagementJPanel();
            } catch (Exception ex) {
                Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/score16.png"));
        tableMainBoard.addTab("Quản lý điểm ", icon, menuMarkMJpanel, "Quản lý điểm");  
        tableMainBoard.setSelectedComponent(menuMarkMJpanel);
    }//GEN-LAST:event_jMenuManagementMarkActionPerformed
    private CellStyle createStyleForTitle(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
    
    private CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 12); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
    
    private void processLoginSecusessful() {  
//        tableMainBoard.removeAll();
//       menuProfileJpanel = null;
//       menuSMJpanel = null;
//        menuAnalytisJpanel = null;
        //btnMenuProfileActionPerformed();
        btnMenuProfileActionPerformed(null);
        jlbIDUser.setText(sharedData.userLogin.getUsername().toUpperCase());
        jlbPosition.setText(sharedData.userLogin.getPosition().toUpperCase());
//        tableMainBoard.removeAll();
        if ("Admin".equalsIgnoreCase(sharedData.userLogin.getPosition())){
            ImageIcon icon = null;
            // set button 1
            btn1.setText("Quản lý sinh viên");
            icon = new ImageIcon(getClass().getResource("/images/graduated32.png"));
            btn1.setIcon(icon);
            // set button 2
            btn2.setText("Quản lý giảng viên");
            icon = new ImageIcon(getClass().getResource("/images/teacher32.png"));
            btn2.setIcon(icon);
            // set button 3
            btn3.setText("Quản lý khóa học");
            icon = new ImageIcon(getClass().getResource("/images/course32.png"));
            btn3.setIcon(icon);
            // set button ManageScore
            btnMenuMark.setText("Quản lý lớp học phần");
            icon = new ImageIcon(getClass().getResource("/images/add32.png"));
            btnMenuMark.setIcon(icon);
            jMenuRegisterForClass.setVisible(false);
            
        } else if ("Giảng Viên".equalsIgnoreCase(sharedData.userLogin.getPosition())){
            ImageIcon icon = null;
            // set button 1 
            btn1.setText("Thông tin lớp học phần");
            icon = new ImageIcon(getClass().getResource("/images/presentation32.png"));
            btn1.setIcon(icon);
            // set button 2
            btn2.setText("Đăng ký lớp học phần");
            icon = new ImageIcon(getClass().getResource("/images/membership32.png"));
            btn2.setIcon(icon);
            // set button 3
            btn3.setText("Quản lý điểm");
            icon = new ImageIcon(getClass().getResource("/images/score.png"));
            btn3.setIcon(icon);
            
            // Disipose button
            jSeparator4.setVisible(false);
            btnMenuClassManagenent.setVisible(false);
            jSeparator5.setVisible(false);
            btnMenuMark.setVisible(false);
            jSeparator6.setVisible(false);
            jMenuChart.setVisible(false);
            jSeparator7.setVisible(false);
            jButton4.setVisible(false);
            jMenuManager.setVisible(false);
            jMenuExport.setVisible(false);
            jMenuAnalytis.setVisible(false);
            
        } if ("Học Viên".equalsIgnoreCase(sharedData.userLogin.getPosition())){
            ImageIcon icon = null;
            // set button 1
            btn1.setText("Thông tin lớp học phần");
            icon = new ImageIcon(getClass().getResource("/images/presentation32.png"));
            btn1.setIcon(icon);
            // set button 2
            btn2.setText("Đăng ký lớp học phần");
            icon = new ImageIcon(getClass().getResource("/images/membership32.png"));
            btn2.setIcon(icon);
            
            // Disipose button
            jSeparator3.setVisible(false);
            btn3.setVisible(false);
            jSeparator4.setVisible(false);
            btnMenuClassManagenent.setVisible(false);
            jSeparator5.setVisible(false);
            btnMenuMark.setVisible(false);
            jSeparator6.setVisible(false);
            jMenuChart.setVisible(false);
            jSeparator7.setVisible(false);
            jButton4.setVisible(false);
            jMenuManager.setVisible(false);
            jMenuExport.setVisible(false);
            jMenuAnalytis.setVisible(false);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btnMenuClassManagenent;
    private javax.swing.JButton btnMenuMark;
    private javax.swing.JButton btnMenuProfile;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAnalytis;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jMenuChart;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuExport;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuManagementMark;
    private javax.swing.JMenu jMenuManager;
    private javax.swing.JMenuItem jMenuRegisterForClass;
    private javax.swing.JMenuItem jMenuSM;
    private javax.swing.JMenuItem jMenuSubject;
    private javax.swing.JMenuItem jMenuTM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel jlbIDUser;
    private javax.swing.JLabel jlbPosition;
    private javax.swing.JButton menubtnLogout;
    private javax.swing.JTabbedPane tableMainBoard;
    // End of variables declaration//GEN-END:variables
}
