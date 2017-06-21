package jpanel;


//Buoc 1: Ban can inport cac package can thiet
import java.sql.*;
import java.util.Vector;
import javax.swing.JTable;

public class mysql {
   // Ten cua driver va dia chi URL cua co so du lieu
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/thuvien?useSSL=false";

   //  Ten nguoi dung va mat khau cua co so du lieu
   static final String USER = "root";
   static final String PASS = "haidang97";
   private Vector data=new Vector();
   private Vector col=new Vector();
   static void inResult(Statement stmt) throws SQLException{
      String sql = "SELECT * FROM sach";
      ResultSet rs = stmt.executeQuery(sql);
      // Buoc 5: Lay du lieu tu Result Set
      while(rs.next()){
         // Lay du lieu boi su dung ten cot
         int idNhanVien  = rs.getInt("stt");
         
         String GioiTinh = rs.getString("tensach");
         String TenNV=rs.getString("manxb");

         // Hien thi cac gia tri
       System.out.print("\nMSSV: " + idNhanVien);
       System.out.print("\nHo: " + TenNV);
       System.out.print("\nDiem Thi: " + GioiTinh);
       System.out.print("\n=================");
      }
   }
       void insach(Statement stmt) throws SQLException
      {
       String sql="SESELECT * FROM sach";
       ResultSet rs=stmt.executeQuery(sql);
      ResultSetMetaData rsmd=rs.getMetaData();
      
      int c =rsmd.getColumnCount();
      for(int i =1;i<=c;i++)
      {
          col.add(rsmd.getColumnName(i));
      }
      Vector row = new Vector();
      while(rs.next())
      {
          row=new Vector(c);
          for(int i=1;i<=c;i++)
              row.add(rs.getString(i));
          data.add(row);      
      }
      //System.out.println("Tong so cot la: "+rsmd.getColumnCount());  
        //System.out.println("Ten cua cot thu nhat la: "+rsmd.getColumnName(1));  
       //System.out.println("Ten kieu cua cot thu nhat la: "+rsmd.getColumnTypeName(1));  
      // Buoc 6: Don sach moi truong va giai phong resource
      rs.close();
     
   }
   public static void main() throws SQLException {
   Connection conn = null;
   Statement stmt = null;
   try{
      // Buoc 2: Dang ky Driver
      Class.forName("com.mysql.jdbc.Driver");

      // Buoc 3: Mo mot ket noi
      System.out.println("Dang ket noi toi co so du lieu ...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // Buoc 4: Thuc thi truy van
      System.out.println("Tao cac lenh truy van SQL ...");
      stmt = conn.createStatement();
// Ket thuc khoi try
      
      
   }catch(SQLException se){
      // Xu ly cac loi cho JDBC
      se.printStackTrace();
   }catch(Exception e){
      // Xu ly cac loi cho Class.forName
      e.printStackTrace();
   }finally{
      // Khoi finally duoc su dung de dong cac resource
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      } 
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }// Ket thuc khoi finally
   }
   
   System.out.println("\nVietJack chuc cac ban hoc tot!");
}// Ket thuc main
}// Ket thuc ViDuJDBC