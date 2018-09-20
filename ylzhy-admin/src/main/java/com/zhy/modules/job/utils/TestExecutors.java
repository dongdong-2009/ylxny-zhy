package com.zhy.modules.job.utils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
      
      
public class TestExecutors implements Runnable {
          
 
      
 public static void main(String[] args) {
 
     ExecutorService eService = Executors.newSingleThreadExecutor();
    // ExecutorService eService = Executors.newFixedThreadPool(10);
     eService.execute(new TestExecutors());
           
 }
@Override
public void run() {
    int temp = 0;
    int i = 0;
    Random random =new Random();
    while(true){
        int j =random .nextInt(100);
     
        System.err.println("temp----------->"+temp+"  i---------------->"+(i++)+"    j------------------>"+j);
    
        try{
                  
            if(temp==0&&j>10) temp = 7/0;
                  
           // Thread.currentThread().sleep(10);
            System.err.println("id===" +  Thread.currentThread().getName());               
        }catch(Exception e){
            e.printStackTrace();
                  
            temp = 1;
                  
        }
              
              
    }
          
}
      
}
