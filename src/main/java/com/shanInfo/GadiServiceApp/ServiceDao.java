package com.shanInfo.GadiServiceApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;



public class ServiceDao implements IService {

	private Connection con =null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	VehicleeDao vdao=new VehicleeDao();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addService() throws Exception {
		// TODO Auto-generated method stub
		List<Vehiclee> vehiclees=vdao.getVehicle();
		System.out.println("Available Vehicles");
		vehiclees.forEach(System.out::println);
		
		System.out.println("Enter vehicle ID for the service:");
		int userVid=sc.nextInt();
		sc.nextLine();
		
		Optional<Vehiclee> matchedVehicle=vehiclees.stream()//Optional--checks for null,dosent throw nullPointerException
		.filter(v->v.getVehicle_id()==userVid).findFirst();
		
		if(matchedVehicle.isEmpty()) {
			System.out.println("Vehicle ID not found.Cannot insert service record");
			return;
		}
		System.out.println("Enter service record ID:");
		int rid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter service date YYYY-MM-DD:>");
		String sDate=sc.nextLine();
		System.out.println("Enter Description:");
		String desc=sc.nextLine();
		System.out.println("Enter cost:");
		double cost=sc.nextDouble();
		
		Service_Records sr=new Service_Records(rid, matchedVehicle.get(), sDate, desc, cost);
		
		con=DBConnect.Connect();
		con.setAutoCommit(false);
		
		String insertService="insert into service_records values(?,?,?,?,?)";
		ps=con.prepareStatement(insertService);
		ps.setInt(1, sr.getRecord_id());
		ps.setInt(2, sr.getVehicle_id2().getVehicle_id());
		ps.setString(3, sr.getService_date());
		ps.setString(4, sr.getDescription());
		ps.setDouble(5, sr.getCost());
		ps.executeUpdate();
		con.commit();
		System.out.println("Service record data inserted");
		con.close();
	}

	@Override
	public List<Service_Records> getService() throws Exception {
		// TODO Auto-generated method stub
		List<Service_Records> list=new ArrayList<>();
		List<Vehiclee> vehiclees=vdao.getVehicle();
		con=DBConnect.Connect();
		ps=con.prepareStatement("select * from service_records");
		rs=ps.executeQuery();
		while(rs.next()) {
			int vehicleIdFromService =rs.getInt(1);
			Vehiclee matchedVehiclee=vehiclees.stream()
					.filter(v->v.getVehicle_id()==vehicleIdFromService).findFirst().orElse(null);
			Service_Records r=new Service_Records(
					rs.getInt(1),
					matchedVehiclee,
					rs.getString(2),
					rs.getString(3),
					rs.getDouble(4)
					
					);
			list.add(r);
		}
		con.close();
		return list;
	}

}

