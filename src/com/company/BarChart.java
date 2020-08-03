package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

public class BarChart {
    org.jfree.chart.ChartPanel frame1;


    public  BarChart(){
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                "水果",
                "水果种类",
                "数量",
                dataset,
                PlotOrientation.VERTICAL,
                true,           // 是否显示图例
                false,          // 工具
                false           // 链接
        );

        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

        //为了乱码

        frame1=new ChartPanel(chart,true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension scrnsize = toolkit.getScreenSize();
        int w = 100;
        int h = 100;
        frame1.setDomainZoomable(true);
        frame1.setPreferredSize(new Dimension(w,h));


    }
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        return dataset;
    }
    public ChartPanel getChartPanel(){
        return frame1;

    }

}


