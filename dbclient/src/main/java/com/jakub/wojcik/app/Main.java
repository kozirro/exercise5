package com.jakub.wojcik.app;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Connection connection;
		PreparedStatement preparedStatement;
		try {

			 connection = DriverManager.getConnection("jdbc:hsqldb:hsql://127.0.0.1:9001/test-db","SA", "");
			
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}
		
		try{
/*-------------------------------Student------------------------*/
		
		//create
		String createStudentTable = "CREATE TABLE Student " +
                "(pkey INTEGER not NULL, " +
                " name VARCHAR(50), " + 
                " sex VARCHAR(10), " + 
                " age INTEGER, " +
                " level INTEGER, " +
                " PRIMARY KEY ( pkey ))"; 
				
		preparedStatement = connection.prepareStatement(createStudentTable);
		preparedStatement.executeUpdate();
		
		//insert
		PreparedStatement insert1s = connection.prepareStatement
			      ("insert into Student values(?,?,?,?,?)");
			     	insert1s.setInt(1,1);
			     	insert1s.setString(2,"John Smith");
			     	insert1s.setString(3,"male");
			     	insert1s.setInt(4,23);
			     	insert1s.setInt(5,2);
			     	
			     	
		PreparedStatement insert2s = connection.prepareStatement
				("insert into Student values(?,?,?,?,?)");
					insert2s.setInt(1,2);
			     	insert2s.setString(2,"Rebecca Milson");
			     	insert2s.setString(3,"female");
			     	insert2s.setInt(4,27);
			     	insert2s.setInt(5,3);
			     	
			     	
		PreparedStatement insert3s = connection.prepareStatement
				("insert into Student values(?,?,?,?,?)");
					insert3s.setInt(1,3);
					insert3s.setString(2,"George Heartbreaker");
					insert3s.setString(3,"male");
					insert3s.setInt(4,19);
					insert3s.setInt(5,1);
					
				
		PreparedStatement insert4s = connection.prepareStatement
				("insert into Student values(?,?,?,?,?)");
					insert4s.setInt(1,4);
					insert4s.setString(2,"Deepika Chopra");
					insert4s.setString(3,"female");
					insert4s.setInt(4,25);
					insert4s.setInt(5,3);
					
					
		insert1s.executeUpdate();
		insert2s.executeUpdate();
		insert3s.executeUpdate();
		insert4s.executeUpdate();
		}catch (Exception e) {
			System.out.println(" " +e);
		}
		
	//---------------------------faculty
		try{
		//create
		String createFacultyTable =" create table Faculty "+
				"(pkey integer not null, "+
				"name varchar(30), "+
				"primary key (pkey))";
				
		preparedStatement = connection.prepareStatement(createFacultyTable);
		preparedStatement.executeUpdate();
			
		//insert	
		PreparedStatement insert1f = connection.prepareStatement
				("insert into Faculty values(?,?)");
					insert1f.setInt(1,100);
					insert1f.setString(2,"Engineering");
					
		PreparedStatement insert2f = connection.prepareStatement
				("insert into Faculty values(?,?)");
					insert2f.setInt(1,101);
					insert2f.setString(2,"Philosophy");
					
		PreparedStatement insert3f = connection.prepareStatement
				("insert into Faculty values(?,?)");
					insert3f.setInt(1,102);
					insert3f.setString(2,"Law and administration");
					
		PreparedStatement insert4f = connection.prepareStatement
				("insert into Faculty values(?,?)");
					insert4f.setInt(1,103);
					insert4f.setString(2,"Languages");
		
		insert1f.executeUpdate();
		insert2f.executeUpdate();
		insert3f.executeUpdate();
		insert4f.executeUpdate();	
		}catch (Exception e) {
			System.out.println(" " +e);
		}
		
	//-----------------------------------class
	//create
		try{
		String createClassTable ="create table Class" +
				"(pkey integer not null, " +
				"name varchar(30), " +
				"fkey_faculty integer, " +
				"primary key (pkey)," +
				"FOREIGN KEY (fkey_faculty) references Faculty(pkey))";
				
		preparedStatement = connection.prepareStatement(createClassTable);
		preparedStatement.executeUpdate();
		
	//inserty
		PreparedStatement insert1c = connection.prepareStatement
				("insert into Class values(?,?,?)");
					insert1c.setInt(1,1000);
					insert1c.setString(2,"Introduction to labour law");
					insert1c.setInt(3,102);
					
		PreparedStatement insert2c = connection.prepareStatement
				("insert into Class values(?,?,?)");
					insert2c.setInt(1,1001);
					insert2c.setString(2,"Graph algorithms");
					insert2c.setInt(3,100);
					
		PreparedStatement insert3c = connection.prepareStatement
				("insert into Class values(?,?,?)");
					insert3c.setInt(1,1002);
					insert3c.setString(2,"Existentialism in 20th century");
					insert3c.setInt(3,101);
					
		PreparedStatement insert4c = connection.prepareStatement
				("insert into Class values(?,?,?)");
					insert4c.setInt(1,1003);
					insert4c.setString(2,"English grammar");
					insert4c.setInt(3,103);
					
		PreparedStatement insert5c = connection.prepareStatement
				("insert into Class values(?,?,?)");
					insert5c.setInt(1,1004);
					insert5c.setString(2,"From Plato to Kant");
					insert5c.setInt(3,101);	
					
		insert1c.executeUpdate();
		insert2c.executeUpdate();
		insert3c.executeUpdate();
		insert4c.executeUpdate();
		insert5c.executeUpdate();
		}catch (Exception e) {
			System.out.println(" " +e);
		}
				
	//-------------------------------Enrollment--------			
				
		try{
				
			//create	
		String createEnrollmentTable ="create table Enrollment" +
					"(fkey_student INTEGER, " +
					"fkey_class INTEGER, " +
					"FOREIGN KEY (fkey_student) REFERENCES Student(pkey), "+
					"FOREIGN KEY (fkey_class) REFERENCES Class(pkey)) ";
					
		preparedStatement = connection.prepareStatement(createEnrollmentTable);
		preparedStatement.executeUpdate();
		
			//insert
		PreparedStatement insert1e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert1e.setInt(1,1);
					insert1e.setInt(2,1000);
					
		PreparedStatement insert2e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert2e.setInt(1,1);
					insert2e.setInt(2,1002);
					
		PreparedStatement insert3e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert3e.setInt(1,1);
					insert3e.setInt(2,1003);
					
		PreparedStatement insert4e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert4e.setInt(1,1);
					insert4e.setInt(2,1004);
					
		PreparedStatement insert5e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert5e.setInt(1,2);
					insert5e.setInt(2,1002);
					
		PreparedStatement insert6e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert6e.setInt(1,2);
					insert6e.setInt(2,1003);
					
		PreparedStatement insert7e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert7e.setInt(1,4);
					insert7e.setInt(2,1000);
					
		PreparedStatement insert8e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert8e.setInt(1,4);
					insert8e.setInt(2,1002);
					
		PreparedStatement insert9e = connection.prepareStatement
				("insert into Enrollment values(?,?)");
					insert9e.setInt(1,4);
					insert9e.setInt(2,1003);
		
		
		insert1e.executeUpdate();
		insert2e.executeUpdate();
		insert3e.executeUpdate();
		insert4e.executeUpdate();
		insert5e.executeUpdate();
		insert6e.executeUpdate();
		insert7e.executeUpdate();
		insert8e.executeUpdate();
		insert9e.executeUpdate();
		
		
				
		}catch (Exception e) {
			System.out.println(" " +e);
		}
			     	
/*-----------------------------------selecty----------------------------------*/
	try{	
			     	PreparedStatement select1 = connection.prepareStatement("select pkey,name from Student");
			     	ResultSet rs1 = select1.executeQuery();
			     	System.out.println(" select1");
			        while (rs1.next()) {
			            int pkey = rs1.getInt("pkey");
			            String name = rs1.getString("name");			     
			            System.out.println("pkey="+" "+pkey + " name=" + name);
			         }   
			        
					PreparedStatement select2 = connection.prepareStatement
							   ("select s.pkey, s.name from Student s  left join Enrollment e On s.pkey=e.fkey_student where fkey_student is null ");
						ResultSet rs2 = select2.executeQuery();
						System.out.println(" select2");
						 while (rs2.next()) {		
							 	int pkey = rs2.getInt("pkey");
								String name =rs2.getString("name");
								System.out.println("pkey= "+pkey +" name= "+name);
						}
						
			       PreparedStatement select3 = connection.prepareStatement
			    		   ("select DISTINCT s.pkey, s.name from Student s join Enrollment e On s.pkey=e.fkey_Student join Class c On e.fkey_class=c.pkey where s.sex='female' and c.name='Existentialism in 20th century'");
			     	ResultSet rs3 = select3.executeQuery();
			     	System.out.println(" select3");
			     	 while (rs3.next()) {
				            int pkey = rs3.getInt("pkey");
				            String name =rs3.getString("name");
				            System.out.println("pkey="+pkey + "  "+"name="+ name);
				         }
						 
					 PreparedStatement select4 = connection.prepareStatement
									   ("select f.name from Faculty f left  join Class c On f.pkey=c.fkey_faculty left  join Enrollment e On c.pkey=e.fkey_class where e.fkey_student is null");
								ResultSet rs4 = select4.executeQuery();
								System.out.println(" select4");
								 while (rs4.next()) {		
			
										String name =rs4.getString("name");
										System.out.println("name= "+name);
								}
							
					PreparedStatement select5 = connection.prepareStatement
					   ("select distinct s.age from Student s  join Enrollment e On s.pkey=e.fkey_Student join Class c On e.fkey_class=c.pkey where s.age=(select max(s.age) from Student s join Enrollment e On s.pkey=e.fkey_Student join Class c On e.fkey_class=c.pkey where c.name='Introduction to labour law') and c.name='Introduction to labour law'");
						ResultSet rs5 = select5.executeQuery();
						System.out.println(" select5");
						while (rs5.next()) {
						int age = rs5.getInt("age");
						System.out.println("age= "+age);
						}
	     	 
	     	 
					PreparedStatement select6 = connection.prepareStatement
		    		   ("select c.name from Class c join Enrollment e On c.pkey=e.fkey_Class group by c.pkey having count(e.fkey_Student)>1");
						ResultSet rs6 = select6.executeQuery();
						System.out.println(" select6");
						while (rs6.next()) {		
			            String name =rs6.getString("name");
			            System.out.println("name= "+name);
			         }
							
			     	PreparedStatement select7 = connection.prepareStatement
			     			("select avg(age),level from Student group by level");
			     	ResultSet rs7 = select7.executeQuery();
			     	System.out.println(" select7");
			     	 while(rs7.next()) {
			     		 	float age = rs7.getFloat(1);
			     		 	String level=rs7.getString("level");
			     		 	System.out.println("level= "+level+" age= " + age);
			     	 }
			     	 
					
		     	 

		     	 

					
							
		
		

		
	} catch (Exception e) {
		System.out.println(" " +e);
	}
		
		

	}
}
