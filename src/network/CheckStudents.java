package network;
import java.sql.*;
import simpledb.jdbc.network.NetworkDriver;

public class CheckStudents {
  public static void main(String[] args) {
    Driver d = new NetworkDriver();
    String url = "jdbc:simpledb://localhost";
    String qry = "select Sid from STUDENT";
    try (Connection conn = d.connect(url, null)) {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(qry);
      if (! rs.next())
         System.out.println("no");
      else if (! rs.next())
         System.out.println("no");
      else 
         System.out.println("yes");
      rs.close();
    }
    catch(SQLException e) {e.printStackTrace();}
  }
}