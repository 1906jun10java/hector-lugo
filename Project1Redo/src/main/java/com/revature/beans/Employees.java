package com.revature.beans;

public class Employees
{
  private int employeeID;
  private int managerID;
  private String name;
  private String address;
  private int isManager;
  private String managerName;
  private String email;
  
  public Employees(String name, String email, String managerName) {
    this.managerName = managerName;
    this.email = email;
    this.name = name;
  }
  

  public Employees(int employeeID, int managerID, String name, String address, int isManager)
  {
    this.employeeID = employeeID;
    this.managerID = managerID;
    this.name = name;
    this.address = address;
    this.isManager = isManager;
  }
  

  public Employees(int managerID, String name, String address, int isManager)
  {
    this.managerID = managerID;
    this.name = name;
    this.address = address;
    this.isManager = isManager;
  }
  
  public Employees(int employeeID, int managerID, String name, String address, int isManager, String email) {
    this.employeeID = employeeID;
    this.managerID = managerID;
    this.name = name;
    this.address = address;
    this.isManager = isManager;
    this.email = email;
  }
  
  public Employees(int employeeID, int managerID, String name, String address, int isManager, String managerName, String email)
  {
    this.employeeID = employeeID;
    this.managerID = managerID;
    this.name = name;
    this.address = address;
    this.isManager = isManager;
    this.managerName = managerName;
    this.email = email;
  }
  
  public Employees(int managerID, String name, String address, int isManager, String managerName, String email)
  {
    this.managerID = managerID;
    this.name = name;
    this.address = address;
    this.isManager = isManager;
    this.managerName = managerName;
    this.email = email;
  }
  
  public int getEmployeeID() { return employeeID; }
  
  public void setEmployeeID(int employeeID) {
    this.employeeID = employeeID;
  }
  
  public int getManagerID()
  {
    return managerID;
  }
  
  public void setManagerID(int managerID) { this.managerID = managerID; }
  
  public int getIsManager() {
    return isManager;
  }
  
  public void setIsManager(int isManager) { this.isManager = isManager; }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) { this.name = name; }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) { this.address = address; }
  
  public int isManager() {
    return isManager;
  }
  
  public void setManager(int isManager) { this.isManager = isManager; }
  
  public String getManagerName()
  {
    return managerName;
  }
  
  public void setManagerName(String managerName) { this.managerName = managerName; }
  
  public String getEmail()
  {
    return email;
  }
  
  public void setEmail(String email) { this.email = email; }
  


  public String toString()
  {
    return 
      "Employees [employeeID=" + employeeID + ", managerID=" + managerID + ", name=" + name + ", address=" + address + ", isManager=" + isManager + ", managerName=" + managerName + ", email=" + email + "]";
  }
}