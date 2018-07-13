package com.benefit.pilot.rba.Models.Medical;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class IndividualStopLoss {
	
	//private int Id;
	@CsvBindByName
	private int Month;
	@CsvBindByName
	private int Year;
	@CsvBindByName
	private String Account_Number;
	@CsvBindByName
	private String Division_Code;
	@CsvBindByName
	private String Plan_Code;
	@CsvBindByName
	private String Member_ID;
	@CsvBindByName
	private double YTD_Reimbursment;
	@CsvBindByName
	private double  Total_Monthly_Reimbursements;
	@CsvBindByName
	private double  Laser_Amount;
	@CsvBindByName
	private double Total_Policy_YTD_Claims;
	@CsvBindByName
	private String  Status;
	@CsvBindByName
	private double  PMPM_Claims_Cost;
}
