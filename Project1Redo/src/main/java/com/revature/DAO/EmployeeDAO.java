package com.revature.DAO;

import java.sql.SQLException;

public abstract interface EmployeeDAO
{
  public abstract void deleteEmployee(int paramInt)
    throws SQLException;
  
  public abstract void updateEmployee(int paramInt, String paramString)
    throws SQLException;
  
  public abstract void addEmployee(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
    throws SQLException;
}