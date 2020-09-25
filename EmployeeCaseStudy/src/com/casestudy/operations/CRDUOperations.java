package com.casestudy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.casestudy.pojoclass.EmployeePojo;

public class CRDUOperations 
{
	//This method is used to create or insert the employee details
	public int createEmployee(EmployeePojo x) throws SQLException 
	{
		Connection con = null;
		Statement stmt = null;
		int result=0;
		
		try 
		{
			//To open connection to database
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "1234");
		     stmt= con.createStatement();
		     //SQL query to insert employee details
		     String sql="insert into employee"
						+ "(Employee_Name, Employee_Address, Date_of_Joining, Experience, Date_of_Birth) values \r\n" + 
						"( ?,?,?,?,?)";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1,x.getEmployee_Name());
			pt.setString(2,x.getEmployee_Address());
			pt.setString(3,x.getDate_Of_Joining());
			pt.setInt(4,x.getExperience());
			pt.setString(5,x.getDate_Of_Birth());
			 result = pt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(NullPointerException e)
		{
			System.out.println("some problem");
		}
		
		//closing connection and statement in finally block
		finally {
			try
			{
				if(stmt!=null)
				{
		        stmt.close();	
		        }	
				if(con!=null) 
				{
	             con.close();
		       }
			}
			catch(SQLException e)
			{
			e.printStackTrace();
			}
	    
		  }
		return result;
		
	}
	
	//This method is used fetch employee details 
	public void readEmployee(EmployeePojo x) throws SQLException
	{
		Statement stmt=null;
		Connection con=null;
		ResultSet rs=null;
		try
		{
			
			//To open connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "1234");
			 stmt = con.createStatement();
			 //SQL query to read employee details
			 String sql="select * from employee where Employee_Id="+x.getEmployee_Id();
			 rs=stmt.executeQuery(sql);
			if(rs.first())
			{
			 rs=stmt.executeQuery(sql);
			  while(rs.next())
			{
			  System.out.println("Employee Id :"+rs.getInt("Employee_Id")+
								 "\nEmployee Name :"+rs.getString("Employee_Name")+
								  "\nEmployee Adress :"+rs.getString("Employee_Address")+
								  "\nDate of Joining :"+rs.getString("Date_Of_JOining")+
								  "\nExperience :"+rs.getInt("Experience")+
								  "/nDate of Birth :"+rs.getString("Date_Of_BIrth"));
			}
			}
			else
				{
					System.out.println("employee with given id not found");
				}
				}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
		try
		{
		if(stmt!=null) 
		{
		stmt.close();	
		}	
		if(con!=null)
		{
	    con.close();
		}}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
	    }
}	
	
	//This method is used to update employee details 
	public int updateEmp(EmployeePojo x) throws SQLException
	{
		Connection con = null;
		PreparedStatement stmt = null;
		int result=0;
		try 
		{
		    //To open connection
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root" , "1234");
			String sql=" update employee SET Employee_Name = ?, Employee_Address = ?, Date_of_Joining=?, Experience =?,Date_of_Birth=?\r\n" + 
					" where Employee_Id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(6, x.getEmployee_Id());
			stmt.setString(1,x.getEmployee_Name());
			stmt.setString(2,x.getEmployee_Address());
			stmt.setString(3,x.getDate_Of_Joining());
			stmt.setInt(4,x.getExperience());
			stmt.setString(5,x.getDate_Of_Birth());
		    result = stmt.executeUpdate();
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally 
		{
			try 
			{
				if(stmt!=null)
				{
		       stmt.close();	
		        }	
				if(con!=null)
				{
	            con.close();
		        }
			}
			catch(SQLException e)
			{
			e.printStackTrace();
			}
	  	}
        return result;
	}
	
	//This method is used to delete employee details
	public int deleteEmp(EmployeePojo x) throws SQLException 
	{
		Connection con = null;
		PreparedStatement stmt = null;
		int result=0;
		try 
		{
			//To open connection
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root" , "1234");			
			 String sql="delete from employee where Employee_Id = ?";
			 stmt = con.prepareStatement(sql);
			 stmt.setInt(1, x.getEmployee_Id());
		     result = stmt.executeUpdate();
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(stmt!=null)
				{
		        stmt.close();	
		        }	
				if(con!=null)
				{
	            con.close();
		        }
				}
			catch(SQLException e)
			{
			e.printStackTrace();
			}
	    
		}

		return result;
	}
		
}
