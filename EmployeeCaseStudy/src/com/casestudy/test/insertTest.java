package com.casestudy.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.casestudy.operations.CRDUOperations;
import com.casestudy.pojoclass.EmployeePojo;

public class insertTest {

	@Test
	public void test() throws SQLException {

		EmployeePojo x=new EmployeePojo();
		CRDUOperations co = new CRDUOperations();
		int check=co.createEmployee(x);
		assertEquals(check,1);
		
		
	}
}
