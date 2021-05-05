package com.appdesktop.qlhv.controller;

import com.appdesktop.qlhv.model.HocVien;
import com.appdesktop.qlhv.service.HocVienService;
import com.appdesktop.qlhv.service.HocVienServiceImpl;
import com.appdesktop.qlhv.utility.ClassTableModel;
import com.appdesktop.qlhv.view.HocVienJFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLyHocVienController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnPrint;

    private HocVienService hocVienService = null;
    
    private final String[] listColumn = {"STT", "Mã học viên", "Tên học viên", "Ngày sinh",
        "Giới tính", "Số điện thoại", "Địa chỉ", "Trạng thái"};
    
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyHocVienController(JPanel jbnView, JButton btnAdd, JTextField jtfSearch, JButton btnPrint) {
        this.jpnView = jbnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnPrint = btnPrint;
        
        this.hocVienService = new HocVienServiceImpl();
    }
    
    public void setDateToTable() {
        List<HocVien> listItem = hocVienService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableHocVien(listItem, listColumn);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
        
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        
        table.getColumnModel().getColumn(1).setMinWidth(0);
        table.getColumnModel().getColumn(1).setMaxWidth(0);
        table.getColumnModel().getColumn(1).setPreferredWidth(0);
        
//        table.getColumnModel().getColumn(2).setMinWidth(150);
//        table.getColumnModel().getColumn(2).setMaxWidth(150);
//        table.getColumnModel().getColumn(2).setPreferredWidth(150);
//        
//        table.getColumnModel().getColumn(3).setMinWidth(100);
//        table.getColumnModel().getColumn(3).setMaxWidth(100);
//        table.getColumnModel().getColumn(3).setPreferredWidth(100);
//        
//        table.getColumnModel().getColumn(4).setMinWidth(100);
//        table.getColumnModel().getColumn(4).setMaxWidth(100);
//        table.getColumnModel().getColumn(4).setPreferredWidth(100);
//        
//        table.getColumnModel().getColumn(5).setMinWidth(100);
//        table.getColumnModel().getColumn(5).setMaxWidth(100);
//        table.getColumnModel().getColumn(5).setPreferredWidth(100);
//        
//        table.getColumnModel().getColumn(6).setMinWidth(100);
//        table.getColumnModel().getColumn(6).setMaxWidth(100);
//        table.getColumnModel().getColumn(6).setPreferredWidth(100);
//        
//        table.getColumnModel().getColumn(7).setMinWidth(100);
//        table.getColumnModel().getColumn(7).setMaxWidth(100);
//        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    System.out.println(selectedRowIndex);
                    
                    HocVien hocVien = new HocVien();
                    hocVien.setMaHocVien((int) model.getValueAt(selectedRowIndex, 1));
                    hocVien.setHoTen(model.getValueAt(selectedRowIndex, 2).toString());
                    hocVien.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 3));
                    hocVien.setGioiTinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    hocVien.setSoDienThoai(model.getValueAt(selectedRowIndex, 5) != null ?
                            model.getValueAt(selectedRowIndex, 5).toString() : "");
                    hocVien.setDiaChi(model.getValueAt(selectedRowIndex, 6) != null ?
                            model.getValueAt(selectedRowIndex, 6).toString() : "");
                    hocVien.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 7));
                    HocVienJFrame frame = new HocVienJFrame(hocVien);
                    frame.setTitle("Thông tin học viên");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
            
});
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);

        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1000, 400));
        
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {
            HocVienJFrame frame = new HocVienJFrame(new HocVien());
            frame.setTitle("Thông tin học viên");
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            btnAdd.setBackground(new Color(0, 200, 83));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            btnAdd.setBackground(new Color(100, 221, 23));
        }           
        });   
        
        btnPrint.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {  
            try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Học viên");

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH HỌC VIÊN");

            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Họ và tên");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngày sinh");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Giới tính");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa chỉ");

            HocVienService hocVienService = new HocVienServiceImpl();

            List<HocVien> listItem = hocVienService.getList();

            for (int i = 0; i < listItem.size(); i++) {
                HocVien hocVien = listItem.get(i);
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(hocVien.getHoTen());
                row.createCell(2).setCellValue(hocVien.getNgaySinh().toString());
                row.createCell(3).setCellValue(hocVien.isGioiTinh() ? "Nam" : "Nữ");
                row.createCell(4).setCellValue(hocVien.getSoDienThoai());
                row.createCell(5).setCellValue(hocVien.getDiaChi());
                spreadsheet.autoSizeColumn(i);
            }
            FileOutputStream out = new FileOutputStream(new File("D:/hv.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            btnPrint.setBackground(new Color(0, 200, 83));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            btnPrint.setBackground(new Color(100, 221, 23));
        }           
        });   
   }
}