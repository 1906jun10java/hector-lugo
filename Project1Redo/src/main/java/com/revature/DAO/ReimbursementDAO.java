package com.revature.DAO;

import com.revature.beans.Reimbursement;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public abstract interface ReimbursementDAO
{
  public abstract void addR(int paramInt1, int paramInt2, String paramString, double paramDouble)
    throws SQLException;
  
  public abstract void updateR(int paramInt, String paramString)
    throws SQLException;
  
  public abstract List<Reimbursement> getSentR(int paramInt)
    throws SQLException;
  
  public abstract List<Reimbursement> getMyEmployyesR(int paramInt)
    throws SQLException;
  
  public abstract void addR(int paramInt1, int paramInt2, String paramString, double paramDouble, InputStream paramInputStream)
    throws SQLException;
  
  public abstract void addR(int paramInt1, int paramInt2, String paramString, double paramDouble, byte[] paramArrayOfByte)
    throws SQLException;
}