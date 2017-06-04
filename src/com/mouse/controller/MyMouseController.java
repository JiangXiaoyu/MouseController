package com.mouse.controller;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;

public class MyMouseController{
    
    private Dimension dim; //存储屏幕尺寸
    private Robot robot;//自动化对象

    public MyMouseController(){
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("屏幕大小为：" + dim.getWidth() + " " + dim.getHeight());
        try{
            robot = new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }
    }
    
    public void Move(int width,int heigh){    //鼠标移动函数    
        System.out.println("enter Move()...");
        Point mousepoint = MouseInfo.getPointerInfo().getLocation();
          System.out.println("移动前坐标：" + mousepoint.x + " " + mousepoint.y);
          width += mousepoint.x;
          heigh += mousepoint.y;
        try{
            robot.delay(3000);
            robot.mouseMove(width,heigh);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("移动后坐标：" + width + " " + heigh);
        //robot.mousePress(InputEvent.BUTTON1_MASK);//鼠标单击
    }
    
    public static void main(String args[])throws Exception{       
               
        MyMouseController mmc = new MyMouseController();
        int i = 0;
        
        while(true){
        	i++;
	        System.out.println("mouse control start:");
	        System.out.println("=======第" + i + "次移动=======");
	        mmc.Move(200,200);//坐标为相对坐标
	        mmc.Move(-200,-200);         
	        System.out.println("mouse control stop.");

	        Thread.sleep(10*60*1000);
        }
    }
    
}