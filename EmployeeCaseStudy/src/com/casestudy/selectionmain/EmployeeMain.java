package com.casestudy.selectionmain;


import java.util.Scanner;

import com.casestudy.operations.CRDUOperations;
import com.casestudy.pojoclass.EmployeePojo;

public class EmployeeMain
{
    public static void main(String[] args) throws Exception 
	{
	    //creating objects of CRDU OPERATION and EmployeePojo
		CRDUOperations co = new CRDUOperations();
		EmployeePojo ep = new EmployeePojo();
		//creating a while loop to check and select particular operation
		int ch=0;
		while(ch==0)
		{
			System.out.println("select the option");
			System.out.println("1.insert employee details");
			System.out.println("2.Read employee details");
			System.out.println("3.Update Employee details");
			System.out.println("4.delete employee details");
			//creation an object of scanner to take input from employee or user
			Scanner sc = new Scanner(System.in);
			int option=sc.nextInt();
			switch(option)
			{
			//Create option
			case 1:
			{
				    System.out.println("Enter employee name");
				    ep.setEmployee_Name(sc.next());
				    System.out.println("Enter employee address");
				    ep.setEmployee_Address(sc.next());
				    System.out.println("enter date of joining");
				    ep.setDate_Of_Joining(sc.next());
				    System.out.println("enter experience");
				    ep.setExperience(sc.nextInt());
				    System.out.println("enter date of birth");
				    ep.setDate_Of_Birth(sc.next());
				    int val=co.createEmployee(ep);
				    if(val==0)
				    {
				    	System.out.println("employee details not created");
				    }
				    else
				    {
				    	System.out.println("employee details created");
				    }
				    break;
			}
			
			//Read option
			case 2:
			{
				    System.out.println("enter employee id to read the details");
				    ep.setEmployee_Id(sc.nextInt());
				    co.readEmployee(ep);
				    break;
			}
			//Update details
			case 3:
			{
				   System.out.println("Enter Emp_Id to update its details");
			       ep.setEmployee_Id(sc.nextInt());
			       System.out.println("Enter Emp_Name");
		           ep.setEmployee_Name(sc.next());
		           System.out.println("Enter Emp_Add");
		           ep.setEmployee_Address(sc.next());
		           System.out.println("Enter Date_of_joining");
		           ep.setDate_Of_Joining(sc.next());
		           System.out.println("Enter Experience");
		           ep.setExperience(sc.nextInt());
		           System.out.println("Enter Date_of_Birth");
		           ep.setDate_Of_Birth(sc.next());
		           int val = co.updateEmp(ep);
		           if(val==0) 
		           {
		    	    System.out.println("Employee details not Updated");
		    	    }
		           else
		           {
		    	    System.out.println("Employee details Updated");
		    	   }
		           break;
			}
			//delete employee details
			case 4:
			{
			       
				   System.out.println("Enter Emp_Id to Delete employee");
			       ep.setEmployee_Id(sc.nextInt());
			       int val = co.deleteEmp(ep);
		           if(val==0)
		           {
		    	    System.out.println("Employee not Deleted");
		    	    }
		           else
		           {
		    	    System.out.println("Employee Deleted");
		    	   }
		           break;
		           
		    }
			default:System.out.println("ivalid option");
		  } 
			System.out.println("Press 0 to continue");
			ch = sc.nextInt();
			}

	}

}
