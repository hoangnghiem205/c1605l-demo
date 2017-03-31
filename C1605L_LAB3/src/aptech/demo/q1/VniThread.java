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
public class VniThread extends Thread{

    private String[] days = {"Thu 2", "Thu 3", "Thu 4", "Thu 5",
                             "Thu 5", "Thu 7", "Chu Nhat"};
    
    private MyData data;

    public VniThread(MyData data) {
        this.data = data;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                synchronized(data){
                    if (!data.isDispEng()) {
                        System.out.println("Vni - " + days[data.getValue()]);
                        data.setDispEng(true);
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
