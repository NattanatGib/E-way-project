/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eway.GUI;

import Eway.model.ConnectionBuilder;
import Eway.model.Person;
import java.awt.Color;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Admin extends javax.swing.JFrame {
    Person admins;
    int i=0; 
    public Admin(Person ad) {
        initComponents();
        btn_logout.setBackground(new Color(255,255,255,0));
        this.admins=ad;
        showName.setText(admins.getStuName());
        this.setLocationRelativeTo(null);//setให้GUIแสดงตรงกลางจอคอม
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_top = new javax.swing.JPanel();
        eway = new javax.swing.JLabel();
        showName = new javax.swing.JLabel();
        logoUser = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        admin = new javax.swing.JLabel();
        sortBy = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookingList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 58, 72));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_top.setBackground(new java.awt.Color(103, 197, 233));
        panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eway.setFont(new java.awt.Font("FreesiaUPC", 1, 28)); // NOI18N
        eway.setForeground(new java.awt.Color(255, 255, 255));
        eway.setText("E-WAYS");
        panel_top.add(eway, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        showName.setBackground(new java.awt.Color(204, 204, 204));
        showName.setFont(new java.awt.Font("TH Sarabun New", 0, 20)); // NOI18N
        showName.setForeground(new java.awt.Color(240, 240, 240));
        showName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        showName.setText("name surname");
        panel_top.add(showName, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 190, 20));
        panel_top.add(logoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        btn_logout.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout.setFont(new java.awt.Font("TH Sarabun New", 0, 20)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(240, 240, 240));
        btn_logout.setText("logout");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        panel_top.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, 20));

        jPanel1.add(panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 750, 42));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin.setFont(new java.awt.Font("FreesiaUPC", 1, 28)); // NOI18N
        admin.setForeground(new java.awt.Color(0, 58, 72));
        admin.setText("Admin");
        jPanel2.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 22, 73, 34));

        sortBy.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        sortBy.setForeground(new java.awt.Color(0, 58, 72));
        sortBy.setText("Sort by");
        jPanel2.add(sortBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 20));

        BookingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(BookingList);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 750, 340));

        jButton1.setText("Date");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jButton2.setText("Today");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 750, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        btn_logout.setForeground(new java.awt.Color(0, 58, 72));
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        btn_logout.setForeground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        //System.exit(0);
        LoginGui lgn = new LoginGui();
        setVisible(false);
        lgn.setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        callList("SELECT * FROM BOOKING WHERE Booking_Date  = CURRENT_DATE");
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
       if(i==0){ 
        callList("select * from BOOKING order by  Booking_Date desc ");
        i++;    
       }else{
         i=0;
         callList("select * from BOOKING order by Booking_Date asc");
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        callList("SELECT * FROM BOOKING WHERE Booking_Date  = CURRENT_DATE");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin(new Person()).setVisible(true);
            }
        });
    }
    
    public void callList(String sqlCommand){
        //clear table
        BookingList.setModel(new DefaultTableModel());
        
        //Model for Table
        DefaultTableModel model=(DefaultTableModel)BookingList.getModel();
        model.addColumn("ID");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Recieve Place");
        model.addColumn("Send Location");
        model.addColumn("Customer");
        model.addColumn("Telephone");
        
        
        Connection con=ConnectionBuilder.getConnection();
        Statement st=null;
        
        try{
            st=con.createStatement();
            
            
           
            String sql=sqlCommand;
            
            ResultSet rec=st.executeQuery(sql);
            int row=0;
            while((rec!=null)&&rec.next()){
                model.addRow(new Object[0]);
                model.setValueAt(rec.getInt("Booking_Id"),row,0);
                model.setValueAt(rec.getString("Booking_Date"),row,1);
                model.setValueAt(rec.getString("Booking_Round"),row,2);
                String point= queryJoin("Select  r.ROUTE_LOCATION from BOOKING  b join ROUTE r  on b.ROUTE_LOCATION_RECIEVE = r.ROUTE_ID  where b.BOOKING_ID=" + rec.getInt("Booking_Id"));
                String destination = queryJoin("Select  r.ROUTE_LOCATION from BOOKING  b join ROUTE r on b.ROUTE_LOCATION_DESTINATION = r.ROUTE_ID where b.BOOKING_ID=" + rec.getInt("Booking_ID"));
                model.setValueAt(point,row,3);
                model.setValueAt(destination,row,4);
                model.setValueAt(rec.getInt("PERSON_ID"),row,5);
                model.setValueAt(rec.getString("BOOKING_TELEPHONE"),row,6);
                row++;
            }
        }catch(SQLException  e){
            System.out.println(e);
        }
        
    }
     public String queryJoin(String sql){
        String result="";
        try{
            Connection con = ConnectionBuilder.getConnection();
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            rs.next();
            result=rs.getString(1);
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return result;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookingList;
    private javax.swing.JLabel admin;
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel eway;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoUser;
    private javax.swing.JPanel panel_top;
    private javax.swing.JLabel showName;
    private javax.swing.JLabel sortBy;
    // End of variables declaration//GEN-END:variables
}
