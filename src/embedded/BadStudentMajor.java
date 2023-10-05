package embedded;

import java.sql.*;
import simpledb.jdbc.embedded.EmbeddedDriver;

public class BadStudentMajor {
	public static void main(String[] args) {
		String url = "jdbc:simpledb:studentdb";
		Driver d = new EmbeddedDriver();

		try (Connection conn = d.connect(url, null);
				Statement stmt1 = conn.createStatement();
				ResultSet rs1 = stmt1.executeQuery("select SName, MajorId from STUDENT"))
		{
			System.out.println("Name\tMajor");
			while (rs1.next()) {
				// get the next student
				String sname = rs1.getString("SName");
				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery("select DName from STUDENT"
						+ " where DId = " + rs1.getInt("MajorId"));
				while (rs2.next()) {
					String dname = rs2.getString("DName");
					System.out.println(sname + "\t" + dname);
				}
				rs2.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
