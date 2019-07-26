package com.revature.beans;


public class Reimbursement
{
  private int rID;
  
  private int employeeID;
  private int managerID;
  private String status;
  private byte[] img;
  private double amount;
  private String employeeName;
  private String managerName;
  
  public Reimbursement(int rID, double amount, String status, String employeeName, String managerName)
  {
    this.rID = rID;
    this.amount = amount;
    this.status = status;
    this.employeeName = employeeName;
    this.managerName = managerName;
  }
  
  public Reimbursement(int rID, int employeeID, int managerID, String status, double amount)
  {
    this.rID = rID;
    this.employeeID = employeeID;
    this.managerID = managerID;
    this.status = status;
    this.amount = amount;
    img = null;
  }
  
  public Reimbursement(int employeeID, int managerID, String status, double amount)
  {
    this.employeeID = employeeID;
    this.managerID = managerID;
    this.status = status;
    this.amount = amount;
    img = null;
  }
  
  public Reimbursement(int employeeID, int managerID, String status, double amount, byte[] img)
  {
    this.employeeID = employeeID;
    this.managerID = managerID;
    this.status = status;
    this.amount = amount;
    this.img = img;
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
  
  public void setrID(int rID) { this.rID = rID; }
  
  public String getStatus()
  {
    return status;
  }
  
  public void setStatus(String status) { this.status = status; }
  
  public double getAmmount()
  {
    return amount;
  }
  
  public void setAmmount(double amount) { this.amount = amount; }
  
  public double getAmount()
  {
    return amount;
  }
  
  public void setAmount(double amount) {
    this.amount = amount;
  }
  
  public String getEmployeeName() {
    return employeeName;
  }
  
  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }
  
  public String getManagerName() {
    return managerName;
  }
  
  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }
  
  public String toString()
  {
    return 
    
      "Reimbursement [rID=" + rID + ", employeeID=" + employeeID + ", managerID=" + managerID + ", status=" + status + ", amount=" + amount + ", employeeName=" + employeeName + ", managerName=" + managerName + "]";
  }
}