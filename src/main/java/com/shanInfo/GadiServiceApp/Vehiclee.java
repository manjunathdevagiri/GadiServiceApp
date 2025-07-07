package com.shanInfo.GadiServiceApp;

public class Vehiclee {

	private int vehicle_id;
	private String owner_name;
	private String model;
	private String registration_number;

	public Vehiclee() {
		super();
	}

	public Vehiclee(int vehicle_id, String owner_name, String model, String registration_number) {
		super();
		this.vehicle_id = vehicle_id;
		this.owner_name = owner_name;
		this.model = model;
		this.registration_number = registration_number;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	@Override
	public String toString() {
		return "Vehicles [vehicle_id=" + vehicle_id + ", owner_name=" + owner_name + ", model=" + model
				+ ", registration_number=" + registration_number + "]";
	}
	
	
}
