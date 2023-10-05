package network;

import java.sql.*;
import java.util.Scanner;

import simpledb.jdbc.network.NetworkDriver;

public class SectionInfo {

    public static void main (String[] args) {
        System.out.print("Enter a section number: ");
		Scanner sc = new Scanner(System.in);
		int sectionNumber = sc.nextInt();
		sc.close();

        String url = "jdbc:simpledb://localhost";

        String enrollQuery = "select Grade "
            + "from ENROLL "
            + "where SectionId = " + sectionNumber;
        String sectionQry = "select Prof "
            + "from SECTION "
            + "where SectId = " + sectionNumber;

        Driver d = new NetworkDriver();
        try (Connection conn = d.connect(url, null);
                Statement stmt = conn.createStatement()) {
            ResultSet rs1 = stmt.executeQuery(enrollQuery);
            int numStudents = 0;
            int aCount = 0;
            while (rs1.next()) {
                String grade = rs1.getString("Grade");
                if (grade.equals("A")) {
                    aCount++;
                }
                numStudents++;
            }
            rs1.close();

            if (numStudents == 0) {
                System.out.println("No such section.");
                return;
            }

            ResultSet rs2 = stmt.executeQuery(sectionQry);
            String professor = "";
            while (rs2.next()) {
                professor = rs2.getString("Prof");
            }
            rs2.close();

            System.out.println("Professor " + professor + " had " + numStudents + " students and gave " + aCount + " A's.");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
