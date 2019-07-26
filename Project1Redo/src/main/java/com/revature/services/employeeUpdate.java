package com.revature.services;

import com.revature.DAO_Implementation.EmployeeImplementation;

public class employeeUpdate
{
  public employeeUpdate() {}
  
  public void updatePassword(int userID, String oldPassword, String newPassword) throws java.sql.SQLException
  {
    EmployeeImplementation ei = new EmployeeImplementation();
    com.revature.beans.Employees user = ei.retrieveEmployeeByID(userID, oldPassword);
    System.out.println(user);
    if (user != null) {
      ei.updateEmployeePassWord(userID, newPassword);
    }
  }
}