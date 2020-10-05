package com.casestudy.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.casestudy.operations.CRDUOperations;
import com.casestudy.pojoclass.EmployeePojo;

public class OperationsTest 
{
	@Test
	public void testInsert() throws SQLException
     {
        EmployeePojo x=new EmployeePojo();
		CRDUOperations co = new CRDUOperations();
		int check=co.createEmployee(x);
		assertEquals(check,1);
		
	 }
     
     @Test
     public void testRead() throws SQLException 
     {
 		
 		EmployeePojo x=new EmployeePojo();
 		CRDUOperations co = new CRDUOperations();
 		boolean check=co.readEmployee(x);
 		assertEquals(check,true);
 	} 
    
     @Test
     public void testUpdate() throws SQLException 
     {
        EmployeePojo x=new EmployeePojo();
 		CRDUOperations co = new CRDUOperations();
 		int check=co.updateEmp(x);
 		assertEquals(check,0);
 	 }
     
     @Test
 	public void testDelete() throws SQLException {

 		EmployeePojo x=new EmployeePojo();
 		CRDUOperations co = new CRDUOperations();
 		int check=co.deleteEmp(x);
 		assertEquals(check,0);
 		
 	}
     
    
}
