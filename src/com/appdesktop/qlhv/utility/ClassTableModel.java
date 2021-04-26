package com.appdesktop.qlhv.utility;

import com.appdesktop.qlhv.model.HocVien;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    public DefaultTableModel setTableHocVien(List<HocVien> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
                
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0){
            for(int i = 0; i < rows; i++) {
                HocVien hocVien = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = hocVien.getMaHocVien();               
                obj[2] = hocVien.getHoTen();
                obj[3] = hocVien.getNgaySinh();
                obj[4] = hocVien.isGioiTinh() == true ? "Nam" : "Nữ";
                obj[5] = hocVien.getSoDienThoai();
                obj[6] = hocVien.getDiaChi();
                obj[7] = hocVien.isTinhTrang();
                dtm.addRow(obj);  
            }
        }
        return dtm;
    }
}
