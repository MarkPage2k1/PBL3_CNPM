package com.appdesktop.StudentManagement.Controller;

import com.appdesktop.StudentManagement.Bean.ClassBean;
import com.appdesktop.StudentManagement.Bean.CourseBean;
import com.appdesktop.StudentManagement.Service.AnalytisService;
import com.appdesktop.StudentManagement.Service.AnalytisServiceImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class AnalytisController {
    private AnalytisService analytisService = null;

    public AnalytisController() {
        this.analytisService = new AnalytisServiceImpl();
    }
    public void setDataToChart1(JPanel jpnItem) {
        List<ClassBean> listItem = analytisService.getListByClass();

        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ClassBean item : listItem) {
                dataset.addValue(item.getNumberOfParticipants(), "Học viên", item.getRegistrationDate());
            }
            
            JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng học viên đăng ký".toUpperCase(),
                "Thời gian", "Số lượng",
                dataset);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 250));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } 
    }
    
    public void setDataToChart2(JPanel jpnItem) {
        List<CourseBean> listItem = analytisService.getListByCourse();
        if (listItem != null) {
            TaskSeriesCollection ds = new TaskSeriesCollection();
            TaskSeries taskSeries;
            Task task;
            
            for (CourseBean item : listItem) {
                taskSeries = new TaskSeries(item.getCourseName());
                task = new Task(item.getCourseName(), item.getStartDate(), item.getEndDate());
                taskSeries.add(task);
                ds.add(taskSeries);
            }
            
            JFreeChart ganttChart = ChartFactory.createGanttChart(
                "BIỂU ĐỒ THEO DÕI TÌNH TRẠNG KHÓA HỌC",
                "Khóa học", "Thời gian", ds);
            ChartPanel chartPanel = new ChartPanel(ganttChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 250));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
}
