package com.shanInfo.GadiServiceApp;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	VehicleeDao vdao=new VehicleeDao();
		ServiceDao sdao=new ServiceDao();
		
		try {
			vdao.addVehicle();
			sdao.addService();
			
			List<Vehiclee> vehiclees=vdao.getVehicle();
			System.out.println("\nAll Vehicles:");
			vehiclees.forEach(System.out::println);
			
			List<Service_Records> services=sdao.getService();
			System.out.println("\n All service records:");
			services.forEach(System.out::println);
			
			System.out.println("\n Filtered:service cost>1000");
			services.stream().filter(sr->sr.getCost()>1000).forEach(System.out::println);
			
			System.out.println("\nGrouped by cost category");
			Map<String, List<Service_Records>> grouped=services.stream()
					.collect(Collectors.groupingBy(sr->{
						if(sr.getCost()<1000) return "Low";
						else if(sr.getCost()<=2000)
						return "Medium";
						else return "High";
					}));
			
			grouped.forEach((category,list)->{
				System.out.println(category+"cost:");
				list.forEach(System.out::println);
			});
			
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
    }
}
