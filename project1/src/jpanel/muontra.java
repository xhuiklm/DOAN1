
package jpanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class muontra extends javax.swing.JFrame {
           static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/thuvien?useSSL=false";
   //  Ten nguoi dung va mat khau cua co so du lieu
   static final String USER = "root";
   static final String PASS = "haidang97";
   static Connection conn = null;
   static Statement stmt=null;
   public Vector nguoiMuon=new Vector();
   public Vector MaSach=new Vector();
   public Vector NgayMuon=new Vector();
    
    public muontra() throws ClassNotFoundException, SQLException 
    {
        initComponents();
        laythongtin();
        this.setLocationRelativeTo(null);
    }
    void laythongtin() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        stmt=conn.createStatement();
        String sql="SELECT nguoimuon.manguoimuon,sach.masach FROM nguoimuon,sach";
           try (ResultSet rs = stmt.executeQuery(sql)) {
               while(rs.next())
               {
                   
                   String mSach=rs.getString("masach");
                   MaSach.add(mSach);
                   String mNguoiMuon=rs.getString("manguoimuon");
                   nguoiMuon.add(mNguoiMuon);
               }
               rs.close();
           }
           try (ResultSet rs = stmt.executeQuery("SELECT ngaymuon FROM muontra")) {
               while(rs.next())
               {
                  NgayMuon.add(rs.getString("ngaymuon")); 
                  
               }
               rs.close();
           }
           
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        mdate = new javax.swing.JLabel();
        tdate = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        masach = new javax.swing.JTextField();
        soluong = new javax.swing.JTextField();
        ngaymuon = new javax.swing.JTextField();
        ngaytra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Người mượn");

        code.setText("Mã sách");

        quantity.setText("Số lượng");

        mdate.setText("Ngày mượn");

        tdate.setText("Ngày trả");

        name.setText("Mã người mượn");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        masach.setText("Mã sách");
        masach.setToolTipText("");

        ngaymuon.setText("dd-mm-yyyy");

        ngaytra.setText("dd-mm-yyyy");

        jButton1.setText("Mượn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Trả");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home.png"))); // NOI18N
        jMenu1.setText("Menu");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lock.png"))); // NOI18N
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Database.png"))); // NOI18N
        jMenu2.setText("Quản Lý");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Address book.png"))); // NOI18N
        jMenu3.setText("Sách");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Address book.png"))); // NOI18N
        jMenuItem5.setText("Kho Sách");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alien.png"))); // NOI18N
        jMenuItem6.setText("Tác Giả");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenu2.add(jMenu3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/People.png"))); // NOI18N
        jMenuItem4.setText("Người mượn");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdate)
                            .addComponent(jLabel1)
                            .addComponent(code)
                            .addComponent(quantity)
                            .addComponent(mdate))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(masach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(118, 118, 118))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {masach, name, ngaymuon, ngaytra, soluong});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(code)
                    .addComponent(masach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantity)
                    .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mdate)
                    .addComponent(ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tdate)
                    .addComponent(ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                jpanel.begin begin =new jpanel.begin();
           try {
               begin.main(null);
           } catch (SQLException ex) {
               Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
           }
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean b=false;
        String soLuong=soluong.getText().trim();
        String maSach=masach.getText().trim().toUpperCase();
        String Name=name.getText().trim().toUpperCase();
        String ngayMuon=ngaymuon.getText().trim();
        String ngayTra=ngaytra.getText().trim();
        String dateFormat="\\d{1,2}-\\d{1,2}-\\d{4}";
        String sqlTest="SELECT tongsosach,damuon FROM sach WHERE masach='"+maSach+"'";
        int soSachCon;
           try {
               ResultSet rsTest=stmt.executeQuery(sqlTest);
               rsTest.first();
               soSachCon=rsTest.getInt("tongsosach")-rsTest.getInt("damuon");
            if(!nguoiMuon.contains(Name))
                JOptionPane.showMessageDialog(null,"ma nguoi muon khong ton tai");
            else if(!MaSach.contains(maSach))
                JOptionPane.showMessageDialog(null,"ma sach sai");
            else if(!ngayMuon.matches(dateFormat)||!ngayTra.matches(dateFormat))
           JOptionPane.showMessageDialog(null,"ngay tra hoac ngay muon sai");
            else if(Integer.parseInt(soLuong)> soSachCon)
                JOptionPane.showMessageDialog(null,"qua so sach con lai");
            else
                b=true;
           } catch (SQLException ex) {
               Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "nhap sai ma sach");
           }
        
            
        if(b==true){
        String sqlSach="SELECT * FROM "+maSach;
        String sqlUpdate="UPDATE sach SET damuon=damuon+"+soLuong+" WHERE masach='"+maSach+"'";
       String sqlInsert= "INSERT INTO "+Name+" (masach,soluong,ngaymuon,ngaytra,muontra) VALUES ("+"'"+maSach+"','"+soLuong+"','"+ngayMuon+"','"+ngayTra+"','MUON')";
       String sqlUSach="UPDATE "+maSach+" SET soluong=soluong+"+soLuong+" WHERE manguoimuon='"+Name+"'";
       String sqlISach="INSERT INTO "+maSach+"(manguoimuon,soluong,ngaytra) VALUES ("+"'"+Name+"','"+soLuong+"','"+ngayTra+"')";
       String sqlMuonTra="INSERT INTO muontra (manguoimuon,masach,soluong,ngaymuon,ngayhentra) VALUES ("+"'"+Name+"','"+maSach+"','"+soLuong+"','"+ngayMuon+"','"+ngayTra+"')";
       Vector mSach=new Vector();
           try {
              stmt.executeUpdate(sqlInsert);
              stmt.executeUpdate(sqlUpdate);
              stmt.executeUpdate(sqlMuonTra);
              ResultSet rs=stmt.executeQuery(sqlSach);
              while(rs.next())
              {
                  mSach.add(rs.getString("manguoimuon"));
              }
              if(mSach.contains(Name))
                  stmt.executeUpdate(sqlUSach);
              else
                  stmt.executeUpdate(sqlISach);
                          
                    
           } catch (SQLException ex) {
               Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
           }
       JOptionPane.showMessageDialog(null, "nhap du lieu thanh cong");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

       @SuppressWarnings("empty-statement")
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
               boolean b=false;
        String soLuong=soluong.getText().trim();
        String maSach=masach.getText().trim().toUpperCase();
        String Name=name.getText().trim().toUpperCase();
        String ngayMuon=ngaymuon.getText().trim();
        String ngayTra=ngaytra.getText().trim();
        String dateFormat="\\d{1,2}-\\d{1,2}-\\d{4}";
        int daMuon = 0;
       
        String sqlSach="SELECT * FROM "+maSach;
           try {
               ResultSet rs=stmt.executeQuery(sqlSach);
               rs.first();
               daMuon=rs.getInt("soluong");
            if(!nguoiMuon.contains(Name))
                JOptionPane.showMessageDialog(null,"ma nguoi muon khong ton tai");
            else if(!MaSach.contains(maSach))
                JOptionPane.showMessageDialog(null,"ma sach sai");
            else if(!ngayMuon.matches(dateFormat)||!ngayTra.matches(dateFormat)||!NgayMuon.contains(ngayMuon))
           JOptionPane.showMessageDialog(null,"ngay tra hoac may muon sai");
            else if(Integer.parseInt(soLuong)> daMuon)
                JOptionPane.showMessageDialog(null,"so sach tra lon hon so sach da muon");
            else
                b=true;
           } catch (SQLException ex) {
               Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "nhap sai ma sach");
           }
        
            
        if(b==true)
        {
        String sqlUpdate="UPDATE sach SET damuon=damuon-"+soLuong+" WHERE masach='"+maSach+"'";
        String sqlInsert= "INSERT INTO "+Name+" (masach,soluong,ngaymuon,ngaytra,muontra) VALUES ("+"'"+maSach+"','"+soLuong+"','"+ngayMuon+"','"+ngayTra+"','TRA')";
        String sqlUSach="UPDATE "+maSach+" SET soluong=soluong-"+soLuong+" WHERE manguoimuon= '"+Name+"'";
        String sqlDSach="DELETE FROM "+maSach+" WHERE manguoimuon= '"+Name+"'";
        String sqlMuonTra="UPDATE muontra SET ngaytra='"+ngayTra+"' WHERE ngaymuon= '"+ngayMuon+"' AND manguoimuon='"+Name+"' AND masach='"+maSach+"'";
           try {
               stmt.executeUpdate(sqlInsert);
               stmt.executeUpdate(sqlUpdate);
               stmt.executeUpdate(sqlMuonTra);
               if(Integer.parseInt(soLuong)<daMuon)
                   stmt.executeUpdate(sqlUSach);
               else
                   stmt.executeUpdate(sqlDSach);
           } catch (SQLException ex) {
               Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
           }
           JOptionPane.showMessageDialog(null, "nhap du lieu thanh cong");
    }//GEN-LAST:event_jButton2ActionPerformed
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
               try {
                   sach.main();
               } catch (SQLException | ClassNotFoundException ex) {
                   Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
               }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
               try {
                   tacgia.main();
               } catch (ClassNotFoundException | SQLException ex) {
                   Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
               }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
               try {
                   nguoimuon.main();
               } catch (ClassNotFoundException | SQLException ex) {
                   Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
               }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

   
    public static void main() 
    {
    java.awt.EventQueue.invokeLater(() -> {
            try {
                new muontra().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(muontra.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel code;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JTextField masach;
    private javax.swing.JLabel mdate;
    private javax.swing.JTextField name;
    private javax.swing.JTextField ngaymuon;
    private javax.swing.JTextField ngaytra;
    private javax.swing.JLabel quantity;
    private javax.swing.JTextField soluong;
    private javax.swing.JLabel tdate;
    // End of variables declaration//GEN-END:variables
}
