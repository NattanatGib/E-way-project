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
    private String stuName;
    private String faculty;
    private String branchOf;
    private String eMail;
    private String password;
    private String tel;

    public Person() {

    }
    
    public static void getPerson(ResultSet rs, Person p) throws SQLException {
        p.setFaculty(rs.getString("Facultyof"));
        p.setEMAIL(rs.getString("Person_Email"));
        p.setBranchOf(rs.getString("BranchOf"));
        p.setPersonId(rs.getInt("Person_Id"));
        p.setStuName(rs.getString("Person_Name"));
        p.setPassword(rs.getString("Person_Password"));
        p.setTel(rs.getString("Person_Telephone"));

    }
    
    public static Person findById(long id) {
        Person p = null;
        try {
            String cmd = "select * from Person where Person_ID  = ?";
            Connection conn = ConnectionBuilder.getConnection();
            PreparedStatement pstm = conn.prepareStatement(cmd);
            pstm.setInt(1, (int) id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p = new Person();
                getPerson(rs, p);//ORM
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return p;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String StuName) {
        this.stuName = StuName;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public void setFaculty(String Faculty) {
        this.faculty = Faculty;
    }

    public String getBranchOf() {
        return branchOf;
    }
    
    public void setBranchOf(String BranchOf) {
        this.branchOf = BranchOf;
    }

    public String getEMAIL() {
        return eMail;
    }

    public void setEMAIL(String EMAIL) {
        this.eMail = EMAIL;
    }
        
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getPersonId() {
        return personId;
    }
    
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "StudentName: " + stuName + "Faculty: " + faculty + "\n" + "BranchOf :" + branchOf + "\n" + "EMAIL :" + eMail + "\n" + "password :" + password + "\n" + "tel :" + tel;
    }

    public static Person login(String perId, String pass) {//เปลี่ยนใน login return เป็น person 
        Person one = new Person();
        String sql = "SELECT * FROM PERSON WHERE Person_ID=? AND Person_PASSWORD=?";
        Connection con = ConnectionBuilder.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, perId);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {//กรณีที่กรอกusernameและpasswordถูกต้องให้show dialog Welcome
                String type = rs.getString(5);
                JOptionPane.showMessageDialog(null, "Welcome " + rs.getString(2));
            } else {//กรณีที่กรอกusernameและpasswordถูกต้องให้show dialog Wrong Id/Password
                //------check that user enter all information--------
            if(perId.equals("")){//กรณีที่userไม่กรอกusernameให้show dialog Please enter your username
                JOptionPane.showMessageDialog(null,"Please enter your username");
            }
            else if(pass.equals("")){//กรณีที่userไม่กรอกpassword
                JOptionPane.showMessageDialog(null,"Please enter your password");
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong Id/Password");     
            }

            Person.getPerson(rs, one);

            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return one;
    }
    
    public void editProfile(String editName,String editPass,String editFacul,String editBranch,String editPhone,String editEmail,Person p){
        this.stuName=editName;
        this.password=editPass;
        this.faculty=editFacul;
        this.branchOf=editBranch;
        this.tel=editPhone;
        this.eMail=editEmail;
        
        String sqlInsert = "update PERSON set PERSON_NAME=?,FACULTYOF=?,BRANCHOF=?,PERSON_EMAIL=?,PERSON_PASSWORD=?,PERSON_TELEPHONE=? where PERSON_ID=?";
       
        try {
            Connection con = ConnectionBuilder.getConnection();

            PreparedStatement stm = con.prepareStatement(sqlInsert);
            stm.setString(1, this.stuName);
            stm.setString(2, this.faculty);
            stm.setString(3, this.branchOf);
            stm.setString(4, this.eMail);
            stm.setString(5, this.password);
            stm.setString(6, this.tel);
            stm.setInt(7,p.getPersonId());
            stm.executeUpdate();
        
        } catch (SQLException ex) {
            System.out.println(ex);
        
        }catch(Exception e){
            System.out.println(e);
      
        }
    }
    

    public String geteMail() {
        return eMail;
    }
}
