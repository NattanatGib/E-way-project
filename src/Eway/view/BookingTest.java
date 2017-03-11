/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eway.view;

import Eway.model.Booking;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
/**
 *
 * @author Rei
 */
public class BookingTest {
     public static void main(String args[]) {
        System.out.println("Welcome to Save Ride Night Care reservation system!");
        //------------------------------------เพิ่มโดย ผมเอง-------------------------
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        String date= format.format(dt);
        String time=date;
        //--------------------------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Time : 1.23.00 2.00.00 3.01.00");
        //------------------------------ เพิ่มโดย ผมเอง -------------------------------
        int i=1;
        do{
            if(i<1||i>3){
                System.out.println("Please Enter again");
            }
            System.out.print("Choose time : "); 
            i=sc.nextInt();
            
            
            
            if(i==1){
                time+=" 23:00:00";
            }else if(i==2){
                time+=" 00:00:00";
            }else if(i==3){
                time+=" 01:00:00";
            }
           
         }while(!(i==1||i==2||i==3));
        //----------------------------------------------------------------------------------
        
        System.out.print("Where are you? : ");
        String place = sc.next();
        
        System.out.println("Location : ประชาอุทิศ45 พุทบูชา สวนธน etc.");
        System.out.println("Where you want to go? : ");
        System.out.println("1.หอพัก my place");
        System.out.println("2.หอพัก my place2");
         System.out.println("3. คอนโดบ้านสวนธน");
         System.out.println("4.หอพักธนบุญ");
         System.out.println("5. the parque");
         System.out.println("6. คอสโม เรสซิเด็น");
         System.out.println("Select your number: ");
        int location = sc.nextInt();
        System.out.println();
        Booking r1 = new Booking(time,date,place,location);
        System.out.println(r1);
  
    }
}
