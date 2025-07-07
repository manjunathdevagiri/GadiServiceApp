package com.shanInfo.GadiServiceApp;



public class Service_Records {

	private int record_id;
	private Vehiclee vehicle_id2;
	//private Date service_date;
	private String service_date;
	private String description;
	private double cost;
	
	
	public Service_Records() {
		super();
	}


	public Service_Records(int record_id, Vehiclee vehicle_id2, String service_date, String description, double cost) {
		super();
		this.record_id = record_id;
		this.vehicle_id2 = vehicle_id2;
		this.service_date = service_date;
		this.description = description;
		this.cost = cost;
	}


	public int getRecord_id() {
		return record_id;
	}


	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}


	public Vehiclee getVehicle_id2() {
		return vehicle_id2;
	}


	public void setVehicle_id2(Vehiclee vehicle_id2) {
		this.vehicle_id2 = vehicle_id2;
	}


	public String getService_date() {
		return service_date;
	}


	public void setService_date(String service_date) {
		this.service_date = service_date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "ServiceRecords [record_id=" + record_id + ", vehicle_id2=" + vehicle_id2 + ", service_date="
				+ service_date + ", description=" + description + ", cost=" + cost + "]";
	}


}
