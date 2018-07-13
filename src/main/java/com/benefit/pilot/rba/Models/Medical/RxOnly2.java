package com.benefit.pilot.rba.Models.Medical;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class RxOnly2 {
	
	//private int Id;
	@CsvBindByName
	private int Month;
	@CsvBindByName
	private int Year;
	@CsvBindByName
	private String Account_Name;
	@CsvBindByName
	private String Account_Number;
	@CsvBindByName
	private String Plan_Code;
	@CsvBindByName(column="Division_Code")
	private String Division_Code;
	@CsvBindByName(column="Total_Employees")
	private int Total_Employees;
	@CsvBindByName
	private int Emp_Only_1;
	@CsvBindByName
	private int EmpSP_1;
	@CsvBindByName
	private int Emp_1;
	@CsvBindByName
	private double Emp_2_or_More_1;
	@CsvBindByName(column="Emp_Child(ren)_1")
	private int Emp_Children_1;
	@CsvBindByName
	private int Emp_Family_1;
	@CsvBindByName
	private double Total_Monthly_Members;
	@CsvBindByName
	private double Total_Monthly_Rx_Claims;
	@CsvBindByName(column="PEPM_Claims Cost")
	private double PEPM_Claims_Cost;
	@CsvBindByName
	private int Total_Policy_YTD_Claims;
	@CsvBindByName
	private int Rebates;
	@CsvBindByName(column="Average_AWP_Discount")
	private int Average_AWP_Discount;
	@CsvBindByName
	private int Lowest_AWP_Discount;
	@CsvBindByName
	private int Highest_AWP_Discount;
}
