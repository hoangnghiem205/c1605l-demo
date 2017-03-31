/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.demo.q2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang.nm
 */
public class ClubManager {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String reg = "[TVA]M[BTN][0-9]{5}";
//            String reg = "[TVA]M[BTN]\\d{5}";
            Pattern p = Pattern.compile(reg);
            final String FILE_NAME = "member.dat";

            // Khai bao DS Member
            List<Member> lstMember = new ArrayList<Member>();
            for (int i = 0; i < 2; i++) {
                Member m = new Member();
                boolean checkId = false;
                do {
                    System.out.print("ID ");
                    String memId = reader.readLine();
                    Matcher matcher = p.matcher(memId);
                    checkId = matcher.matches();
                    if (checkId) {
                        m.setMemberId(memId);
                    } else {
                        System.out.println("Sai dinh dang. Nhap lai");
                    }
                } while (!checkId);

                System.out.print("Name ");
                m.setMemberName(reader.readLine());

                System.out.print("Address ");
                m.setAddress(reader.readLine());
                
                lstMember.add(m);
            }
            
            // Ghi file
            System.out.println("Saving...");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(lstMember);
            oos.close();
            
            // Doc file
            System.out.println("Reading...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            List<Member> lstMember2 = (List<Member>) ois.readObject();
            
            // Hien thi du lieu
            for (Member m : lstMember2) {
                System.out.println(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
