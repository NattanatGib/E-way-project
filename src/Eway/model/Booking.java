package Eway.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Booking {
    private String time;//เวลาที่ให้ไปรับ
    private String date;//วันที่ที่ใช้รถ
    private String recievePlace;//สถานที่รับ
    private String sendPlace;//สถานที่ส่ง
    private int bookingId;
    private int routeId;
    public Booking(){
        
    }

    public Booking(String time, String date, String recievePlace, String sendPlace) {
        this.date = date;
        this.time = time;
        this.recievePlace = recievePlace;
        this.sendPlace = sendPlace;
        
        if(regisBook()){
            System.out.println("Success");
        }else
            System.out.println("Failed");
        /*try{
            con = E.way.ConnectionBuilder.getConnection();
            
            
            
            
            String sql = "SELECT COUNT (*) FROM SAJA.BOOKING";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //String sql = "INSERT INTO SAMPLE.BOOKING (BOOKING_ID, BOOKING_DATE, BOOKING_ROUND, ROUTE_ID)"+ "VALUES (" +  +",'2017-02-12',"+ "'2017-02-12 23:57:03.914'", NULL);
           // s =con.createStatement();
           // s.execute(sql);
            System.out.println("Booking success");
        
        }catch(Exception e){
            System.out.print("Error");
            
        }*/
        
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
    
    public boolean regisBook() {
        //แก้ sql ให้ตรงกับ db เรา 
        String sqlInsert = "insert into BOOKING(BOOKING_ID, BOOKING_DATE, BOOKING_ROUND, ROUTE_ID)"
                + " values (?, ?, ?, ?)";
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement stm = null;
            stm = con.prepareStatement(sqlInsert);
            stm.setInt(1, this.bookingId);
            stm.setString(2, this.date);
            stm.setString(3, this.time);
            stm.setInt(4, this.routeId);
            stm.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}


