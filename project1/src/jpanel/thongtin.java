/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class thongtin extends javax.swing.JFrame {    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/thuvien?useSSL=false";
   //  Ten nguoi dung va mat khau cua co so du lieu
   static final String USER = "root";
   static final String PASS = "haidang97";
   static Connection conn = null;
   static Statement stmt=null;
    public thongtin() throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        inThongTin(login.username.getText());
    }
    void inThongTin(String username) throws ClassNotFoundException, SQLException
    {
        Class.forName(JDBC_DRIVER);
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        stmt=conn.createStatement();
     String sql="SELECT * FROM nguoimuon WHERE manguoimuon='"+username+"'";
        ResultSet rs=stmt.executeQuery(sql);
        rs.first();
        manguoidung.setText(rs.getString("manguoimuon"));
        hoten.setText(rs.getString("ten"));
        ngaysinh.setText(rs.getString("ngaysinh"));
        gioitinh.setText(rs.getString("gioitinh"));
        sodienthoai.setText(rs.getString("sdt"));
     conn.close();
     stmt.close();
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        manguoidung = new javax.swing.JLabel();
        hoten = new javax.swing.JLabel();
        ngaysinh = new javax.swing.JLabel();
        gioitinh = new javax.swing.JLabel();
        sodienthoai = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin người dùng");
        setBackground(new java.awt.Color(153, 204, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 853));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã người dùng:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 150, 27));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ Tên:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 90, 27));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày Sinh:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 110, 27));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giới Tính:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 110, 27));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số Điện Thoại:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, 140, 27));

        manguoidung.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        manguoidung.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(manguoidung, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 360, 290, 27));

        hoten.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        hoten.setForeground(new java.awt.Color(255, 255, 255));
        hoten.setText(" ");
        getContentPane().add(hoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 290, 27));

        ngaysinh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ngaysinh.setForeground(new java.awt.Color(255, 255, 255));
        ngaysinh.setText(" ");
        getContentPane().add(ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 290, 27));

        gioitinh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gioitinh.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(gioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 290, 27));

        sodienthoai.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sodienthoai.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(sodienthoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 290, 27));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg/rsz_opmvjp0.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    public static void main() throws ClassNotFoundException, SQLException {
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new thongtin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(thongtin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(thongtin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gioitinh;
    private javax.swing.JLabel hoten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel manguoidung;
    private javax.swing.JLabel ngaysinh;
    private javax.swing.JLabel sodienthoai;
    // End of variables declaration//GEN-END:variables
}
