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
import javax.swing.JOptionPane;

/**
 *
 * @author Rei
 */
public class Login { 
   public static void login(String stdId,String pass){
      
            String sql="SELECT * FROM Person WHERE Person_ID=? AND Person_PASSWORD=?";
            Connection con=ConnectionBuilder.getConnection();
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,stdId);
                ps.setString(2,pass);
                ResultSet rs=ps.executeQuery();
              
               if(rs.next()){
                    String type =rs.getString(5);   
                    JOptionPane.showMessageDialog(null,"Welcome " + rs.getString("NAME"));
                    if(type.equalsIgnoreCase("Admin")){
                        JOptionPane.showMessageDialog(null,"You're Admin");
                    }else{
                        JOptionPane.showMessageDialog(null,"Booking Section");
                    }
                }else
                    JOptionPane.showMessageDialog(null,"Wrong Id/Password");
                con.close();
           
            }catch(SQLException ex){
                System.out.println("Error");
            }
   }
}
