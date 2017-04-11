/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eway.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Person {
    private int personId;
    private String StuName;
    private String Falculty;
    private String BranchOf;
    private String EMAIL;
    private String Password;
    private String Tel;
    
    public Person(){
        
    }
    public static void getPerson(ResultSet rs,Person p)throws SQLException{
     
        p.setPersonId(rs.getInt("Person_Id"));
        p.setStuName(rs.getString("Person_Name"));
        p.setPassword(rs.getString("Person_Password"));
        p.setTel(rs.getString("Person_Telephone"));
        
        
        
    }
    public static Person findById(long id){
        Person p = null;
        try {
            String cmd = "select * from Person where Person_ID  = ?"; 
            Connection conn = ConnectionBuilder.getConnection();
            PreparedStatement pstm = conn.prepareStatement(cmd);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            p = new Person();
            getPerson(rs, p);
        }
        } catch (Exception e) {
            System.out.println("Error ja");
        }

        return p;
    }
 

    public String getStuName() {
        return StuName;
    }

    public String getFalculty() {
        return Falculty;
    }

    public String getBranchOf() {
        return BranchOf;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPassword() {
        return Password;
    }

    public String getTel() {
        return Tel;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }
    
    
    public void setStuName(String StuName) {
        this.StuName = StuName;
    }

    public void setFalculty(String Falculty) {
        this.Falculty = Falculty;
    }

    public void setBranchOf(String BranchOf) {
        this.BranchOf = BranchOf;
    }

    public void setEMAIl(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setTel(String tel) {
        this.Tel = tel;
    }
    

    @Override
    public String toString() {
        return "StudentName: " + StuName +"Falcult: " + Falculty +"\n"+ "BranchOf :" + BranchOf +"\n"+"EMAIL :"+ EMAIL+"\n"+"password :"+Password+"\n"+"tel :"+Tel ;
    }
    
    public static Person login(String perId,String pass){//เปลี่ยนใน login return เป็น person 
            Person one=new Person();
            String sql="SELECT * FROM Person WHERE Person_ID=? AND Person_PASSWORD=?";
            Connection con=ConnectionBuilder.getConnection();
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,perId);
                ps.setString(2,pass);
                ResultSet rs=ps.executeQuery();
               if(rs.next()){
                    String type =rs.getString(5);   
                    JOptionPane.showMessageDialog(null,"Welcome " + rs.getString(2));
                    if(type.equalsIgnoreCase("Admin")){
                        JOptionPane.showMessageDialog(null,"You're Admin");
                    }else{
                        JOptionPane.showMessageDialog(null,"Booking Section");
                    }
                }else
                    JOptionPane.showMessageDialog(null,"Wrong Id/Password");
                
                
               Person.getPerson(rs,one);
                con.close();
           
            }catch(SQLException ex){
                System.out.println("Error");
            }
            return one;
   }
    
   /*public void getId(){
       Connection con=ConnectionBuilder.getConnection();
       try{
           Statement s=con.createStatement();
           ResultSet rs=s.executeQuery("select * from person");
           rs.last();
           this.personId=rs.getInt(1);
           con.close();
           
       }catch(SQLException e){
           System.out.println(e);
       }
   }*/ //เก็บไว้เผื่อใช้ในภายหลังนะครับ

}
