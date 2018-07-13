package com.benefit.pilot.rba.Repositories;

public interface RbaDashboardQuery {
	
	public static final String QUERY_INSERT_MEDICAL_Rx1 = "INSERT INTO medical_rx1 (Account_Name, Account_Number, Division_Code,EmpSP_1,Emp_1,Emp_2_or_More_1,Emp_Child_ren_1,"
			+ "Emp_Family_1,Emp_Only_1,ISL_Reimbursements,Month,Net_Claims,PEPM_Claims_Cost,PMPM_Claims_Cost,Plan_Code,Total_Employees,Total_Monthly_Medical_Claims,"
			+ "Total_Monthly_Members,Total_Policy_YTD_Claims,Year) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?,?)";
	
	public static final String QUERY_INSERT_MEDICAL_Rx2 = "INSERT INTO medical_rx2 (Month,Year,Account_Name, Account_Number, Plan_Code,Division_Code,Total_Employees,Emp_Only_1,EmpSP_1,Emp_1,Emp_2_or_More_1,Emp_Children_1,"
			+ "Emp_Family_1,Total_Monthly_Members, Total_Monthly_Medical_Claims, PEPM_Claims_Cost, PMPM_Claims_Cost, ISL_Reimbursements,Net_Claims,"
			+ "Total_Policy_YTD_Claims) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?,?)";
	
	public static final String QUERY_INSERT_RXONLY1 = "INSERT INTO rxonly_1(Month,Year,Account_Name, Account_Number, Plan_Code,Division_Code,Total_Employees,Emp_Only_1,EmpSP_1,Emp_1,Emp_2_or_More_1,Emp_Children_1,"
			+ "Emp_Family_1,Total_Monthly_Members, Total_Monthly_Rx_Claims, PEPM_Claims_Cost,"
			+ "Total_Policy_YTD_Claims, Rebates, Average_AWP_Discount, Lowest_AWP_Discount, Highest_AWP_Discount) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,?)";
	
	public static final String QUERY_INSERT_RXONLY2 = "INSERT INTO rxonly_2(Month,Year,Account_Name, Account_Number, Plan_Code,Division_Code,Total_Employees,Emp_Only_1,EmpSP_1,Emp_1,Emp_2_or_More_1,Emp_Children_1,"
			+ "Emp_Family_1,Total_Monthly_Members, Total_Monthly_Rx_Claims, PEPM_Claims_Cost,"
			+ "Total_Policy_YTD_Claims, Rebates, Average_AWP_Discount, Lowest_AWP_Discount, Highest_AWP_Discount) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,?)";
	
	public static final String QUERY_INSERT_DENTAL1 = "INSERT INTO dental_1(Month,Year,Account_Name, Account_Number, Plan_Code, Division_Code, Total_Employees, Emp_Only_1, EmpSP_1, Emp_1, Emp_2_or_More_1, Emp_Children_1,"
			+ "Emp_Family_1, Total_Monthly_Members, Total_Monthly_Dental_Claims, PEPM_Claims_Cost,"
			+ "PMPM_Claims_Cost,Total_Policy_YTD_Claims) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
	
	public static final String QUERY_INSERT_DENTAL2 = "INSERT INTO dental_2(Month,Year,Account_Name, Account_Number, Plan_Code, Division_Code, Total_Employees, Emp_Only_1, EmpSP_1, Emp_1, Emp_2_or_More_1, Emp_Children_1,"
			+ "Emp_Family_1, Total_Monthly_Members, Total_Monthly_Dental_Claims, PEPM_Claims_Cost,"
			+ "PMPM_Claims_Cost,Total_Policy_YTD_Claims) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
	
	public static final String QUERY_INSERT_INDIVIDUAL_STOP_LOSS = "INSERT INTO individual_stop_loss(Month, Year, Account_Number, Division_Code, Plan_Code, Member_ID, YTD_Reimbursment, Total_Monthly_Reimbursements,"
			+ "Laser_Amount, Total_Policy_YTD_Claims, Status, PMPM_Claims_Cost) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
	
	public static final String QUERY_INSERT_VISION = "INSERT INTO vision(Month,Year,Account_Name, Account_Number, Plan_Code, Division_Code, Total_Employees, Emp_Only_1, EmpSP_1, Emp_1, Emp_2_or_More_1, Emp_Children_1,"
			+ "Emp_Family_1, Total_Monthly_Members, Total_Monthly_Vision_Claims, PEPM_Claims_Cost,"
			+ "PMPM_Claims_Cost,Total_Policy_YTD_Claims) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
	
	public static final String QUERY_INSERT_CLINIC = "INSERT INTO clinic(Month,Year,Account_Name, Account_Number, Plan_Code, Division_Code, Total_Employees, Emp_Only_1, EmpSP_1, Emp_1, Emp_2_or_More_1, Emp_Children_1,"
			+ "Emp_Family_1, Total_Monthly_Members, Total_Monthly_Clinic_Claims, PEPM_Claims_Cost,"
			+ "PMPM_Claims_Cost,Total_Policy_YTD_Claims) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
	
	public static final String QUERY_GET_MEDICAL_Rx1_DATA ="SELECT * FROM medical_rx1";
	
	public static final String QUERY_GET_MEDICALRX2="SELECT * FROM medical_rx2";
	
	public static final String QUERY_GET_RXONLY1="SELECT * FROM rxonly_1";
	
	public static final String QUERY_GET_RXONLY2="SELECT * FROM rxonly_2";
	
	public static final String QUERY_GET_DENTAL1="SELECT * FROM dental_1";
	
	public static final String QUERY_GET_DENTAL2 ="SELECT * FROM dental_2";
	
	public static final String QUERY_GET_INDIVIDUAL_STOP_LOSS ="SELECT * FROM individual_stop_loss";
	
	public static final String VISION ="SELECT * FROM vision";
	
	public static final String CLINIC ="SELECT * FROM clinic";
	
}