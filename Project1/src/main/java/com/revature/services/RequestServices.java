package com.revature.services;

import java.sql.SQLException;

import com.revature.DAO_Implementation.ReimbursementDAO_Implementation;

public class RequestServices {
	
	public void updateRequest(String status,int rID){
		ReimbursementDAO_Implementation ri=new ReimbursementDAO_Implementation();
		
			
			try {
				ri.updateR(rID, status);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
