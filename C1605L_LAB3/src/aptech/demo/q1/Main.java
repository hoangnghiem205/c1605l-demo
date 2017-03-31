/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.demo.q1;

/**
 *
 * @author hoang.nm
 */
public class Main {
    
    public static void main(String[] args) {
        MyData data = new MyData(0);
        VniThread vni = new VniThread(data);
        EngThread eng = new EngThread(data);
        
        vni.start();
        eng.start();
    }
}
