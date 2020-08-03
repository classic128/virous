package com.company;

import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.table.TableRowSorter;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        initHospital();
        initPanel();
        initInfected();
    }

    private static void initPanel() {

        int captionStartOffsetX = 700 + Hospital.getInstance().getWidth() + 40;
        int captionStartOffsetY = 40;
        int captionSize = 24;

        List<Person> people = PersonPool.getInstance().getPersonList();
        if (people == null) {
            return;
        }
        BarChart barChart = new BarChart();
        ChartPanel chartPanel = barChart.getChartPanel();
        MyPanel p = new MyPanel();
        Thread panelThread = new Thread(p);
        JFrame frame = new JFrame();




        JButton button = new JButton();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();

        button1.setText("流动限制");
        button.setText("戴口罩");
        button2.setText("增加床位");
        button3.setText("停止");

        button.setBackground(Color.WHITE);
        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);

        button.setBounds(captionStartOffsetX +30,captionStartOffsetY + 10 * captionSize,200,24);
        button1.setBounds(captionStartOffsetX + 30,captionStartOffsetY + 11 * captionSize,200,24);
        button2.setBounds(captionStartOffsetX + 30,captionStartOffsetY + 12 * captionSize,200,24);
        button3.setBounds(captionStartOffsetX + 30,captionStartOffsetY + 14 * captionSize,200,24);

        p.setLayout(null);
        p.add(button);
        p.add(button1);
        p.add(button2);
        p.add(button3);

        frame.add(p);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                for (Person person:people){

                    person.chang();
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (Person person:people){
                    person.move();
                }
            }
        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        Hospital.getInstance().addbed();
                    }
                },7000);

            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                    MyPanel.flag1 = true;
                    MyPanel.flag2 = false;

            }
        });

        frame.setSize(Constants.CITY_WIDTH + hospitalWidth + 600, Constants.CITY_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("新冠病毒传播模拟");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelThread.start();

    }

    private static int hospitalWidth;

    private static void initHospital(){
        hospitalWidth = Hospital.getInstance().getWidth();

    }

    private static void initInfected(){
        List<Person> people = PersonPool.getInstance().getPersonList();
        for (int i = 0; i < Constants.ORIGINAL_COUNT; i++){
            Person person;
            do {
                person = people.get(new Random().nextInt(people.size() - 1));
            } while (person.isInfected());
                person.beInfected();
            }
        }
}

