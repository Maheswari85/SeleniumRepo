package org.Student;

import org.College.College;
import org.Department.Department;

public class Student extends Department{
	public void studentName (String stName) {
		
		System.out.println("Student name is " + stName);
		
	}
	public void studentDept(String stDept)
	{
		System.out.println("Students department is " + stDept);
	}

	public void studentId(int stId)
	{
		System.out.println("Student ID is " +stId );
	}

	public static void main(String[] args) {
		College name = new College();
		name.collegeName("Sastra");
		name.collegeCode(170);
		name.collegeRank(2);
		
		System.out.println("  ");
		
		Department depN = new Department();
		depN.collegeName("SVC");
		depN.collegeCode(2380);
		depN.collegeRank(10);
		depN.deptName("CSE");
		
		System.out.println("  ");
		
		Student stInfo = new Student();
		stInfo.collegeName("Panimalar");
		stInfo.collegeCode(1670);
		stInfo.collegeRank(9);
		stInfo.deptName("ECE");
		stInfo.studentName("Santhosh");
		stInfo.studentDept("EEE");
		stInfo.studentId(14567);
		
		
	}
	}
