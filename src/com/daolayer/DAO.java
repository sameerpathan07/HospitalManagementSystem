package com.daolayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.pojo.Patient;
import java.util.ArrayList;

public class DAO {
private static final String url="jdbc:mysql://localhost:3306/hospitalmanagement";
private static final String username="root";
private static final String password="bullet7343";
public static Connection con=null;
public static PreparedStatement pstmt=null;

public static Connection getDbConnection()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection(url,username,password);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	return con;
}
public static void insertPatientD(Patient p)
{
	String SQL="Insert into patient values(?,?,?,?)";
	try {
		
		pstmt=getDbConnection().prepareStatement(SQL);
		pstmt.setInt(1,p.getPid());
		pstmt.setString(2,p.getName());
		pstmt.setInt(3,p.getAge());
		pstmt.setString(4,p.getGender());
		pstmt.executeUpdate();
		System.out.println("Data inserted Successfully");
	} catch (SQLException e) {
		e.printStackTrace();
	}	
}

public static boolean checkId(int pid)
{
	String SQL="select *from patient where pid=?";
	boolean status=false;
	try {
		pstmt=getDbConnection().prepareStatement(SQL);
		pstmt.setInt(1, pid);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			status= true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return status;
}

public static void updateDetails(String column,int a,String b) {
	String sql="update patient set "+column+"=? where pid=?;";
	try {
		pstmt=getDbConnection().prepareStatement(sql);
		pstmt.setString(1, b);
		pstmt.setInt(2, a);
		pstmt.executeUpdate();
		System.out.println("Data updated Successfully!!");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public static void deletePatient(int id) {
	
	try {
		String sql = "delete from patient where pid=?;";
		pstmt = getDbConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		System.out.println("Data deleted Successfully...");

	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public static void readDetails() {
	String sql = "select * from patient;";
	try {
		
		pstmt = getDbConnection().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age=rs.getInt(3);
			String gender=rs.getString(4);
			System.out.println(id + "\t" + name+ "  \t" +age+ "\t" +gender);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public static ArrayList<Patient> fetchAllData() {
	ArrayList<Patient> ap=new ArrayList<Patient>();
	String sql = "select * from patient;";
	try {
		
		pstmt = getDbConnection().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age=rs.getInt(3);
			String gender=rs.getString(4);
			
			ap.add(new Patient(id,name,age,gender));
			
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return ap;

}

public static ArrayList<Patient> fetchDataIdWise(int pid) {
	ArrayList<Patient> ap=new ArrayList<Patient>();
	String sql = "select * from patient where pid=?;";
	try {
		
		pstmt = getDbConnection().prepareStatement(sql);
		pstmt.setInt(1, pid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age=rs.getInt(3);
			String gender=rs.getString(4);
			
			ap.add(new Patient(id,name,age,gender));
			
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return ap;
}

}
