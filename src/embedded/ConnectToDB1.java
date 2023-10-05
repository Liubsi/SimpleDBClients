package embedded;

import simpledb.jdbc.embedded.EmbeddedDriver;
import java.sql.*;

public class ConnectToDB1 {
	public static void main(String[] args) {
		try {
		Driver d = new EmbeddedDriver();
		String url = "jdbc:simpledb:studentdb";
		Connection conn = d.connect(url, null);
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
