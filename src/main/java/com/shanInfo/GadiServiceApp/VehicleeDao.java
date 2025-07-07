package com.shanInfo.GadiServiceApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class VehicleeDao implements IVehiclee{

	private Connection con =null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addVehicle() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter vehicle ID:");
		int vehicle_id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Owner name:");
		String owner=sc.nextLine();
		
		System.out.println("Enter vehicle model:");
		String model=sc.nextLine();
		
		System.out.println("Enter registration num:");
		String regNo=sc.nextLine();
		
		Vehiclee v1=new Vehiclee(vehicle_id, owner, model, regNo);
		con=DBConnect.Connect();
		con.setAutoCommit(false);
		
		String insertVehiclee="insert into vehicles values(?,?,?,?)";
		ps=con.prepareStatement(insertVehiclee);
		ps.setInt(1, v1.getVehicle_id());
		ps.setString(2, v1.getOwner_name());
		ps.setString(3, v1.getModel());
		ps.setString(4, v1.getRegistration_number());
		ps.executeUpdate();
		con.commit();
		System.out.println("Vehicle data inserted");
		con.close();
	}

	@Override
	public List<Vehiclee> getVehicle() throws Exception {
		// TODO Auto-generated method stub
		List<Vehiclee> list=new ArrayList<>();
		Connection con=DBConnect.Connect();
		PreparedStatement ps=con.prepareStatement("select* from vehicles");
		rs=ps.executeQuery();
		while(rs.next()) {
			list.add(new Vehiclee(
					
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
					));
		}
		return list;
	}

	
}

