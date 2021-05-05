/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.qlhv.main;

import com.appdesktop.qlhv.view.DangNhapJDialog;
import com.appdesktop.qlhv.view.MainJFrame;

/**
 *
 * @author MinhPhu
 */
public class Main {
    public static void main(String[] args) {
        //new MainJFrame().setVisible(true);
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng nhập hệ thống!");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(dialog);
        dialog.setVisible(true);
        
    }
}
