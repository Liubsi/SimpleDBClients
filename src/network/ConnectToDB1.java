package network;

import simpledb.jdbc.network.NetworkDriver;
import java.sql.*;

public class ConnectToDB1 {
	public static void main(String[] args) {
		try {
		Driver d = new NetworkDriver();
		String url = "jdbc:simpledb:studentdb";
		Connection conn = d.connect(url, null);
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
