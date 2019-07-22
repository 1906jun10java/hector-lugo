package com.revature.beans;

public class Reimbursement {
	
	private int rID;
	private int employeeID;
	private int managerID;
	private String status;
	private String img;
	private double amount;
	
	
	
	public Reimbursement(int rID, int employeeID, int managerID, String status, double amount) {
		super();
		this.rID = rID;
		this.employeeID = employeeID;
		this.managerID = managerID;
		this.status = status;
		this.amount = amount;
		this.img=null;
	}
	
	public Reimbursement( int employeeID, int managerID, String status, double amount) {
		super();
		this.employeeID = employeeID;
		this.managerID = managerID;
		this.status = status;
		this.amount = amount;
		this.img=null;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getAmmount() {
		return amount;
	}
	public void setAmmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", employee=" + employeeID + ", manager=" + managerID + ", status=" + status
				+ ", img=" + img + ", amount=" + amount + "]";
	}
	
	
	

}
