package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.DBHelpers.sharedData;
import com.appdesktop.StudentManagement.Model.Account;
import com.appdesktop.StudentManagement.Service.AccountService;
import com.appdesktop.StudentManagement.Service.AccountServiceImpl;
import javax.swing.JDialog;
import view.MainJFrame;

public class AccountController {
    private AccountService accountService = null;
    private JDialog dialog;

    public AccountController(JDialog dialog) {
        this.dialog = dialog;
        accountService = new AccountServiceImpl();
    }
    public void Login(String username, String password){
        Account account = accountService.login(username, password);
        if (account == null) {
            MessageDialogHelper.showErrorDialog(dialog, "Tên đăng nhập hay mật khẩu sai!", "Lỗi");
        } else {
            sharedData.userLogin = account;  
            dialog.dispose();          
            newMainForm();
        }
    }

    private void newMainForm() {
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
                new MainJFrame().setVisible(true);
            }
        });
    }
}
