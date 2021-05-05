package com.appdesktop.qlhv.controller;

import com.appdesktop.qlhv.model.TaiKhoan;
import com.appdesktop.qlhv.service.TaiKhoanService;
import com.appdesktop.qlhv.service.TaiKhoanServiceImpl;
import com.appdesktop.qlhv.view.MainJFrame;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TaiKhoanController {
    private Dialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jpwMatKhau;
    private JLabel jlbMsg;  

    private TaiKhoanService taiKhoanService = null;
    
    public TaiKhoanController(Dialog dialog, JButton btnSubmit, JTextField jtfTenDangNhap, JPasswordField jpwMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jpwMatKhau = jpwMatKhau;
        this.jlbMsg = jlbMsg;
        
        taiKhoanService = new TaiKhoanServiceImpl();
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (jtfTenDangNhap.getText().length() == 0 || jpwMatKhau.getText().length() == 0) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {   
                        TaiKhoan taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(), jpwMatKhau.getText());
                        if (taiKhoan == null) {
                            jlbMsg.setText("Tên đăng nhập hoặc mật khẩu không đúng!");                          
                        } else {
                            if (!taiKhoan.isTinhTrang()) {
                                jlbMsg.setText("Tài khoản này đang tạm thời bị khóa!"); 
                            } else {
                                dialog.dispose();
                                MainJFrame frame = new MainJFrame();
                                frame.setTitle("QUẢN LÝ HỌC VIÊN");
                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                frame.setVisible(true);
                            }
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
    }
    
}

