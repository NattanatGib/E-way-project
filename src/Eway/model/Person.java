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

/**
 *
 * @author ASUS
 */
public class Person {
    private String StuName;
    private String Falculty;
    private String BranchOf;
    private String EMAIL;
    private String Password;
    private String Tel;
    
    public Person(){
        
    }
    public static void getProfile(ResultSet rs,Person p)throws SQLException{
        p.setStuName(rs.getString("StudentName"));
        p.setFalculty(rs.getString("Falculty"));
        p.setBranchOf(rs.getString("BranchOf"));
        p.setEMAIL(rs.getString("EMAIL"));
        p.setPassword(rs.getString("password"));
        p.setTel(rs.getString("tel"));
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
            getProfile(rs, p);
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
    
}
