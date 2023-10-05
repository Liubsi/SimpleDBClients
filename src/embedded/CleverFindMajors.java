package embedded;

import java.sql.*;
import java.util.Scanner;
import simpledb.jdbc.embedded.EmbeddedDriver;

public class CleverFindMajors {
	public static void main(String[] args) {
		System.out.print("Enter a department name: ");
		Scanner sc = new Scanner(System.in);
		String major = sc.next();
		sc.close();

		Driver d = new EmbeddedDriver();
		String url = "jdbc:simpledb:studentdb";
		try (Connection conn = d.connect(url, null);
				Statement stmt = conn.createStatement()) {
			System.out.println("\nHere are the " + major + " majors");
			System.out.println("Name\tGradYear");

			String qry1 = "select DId from DEPT "
					+ "where DName = '" + major + "'";
			ResultSet rs1 = stmt.executeQuery(qry1);
			if (rs1.next() == false)
				return;
			int did = rs1.getInt("DId");
			rs1.close();

			String qry2 = "select SName, GradYear from STUDENT "
					+ "where MajorId = " + did;
			ResultSet rs2 = stmt.executeQuery(qry2);
			while (rs2.next()) {			
				String sname = rs2.getString("sname");
				int gradyear = rs2.getInt("gradyear");
				System.out.println(sname + "\t" + gradyear);
			}
			rs2.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
