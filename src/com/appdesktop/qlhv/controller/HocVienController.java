package com.appdesktop.qlhv.controller;

import com.appdesktop.qlhv.model.HocVien;
import com.appdesktop.qlhv.service.HocVienService;
import com.appdesktop.qlhv.service.HocVienServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class HocVienController {
    
    private JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfSoDienThoai;
    private JRadioButton jtfGioiTinhNam;
    private JRadioButton jtfGioiTinhNu;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbKichHoat;
    private JLabel jlbMsg;

    private HocVien hocVien = null;

    private HocVienService hocVienService = null;
    
    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen,
            JDateChooser jdcNgaySinh, JTextField jtfSoDienThoai, JRadioButton jtfGioiTinhNam, JRadioButton jtfGioiTinhNu,
            JTextArea jtaDiaChi, JCheckBox jcbKichHoat, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtfGioiTinhNam = jtfGioiTinhNam;
        this.jtfGioiTinhNu = jtfGioiTinhNu;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbKichHoat = jcbKichHoat;
        this.jlbMsg = jlbMsg;

        this.hocVienService = new HocVienServiceImpl();
    }

    public void setView(HocVien hocVien) {
        this.hocVien = hocVien;
        // set data
        jtfMaHocVien.setText("#" + hocVien.getMaHocVien());
        jtfHoTen.setText(hocVien.getHoTen());
        jdcNgaySinh.setDate(hocVien.getNgaySinh());
        if (hocVien.isGioiTinh()) {
            jtfGioiTinhNam.setSelected(true);
        } else {
            jtfGioiTinhNu.setSelected(true);
        }
        jtfSoDienThoai.setText(hocVien.getSoDienThoai());
        jtaDiaChi.setText(hocVien.getDiaChi());
        jcbKichHoat.setSelected(hocVien.isTinhTrang());
        // set event
        setEvent();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        hocVien.setHoTen(jtfHoTen.getText().trim());
                        hocVien.setNgaySinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                        hocVien.setSoDienThoai(jtfSoDienThoai.getText());
                        hocVien.setDiaChi(jtaDiaChi.getText());
                        hocVien.setGioiTinh(jtfGioiTinhNam.isSelected());
                        hocVien.setTinhTrang(jcbKichHoat.isSelected());
                        if (showDialog()) {
                            int lastId = hocVienService.createOrUpdate(hocVien);
                            if (lastId != 0) {
                                hocVien.setMaHocVien(lastId);
                                jtfMaHocVien.setText("#" + hocVien.getMaHocVien());
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
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

    private boolean checkNotNull() {
        return jtfHoTen.getText() != null && !jtfHoTen.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}