package jpanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class dsmuonsach extends javax.swing.JFrame {
    public dsmuonsach() throws SQLException, ClassNotFoundException {
        initComponents();
        insach(tablemuontra.tMaSach.getText());
        this.setLocationRelativeTo(null);
    }
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/thuvien?useSSL=false";
    static final String USER = "root";
   static final String PASS = "haidang97";
   static Connection conn = null;
   static Statement stmt=null;
   static void insach(String subsql) throws SQLException, ClassNotFoundException
           //khởi tạo dữ liệu cho bảng lịch sử mượn trả
      {
        Class.forName(JDBC_DRIVER);
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        stmt=conn.createStatement();
       String sql = "SELECT * FROM "+subsql;
       Vector col;
       Vector data;
        try (ResultSet rs1 = stmt.executeQuery(sql)) {
            
            ResultSetMetaData rsmd=rs1.getMetaData();
            int c =rsmd.getColumnCount();
            col = new Vector(c);
            for(int i =1;i<=c;i++)
            {
                col.add(rsmd.getColumnName(i));
            }     Vector row = new Vector();
            data = new Vector();
            while(rs1.next())
            {
                row=new Vector(c);
                for(int i=1;i<=c;i++)
                    row.add(rs1.getString(i));
                data.add(row);
            } 
        rs1.close();
        }
        
     
      TableModel dataModel = new DefaultTableModel(data, col);
      jTable2.setModel(dataModel);
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách những người đang mượn sách");

        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main() throws SQLException, ClassNotFoundException {
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
            java.util.logging.Logger.getLogger(dsmuonsach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dsmuonsach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dsmuonsach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dsmuonsach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        insach(tablemuontra.tMaSach.getText());

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new dsmuonsach().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(dsmuonsach.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(dsmuonsach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
