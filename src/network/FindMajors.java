package network;
import java.sql.*;
import java.util.Scanner;

import simpledb.jdbc.network.NetworkDriver;

public class FindMajors {
	public static void main(String[] args) {
		System.out.print("Enter a department name: ");
		Scanner sc = new Scanner(System.in);
		String major = sc.next();
		sc.close();

		String url = "jdbc:simpledb://localhost";
		String qry = "select sname, gradyear "
				+ "from student, dept "
				+ "where did = majorid "
				+ "and dname = '" + major + "'";

		Driver d = new NetworkDriver();
		try (Connection conn = d.connect(url, null);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(qry)) {

			System.out.println("Here are the " + major + " majors");
			System.out.println("Name\tGradYear");

			while (rs.next()) {
				String sname = rs.getString("sname");
				int gradyear = rs.getInt("gradyear");
				System.out.println(sname + "\t" + gradyear);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
