package e.way;
import java.util.Scanner;

public class Booking {
    private double time;//เวลาที่ให้ไปรับ
    private String date;//วันที่ที่ใช้รถ
    private String recievePlace;//สถานที่รับ
    private String sendPlace;//สถานที่ส่ง

    public Booking(){
        
    }

    public Booking(double time, String date, String recievePlace, String sendPlace) {
        this.date = date;
        this.time = time;
        this.recievePlace = recievePlace;
        this.sendPlace = sendPlace;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecievePlace() {
        return recievePlace;
    }

    public void setRecievePlace(String recievePlace) {
        this.recievePlace = recievePlace;
    }

    public String getSendPlace() {
        return sendPlace;
    }

    public void setSendPlace(String sendPlace) {
        this.sendPlace = sendPlace;
    }

    @Override
    public String toString() {
        return "Time : "+ time + "\n" +
               "Daye : "+ date + "\n" +
               "Place : "+ recievePlace + "\n" +
               "Location : " + sendPlace ;
    }
    
    public static void main(String args[]) {
        System.out.println("Welcome to Save Ride Night Care reservation system!");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Time : 23.00 00.00 01.00");
        System.out.print("Choose time : ");
        Double time = sc.nextDouble();
        
        System.out.print("Date : ");
        String date = sc.next();
        
        System.out.print("Where are you? : ");
        String place = sc.next();
        
        System.out.println("Location : ประชาอุทิศ45 พุทบูชา สวนธน etc.");
        System.out.print("Where you want to go? : ");
        String location = sc.next();
        System.out.println();
        
        Booking r1 = new Booking(time,date,place,location);
        System.out.println(r1);
  
    }
}


