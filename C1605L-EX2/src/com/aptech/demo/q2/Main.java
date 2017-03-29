/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.demo.q2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang.nm
 */
public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Nhap du lieu
            List<Student> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                Student s = new Student();
                System.out.print("Name: ");
                s.setName(reader.readLine());
                System.out.print("Age: ");
                s.setAge(Integer.parseInt(reader.readLine()));

                list.add(s);
            }

            //Hien thi du lie
            System.out.println("Noi dung vua nhap");
            for (Student stu : list) {
                System.out.println(stu);
            }

            // Ghi file
            System.out.println("Ghi file...");
            FileOutputStream fo = new FileOutputStream("stud.obj");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.close();
            System.out.println("Da ghi du lieu");

            // Doc file
            FileInputStream fi = new FileInputStream("stud.obj");
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            System.out.println("doc file...");
            List<Student> data = (List<Student>) oi.readObject();
            for (Student s : data) {
                System.out.println(s);
            }
            System.out.println("done.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
