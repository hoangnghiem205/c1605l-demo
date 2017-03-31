/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.demo.q1;

import java.util.Random;

/**
 *
 * @author hoang.nm
 */
public class EngThread extends Thread{

    private String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday",
                             "Friday", "Saturday", "Sunday"};
    
    private MyData data;

    public EngThread(MyData data) {
        this.data = data;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                synchronized(data){
                    if (data.isDispEng()) {
                        System.out.println("Eng - " + days[data.getValue()]);
                        data.setValue(new Random().nextInt(7));
                        data.setDispEng(false);
                        Thread.sleep(1000);
                        data.notify();
                    } else {
                        data.wait();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
