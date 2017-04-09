
package Eway.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Booking {
    private String time;//เวลาที่ให้ไปรับ
    private String date;//วันที่ที่ใช้รถ
    private Person student;
    //-------------- แก้ใหม่--------------------------
    private int recieveId;//สถานที่รับ
    private int sendId;//สถานที่ส่ง
    //----------------------------------------------
    private static int id=1;

    public Booking(){
        
    }
    //test push
    public Booking(String time, String date,Person p, int recievePlace,int  sendPlace) {
        this.time = time;
        this.date = date;
        this.sendId=sendPlace;
        this.student=p;
        this.recieveId = recievePlace;
       
        if(regisBook())
            System.out.println("Success");
        else
            System.out.println("Failed");
        
        
    }

    /*public Booking(String time, String date, String recievePlace, String sendPlace) {
        this.date = date;
        this.time = time;
        this.recievePlace = recievePlace;
        this.sendPlace = sendPlace;
        ///////// ส่วนที่ผมทำ///////////////////////
        if(regisBook()){
            System.out.println("Success");
        }else
            System.out.println("Failed");
        ////////////////////////////////////////
    }*/

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

    public Person getStudent() {
        return student;
    }

    public int getRecieveId() {
        return recieveId;
    }

    public int getSendId() {
        return sendId;

    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public void setRecieveId(int recieveId) {
        this.recieveId = recieveId;
    }


    

  

 

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }
    
    @Override
    public String toString() {
        return "Time : "+ time + "\n" +
               "Daye : "+ date + "\n" +
               "RecieveID : "+ recieveId + "\n" +
               "SendId: "+sendId+"\n";
               //"Location : " + sendPlace ;
    }
    
    public boolean regisBook() {
        String sqlInsert = "insert into BOOKING(BOOKING_DATE,BOOKING_ROUND, ROUTE_LOCATION_RECIEVE,ROUTE_LOCATION_DESTINATION,Person_Id)"
<<<<<<< Updated upstream
                + " values (?, ?,?,?,?)";
=======
                + " values (?,?,?,?,?)";
>>>>>>> Stashed changes
        try {
            Connection con = ConnectionBuilder.getConnection();

            PreparedStatement stm = con.prepareStatement(sqlInsert);
            //stm.setInt(1, id++);
            stm.setString(1,this.date );
            stm.setString(2, this.time);
            stm.setInt(3, recieveId);
            stm.setInt(4, this.sendId);
<<<<<<< Updated upstream
            stm.setInt(5,student.getPersonId());
=======
            stm.setInt(5,1);
>>>>>>> Stashed changes
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
   // public void 
   // public String queryRoute()
    
    
    public ResultSet findBookingById(int p){//Method ที่เอาไว้ดึงข้อมูลการจองทั้งหมดที่user จองไว้
        String sql="select * from booking where person_ID=?";//คำสั่ง SQL
        ResultSet table=null;//สร้างตัวแปรไว้เก็บค่า
        try{
            Connection con=ConnectionBuilder.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,p); //เซ้ตค่า Id ของ USER
            table=pre.executeQuery();
            con.close();
        } catch(SQLException e){
            System.out.println("Not success to show your");
            System.out.println(e);
        }
        return table;
     }
    
    
    
}


