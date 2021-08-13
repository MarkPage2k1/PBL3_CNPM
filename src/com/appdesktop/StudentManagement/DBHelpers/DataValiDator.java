package com.appdesktop.StudentManagement.DBHelpers;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class DataValiDator {
    public static void valiDateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
        if (field.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
    }
    
    public static void valiDateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
        String password = new String(field.getPassword());
        if (password.equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
    }
    public static void valiDateEmpty(JTextArea field, StringBuilder sb, String errorMessage) {
        if (field.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
    }

    public static void checkDateValid(StringBuilder sb, String errorMessage, JDateChooser dateStart, JDateChooser dateEnd)
    {
        if (dateStart.getDate().compareTo(dateEnd.getDate()) > 0)
            sb.append(errorMessage).append("\n");
    }
}
