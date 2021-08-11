package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.Model.Mark;
import com.appdesktop.StudentManagement.Service.MarkService;
import com.appdesktop.StudentManagement.Service.MarkServiceImpl;
import javax.swing.JTextField;

public class MarkController {

    private JTextField jtfMark1, jtfMark2, jtfMark3, jtfMark4, jtfMark10;
    private MarkService markService = null;

    String idCourse = null;
    String idStudent = null;

    final byte Add = 1;
    final byte Edit = 2;

    public MarkController(String idCourse, String idStudent, JTextField mark1, JTextField mark2, JTextField mark3, JTextField mark4, JTextField mark10) {
        this.idCourse = idCourse;
        this.idStudent = idStudent;
        this.jtfMark1 = mark1;
        this.jtfMark2 = mark2;
        this.jtfMark3 = mark3;
        this.jtfMark4 = mark4;
        this.jtfMark10 = mark10;
        markService = new MarkServiceImpl();
    }

    public void LoadMarkOfStudent() {
        try {
            Mark mark = markService.getMarkOfStudent(idCourse, idStudent);
            jtfMark1.setText(Double.toString(mark.getMark1()));
            jtfMark2.setText(Double.toString(mark.getMark2()));
            jtfMark3.setText(Double.toString(mark.getMark3()));
            CalMark();
        } catch (Exception e) {
        }
    }
    public void CalMark() {
        try {
            if (!(jtfMark1.getText().trim().equals("")) && !(jtfMark2.getText().trim().equals("")) && !(jtfMark3.getText().trim().equals(""))) {
                Double mark1 = Double.parseDouble(jtfMark1.getText());
                Double mark2 = Double.parseDouble(jtfMark2.getText());
                Double mark3 = Double.parseDouble(jtfMark3.getText());
                Double result = (double) Math.round((mark1 * 0.2 + mark2 * 0.2 + mark3 * 0.6) * 100) / 100;
                jtfMark10.setText(Double.toString(result));
                if (result < 4.0) {
                    jtfMark4.setText("0.0");
                } else if (result <= 4.9) {
                    jtfMark4.setText("1.0");
                } else if (result <= 5.4) {
                    jtfMark4.setText("1.5");
                } else if (result <= 5.9) {
                    jtfMark4.setText("2.0");
                } else if (result <= 6.9) {
                    jtfMark4.setText("2.5");
                } else if (result <= 7.9) {
                    jtfMark4.setText("3.0");
                } else if (result <= 8.4) {
                    jtfMark4.setText("3.5");
                } else {
                    jtfMark4.setText("4.0");
                }
            }

        } catch (Exception e) {
            jtfMark10.setText("0.0");
        }

    }

    public boolean updateMarkOfStudnet(byte StatusForForm, String idStudent, String idCourse) {
        try {
            Mark mark = new Mark();
            mark.setMark1(Double.parseDouble(jtfMark1.getText()));
            mark.setMark2(Double.parseDouble(jtfMark2.getText()));
            mark.setMark3(Double.parseDouble(jtfMark3.getText()));
            mark.setIdStudent(idStudent);
            mark.setIdCourse(idCourse);
            if (StatusForForm == Edit) {
                return markService.updateMarkOfStudent(mark);
            }
            if (StatusForForm == Add) {
                return markService.inserMarkOfStudent(mark);
            }

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
        return false;
    }
}
