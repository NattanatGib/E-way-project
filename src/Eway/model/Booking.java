
package Eway.model;
import java.sql.*;

public class Booking {
    private String time;//เวลาที่ให้ไปรับ
    private String date;//วันที่ที่จองรถ
    private Person student;//คนจอง
    private String tel;//เบอร์
    private int recieveId;//สถานที่รับ
    private int sendId;//สถานที่ส่ง

    public Booking(){
        
    }

    public Booking(String time, String date,Person p, int recievePlace,int  sendPlace,String tel) {
        this.time = time;
        this.date = date;
        this.sendId=sendPlace;
        this.student=p;
        this.recieveId = recievePlace;
        this.tel=tel;
        
        if(regisBook())
            System.out.println("Success");
        else
            System.out.println("Failed");
        
        
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

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }
    
    public int getRecieveId() {
        return recieveId;
    }

    public void setRecieveId(int recieveId) {
        this.recieveId = recieveId;
    }
    
    public int getSendId() {
        return sendId;

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
        String sqlInsert = "insert into BOOKING(BOOKING_DATE,BOOKING_ROUND, ROUTE_LOCATION_RECIEVE,ROUTE_LOCATION_DESTINATION,Person_Id,Booking_Telephone)"
                + " values (?,?,?,?,?,?)";//เตรียมPreparedStatement
        try {
            Connection con = ConnectionBuilder.getConnection();

            PreparedStatement stm = con.prepareStatement(sqlInsert);
            stm.setString(1,this.date );
            stm.setString(2, this.time);
            stm.setInt(3, recieveId);
            stm.setInt(4, this.sendId);
            stm.setInt(5,student.getPersonId());
            stm.setString(6, this.tel);
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

    
    public static ResultSet findBookingById(int p){//Method ที่เอาไว้ดึงข้อมูลการจองทั้งหมดที่user จองไว้
        String sql="select * from BOOKING where person_ID=?";//คำสั่ง SQL
        ResultSet table=null;//สร้างตัวแปรไว้เก็บค่า
        try{
            Connection con=ConnectionBuilder.getConnection();
            PreparedStatement pre = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pre.setInt(1,p); //เซ้ตค่า Id ของ USER
            System.out.println("check");
            table=pre.executeQuery();
      
        } catch(SQLException e){
            System.out.println("Not success to show your");
            System.out.println(e);
        }
        return table;
     }
    
    public  ResultSet getAllBooking(){//เรียกการจองทุกอันขึ้นมา
        String sql="select * from BOOKING";
        ResultSet re=null;
        try{
            Connection  con=ConnectionBuilder.getConnection();
            Statement st=con.createStatement();
            re= st.executeQuery(sql);
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return re;
    }
    public static void cancelBooking(int id){//ยกเลิกการจอง
        String sql="delete from BOOKING where BOOKING_ID=?";
        try{
           Connection con=ConnectionBuilder.getConnection();
           PreparedStatement pre=con.prepareStatement(sql);
           pre.setInt(1,id);
           pre.execute();
           
           con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
}


