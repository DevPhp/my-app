package com.benefit.pilot.rba.Services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.benefit.pilot.rba.CommonConstants.APIConstant;
import com.benefit.pilot.rba.CommonConstants.APIResponse;
import com.benefit.pilot.rba.Models.Medical.Clinic;
import com.benefit.pilot.rba.Models.Medical.Dental_1;
import com.benefit.pilot.rba.Models.Medical.Dental_2;
import com.benefit.pilot.rba.Models.Medical.IndividualStopLoss;
import com.benefit.pilot.rba.Models.Medical.MedicalRx1Info;
import com.benefit.pilot.rba.Models.Medical.MedicalRx2;
import com.benefit.pilot.rba.Models.Medical.MultiPartToFile;
import com.benefit.pilot.rba.Models.Medical.RxOnly1;
import com.benefit.pilot.rba.Models.Medical.RxOnly2;
import com.benefit.pilot.rba.Models.Medical.Vision;
import com.benefit.pilot.rba.Repositories.RbaDashboardQuery;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class UploadService {

		@Autowired
	    private JdbcTemplate jdbcTemplate;

	 	//MedicalRx1 -> inserting data into db
	 	public List<MedicalRx1Info> medicalRx1(MultipartFile multipartFile) throws IOException {
	 	//File file = convertMultiPartToFile(multipartFile);
	 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
		List<MedicalRx1Info> rxList = new ArrayList<>();
		try (Reader reader = new FileReader(file);) {
			
			@SuppressWarnings("unchecked")
			CsvToBean<MedicalRx1Info> csvToBean = new CsvToBeanBuilder<MedicalRx1Info>(reader).withType(MedicalRx1Info.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<MedicalRx1Info> list = csvToBean.parse();

			Iterator<MedicalRx1Info> medicalListClone = list.iterator();
			while (medicalListClone.hasNext()) {
				MedicalRx1Info info = medicalListClone.next();
				rxList.add(info);
				String sql = RbaDashboardQuery.QUERY_INSERT_MEDICAL_Rx1;
				jdbcTemplate.update(sql, info.getAccount_Name(),info.getAccount_Number(),info.getDivision_Code(),info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
							 info.getEmp_Child_ren_1(),info.getEmp_Family_1(),info.getEmp_Only_1(),info.getISL_Reimbursements(),info.getMonth(),info.getNet_Claims(),
							 info.getPEPM_Claims_Cost(),info.getPMPM_Claims_Cost(),info.getPlan_Code(),info.getTotal_Employees(),info.getTotal_Monthly_Medical_Claims(),info.getTotal_Monthly_Members(),
							 info.getTotal_Policy_YTD_Claims(),info.getYear());
					 		
				} // end of while
			
		} // end of try 
		catch(Exception e) {
			e.printStackTrace();
		}
		return rxList;
}
	 	
	  public List<MedicalRx2> medicalRx2(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<MedicalRx2> medicalRx2List = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<MedicalRx2> csvToBean = new CsvToBeanBuilder<MedicalRx2>(reader).withType(MedicalRx2.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<MedicalRx2> list = csvToBean.parse();

				Iterator<MedicalRx2> medicalListClone = list.iterator();
				while (medicalListClone.hasNext()) {
					MedicalRx2 info = medicalListClone.next();
					medicalRx2List.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_MEDICAL_Rx2;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(), info.getAccount_Name(),info.getAccount_Number(), info.getPlan_Code(), info.getDivision_Code(), info.getTotal_Employees(), info.getEmp_Only_1(), info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
								 info.getEmp_Children_1(),info.getEmp_Family_1(),info.getTotal_Monthly_Members(), info.getTotal_Monthly_Medical_Claims(), info.getPEPM_Claims_Cost(), info.getPMPM_Claims_Cost(),info.getISL_Reimbursements(),info.getNet_Claims(),
								 info.getTotal_Policy_YTD_Claims());
						 		
					} // end of while
				
			} // end of try 
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return medicalRx2List;
	}
	 	
	 	public List<RxOnly1> rxonly1(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<RxOnly1> rxOnly1List = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<RxOnly1> csvToBean = new CsvToBeanBuilder<RxOnly1>(reader).withType(RxOnly1.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<RxOnly1> list = csvToBean.parse();

				Iterator<RxOnly1> rxOnlyListClone = list.iterator();
				while (rxOnlyListClone.hasNext()) {
					RxOnly1 info = rxOnlyListClone.next();
					rxOnly1List.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_RXONLY1;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(), info.getAccount_Name(),info.getAccount_Number(), info.getPlan_Code(), info.getDivision_Code(), info.getTotal_Employees(), info.getEmp_Only_1(), info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
								 info.getEmp_Children_1(),info.getEmp_Family_1(),info.getTotal_Monthly_Members(), info.getTotal_Monthly_Rx_Claims(), info.getPEPM_Claims_Cost(),
								 info.getTotal_Policy_YTD_Claims(), info.getRebates(), info.getAverage_AWP_Discount(), info.getLowest_AWP_Discount(), info.getHighest_AWP_Discount());
						 		 
					} // end of while
				
			} // end of try 
			catch(Exception e) {
				e.printStackTrace();
			}
			return rxOnly1List;
	}
	 	
	 	public List<RxOnly2> rxonly2(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<RxOnly2> rxOnly2List = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<RxOnly2> csvToBean = new CsvToBeanBuilder<RxOnly2>(reader).withType(RxOnly2.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<RxOnly2> list = csvToBean.parse();

				Iterator<RxOnly2> rxOnlyListClone = list.iterator();
				while (rxOnlyListClone.hasNext()) {
					RxOnly2 info = rxOnlyListClone.next();
					rxOnly2List.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_RXONLY2;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(), info.getAccount_Name(),info.getAccount_Number(), info.getPlan_Code(), info.getDivision_Code(), info.getTotal_Employees(), info.getEmp_Only_1(), info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
								 info.getEmp_Children_1(),info.getEmp_Family_1(),info.getTotal_Monthly_Members(), info.getTotal_Monthly_Rx_Claims(), info.getPEPM_Claims_Cost(),
								 info.getTotal_Policy_YTD_Claims(), info.getRebates(), info.getAverage_AWP_Discount(), info.getLowest_AWP_Discount(), info.getHighest_AWP_Discount());
						} // end of while
				
			} // end of try 
			catch(Exception e) {
				e.printStackTrace();
			}
			return rxOnly2List;
	}
	 	
	 	public List<Dental_1> dental1(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<Dental_1> dental1List = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<Dental_1> csvToBean = new CsvToBeanBuilder<Dental_1>(reader).withType(Dental_1.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<Dental_1> list = csvToBean.parse();
				Iterator<Dental_1> rxOnlyListClone = list.iterator();
				while (rxOnlyListClone.hasNext()) {
					Dental_1 info = rxOnlyListClone.next();
					dental1List.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_DENTAL1;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(), info.getAccount_Name(),info.getAccount_Number(), info.getPlan_Code(), info.getDivision_Code(), info.getTotal_Employees(), info.getEmp_Only_1(), info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
								 info.getEmp_Children_1(),info.getEmp_Family_1(),info.getTotal_Monthly_Members(), info.getTotal_Monthly_Dental_Claims(), info.getPEPM_Claims_Cost(),
								 info.getPMPM_Claims_Cost(), info.getTotal_Policy_YTD_Claims());
						 		
					} // end of while
				
			} // end of try 
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return dental1List;
	}
	 	
	 	
	 	public List<Dental_2> dental2(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<Dental_2> dental2List = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<Dental_2> csvToBean = new CsvToBeanBuilder<Dental_2>(reader).withType(Dental_2.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<Dental_2> list = csvToBean.parse();
				Iterator<Dental_2> rxOnlyListClone = list.iterator();
				while (rxOnlyListClone.hasNext()) {
					Dental_2 info = rxOnlyListClone.next();
					dental2List.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_DENTAL2;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(), info.getAccount_Name(),info.getAccount_Number(), info.getPlan_Code(), info.getDivision_Code(), info.getTotal_Employees(), info.getEmp_Only_1(), info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
								 info.getEmp_Children_1(),info.getEmp_Family_1(),info.getTotal_Monthly_Members(), info.getTotal_Monthly_Dental_Claims(), info.getPEPM_Claims_Cost(),
								 info.getPMPM_Claims_Cost(), info.getTotal_Policy_YTD_Claims());
						 		 
					} // end of while
				
			} // end of try 
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return dental2List;
	}
	 	
	 	public List<IndividualStopLoss> individualStopLoss(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<IndividualStopLoss> individualStopLossList = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<IndividualStopLoss> csvToBean = new CsvToBeanBuilder<IndividualStopLoss>(reader).withType(IndividualStopLoss.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<IndividualStopLoss> list = csvToBean.parse();
				Iterator<IndividualStopLoss> rxOnlyListClone = list.iterator();
				while (rxOnlyListClone.hasNext()) {
					IndividualStopLoss info = rxOnlyListClone.next();
					individualStopLossList.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_INDIVIDUAL_STOP_LOSS;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(),info.getAccount_Number(), info.getDivision_Code(), info.getPlan_Code(),  info.getMember_ID(), info.getYTD_Reimbursment(), info.getTotal_Monthly_Reimbursements(),info.getLaser_Amount(),info.getTotal_Policy_YTD_Claims(),
								 info.getStatus(),info.getPMPM_Claims_Cost());
						 		 
					} // end of while
				
			} // end of try 
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return individualStopLossList;
	}
	 	
	 	public List<Vision> vision(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<Vision> vision = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<Vision> csvToBean = new CsvToBeanBuilder<Vision>(reader).withType(Vision.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<Vision> list = csvToBean.parse();
				Iterator<Vision> rxOnlyListClone = list.iterator();
				while (rxOnlyListClone.hasNext()) {
					Vision info = rxOnlyListClone.next();
					vision.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_VISION;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(), info.getAccount_Name(),info.getAccount_Number(), info.getPlan_Code(), info.getDivision_Code(), info.getTotal_Employees(), info.getEmp_Only_1(), info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
							 info.getEmp_Children_1(),info.getEmp_Family_1(),info.getTotal_Monthly_Members(), info.getTotal_Monthly_Vision_Claims(), info.getPEPM_Claims_Cost(),
							 info.getPMPM_Claims_Cost(), info.getTotal_Policy_YTD_Claims());
						 		 
					} // end of while
				
			} // end of try 
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return vision;
	}
	 	
	 	public List<Clinic> clinic(MultipartFile multipartFile) throws IOException {
		 	//File file = convertMultiPartToFile(multipartFile);
		 	File file = MultiPartToFile.convertMultiPartToFile(multipartFile);	
			List<Clinic> vision = new ArrayList<>();
			try (Reader reader = new FileReader(file);) {
				
				@SuppressWarnings("unchecked")
				CsvToBean<Clinic> csvToBean = new CsvToBeanBuilder<Clinic>(reader).withType(Clinic.class)
						.withIgnoreLeadingWhiteSpace(true).build();
				List<Clinic> list = csvToBean.parse();
				Iterator<Clinic> rxOnlyListClone = list.iterator();
				while (rxOnlyListClone.hasNext()) {
					Clinic info = rxOnlyListClone.next();
					vision.add(info);
					String sql = RbaDashboardQuery.QUERY_INSERT_CLINIC;
					jdbcTemplate.update(sql, info.getMonth(), info.getYear(), info.getAccount_Name(),info.getAccount_Number(), info.getPlan_Code(), info.getDivision_Code(), info.getTotal_Employees(), info.getEmp_Only_1(), info.getEmpSP_1(),info.getEmp_1(),info.getEmp_2_or_More_1(),
							 info.getEmp_Children_1(),info.getEmp_Family_1(),info.getTotal_Monthly_Members(), info.getTotal_Monthly_Clinic_Claims(), info.getPEPM_Claims_Cost(),
							 info.getPMPM_Claims_Cost(), info.getTotal_Policy_YTD_Claims());
						 		 
					} // end of while
				
			} // end of try 
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return vision;
	}



	/*private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}*/

	public List<MedicalRx1Info> getAllData() {
		   String sql = RbaDashboardQuery.QUERY_GET_MEDICAL_Rx1_DATA;
		   RowMapper<MedicalRx1Info> rowMapper = new BeanPropertyRowMapper<MedicalRx1Info>(MedicalRx1Info.class);		
		   return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public APIResponse<List<MedicalRx2>> getMedicalRx2Data() {
		   String sql = RbaDashboardQuery.QUERY_GET_MEDICALRX2;
		   RowMapper<MedicalRx2> rowMapper = new BeanPropertyRowMapper<MedicalRx2>(MedicalRx2.class);
		   APIResponse<List<MedicalRx2>> response=new APIResponse<>();
		   List<MedicalRx2> listMedicalRx2= this.jdbcTemplate.query(sql, rowMapper);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listMedicalRx2);
		   return response;
		   
	}
	
	public APIResponse<List<RxOnly1>> getRxOnly1Data() {
		   String sql = RbaDashboardQuery.QUERY_GET_RXONLY1;
		   RowMapper<RxOnly1> rowMapper = new BeanPropertyRowMapper<RxOnly1>(RxOnly1.class);	
		   APIResponse<List<RxOnly1>> response=new APIResponse<>();
		   List<RxOnly1> listRxOnly1= this.jdbcTemplate.query(sql, rowMapper);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listRxOnly1);
		   return response;
	}
	
	public APIResponse<List<RxOnly2>> getRxOnly2Data() {
		   String sql = RbaDashboardQuery.QUERY_GET_RXONLY2;
		   RowMapper<RxOnly2> rowMapper = new BeanPropertyRowMapper<RxOnly2>(RxOnly2.class);		
		   APIResponse<List<RxOnly2>> response=new APIResponse<>();
		   List<RxOnly2> listRxOnly2= this.jdbcTemplate.query(sql, rowMapper);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listRxOnly2);
		   return response;
	}
	
	public APIResponse<List<Dental_1>> getDental1Data()
	{
		   String sql =  RbaDashboardQuery.QUERY_GET_DENTAL1;
		   RowMapper<Dental_1> rowMapper = new BeanPropertyRowMapper<Dental_1>(Dental_1.class);
		   APIResponse<List<Dental_1>> response=new APIResponse<>();
		   List<Dental_1> listDental_1= this.jdbcTemplate.query(sql, rowMapper);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listDental_1);
		   return response;
	}
	
	public APIResponse<List<Dental_2>> getDental2Data()
	{
		   String sql =  RbaDashboardQuery.QUERY_GET_DENTAL2;
		   RowMapper<Dental_2> rowMapper = new BeanPropertyRowMapper<Dental_2>(Dental_2.class);
		   APIResponse<List<Dental_2>> response=new APIResponse<>();
		   List<Dental_2> listDental_2= this.jdbcTemplate.query(sql, rowMapper);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listDental_2);
		   return response;
	}
	
	public APIResponse<List<IndividualStopLoss>> getIndividualStopLossData()
	{
		   String sql =  RbaDashboardQuery.QUERY_GET_INDIVIDUAL_STOP_LOSS;
		   RowMapper<IndividualStopLoss> rowMapper = new BeanPropertyRowMapper<IndividualStopLoss>(IndividualStopLoss.class);
		   APIResponse<List<IndividualStopLoss>> response=new APIResponse<>();
		   List<IndividualStopLoss> listIndividualStopLoss= this.jdbcTemplate.query(sql, rowMapper);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listIndividualStopLoss);
		   return response;
	}
	
	public APIResponse<List<Vision>> getVisionData()
	{
		   String sql =  RbaDashboardQuery.VISION;
		   RowMapper<Vision> rowMapper = new BeanPropertyRowMapper<Vision>(Vision.class);
		   APIResponse<List<Vision>> response=new APIResponse<>();
		   List<Vision> listVision= this.jdbcTemplate.query(sql, rowMapper);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listVision);
		   return response;
	}
	
	public APIResponse<List<Clinic>> getClinicData()
	{
		   String sql =  RbaDashboardQuery.CLINIC;
		   RowMapper<Clinic> rowMapper = new BeanPropertyRowMapper<Clinic>(Clinic.class);
		   APIResponse<List<Clinic>> response=new APIResponse<>();
		   List<Clinic> listClinic= this.jdbcTemplate.query(sql, rowMapper);
		   //List<Clinic> listClinic= jdbcTemplate.queryForObject(sql, Clinic.class);
		   response.setStatus(APIConstant.SUCCESS.intValue());
		   response.setMessage("success");
		   response.setResponse(listClinic);
		   return response;
	}
}