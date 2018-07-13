package com.benefit.pilot.rba.Controllers;



import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.benefit.pilot.rba.CommonConstants.APIResponse;
import com.benefit.pilot.rba.Models.Medical.Clinic;
import com.benefit.pilot.rba.Models.Medical.Dental_1;
import com.benefit.pilot.rba.Models.Medical.Dental_2;
import com.benefit.pilot.rba.Models.Medical.IndividualStopLoss;
import com.benefit.pilot.rba.Models.Medical.MedicalRx1Info;
import com.benefit.pilot.rba.Models.Medical.MedicalRx2;
import com.benefit.pilot.rba.Models.Medical.RxOnly1;
import com.benefit.pilot.rba.Models.Medical.RxOnly2;
import com.benefit.pilot.rba.Models.Medical.Vision;
import com.benefit.pilot.rba.Services.UploadService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class MedicalRXController {
	
	  	private UploadService uploadService;
	  
	  	@Autowired
	  	public MedicalRXController(UploadService uploadService) {
	      this.uploadService=uploadService;
	  	}
	  	
	  	@RequestMapping(value = "/medical-rx1", method = RequestMethod.POST)
		public List<MedicalRx1Info> medicalRx1(@RequestPart(value = "file") MultipartFile multiPartFile , Authentication auth) throws IOException {
			return uploadService.medicalRx1(multiPartFile);
		}
	 
	    @RequestMapping(value = "/medical-rx2", method = RequestMethod.POST)
		public List<MedicalRx2> medicalRx2(@RequestPart(value = "file") MultipartFile multiPartFile , Authentication auth) throws IOException {
			return uploadService.medicalRx2(multiPartFile);
		}
	    
	    @RequestMapping(value = "/rxonly1", method = RequestMethod.POST)
		public List<RxOnly1> rxonly1(@RequestPart(value = "file") MultipartFile multiPartFile , Authentication auth) throws IOException {
			return uploadService.rxonly1(multiPartFile);
		}
	    
	    @RequestMapping(value = "/rxonly2", method = RequestMethod.POST)
		public List<RxOnly2> rxonly2(@RequestPart(value = "file") MultipartFile multiPartFile , Authentication auth) throws IOException {
			return uploadService.rxonly2(multiPartFile);
		}
	    
	    @RequestMapping(value = "/dental_1", method = RequestMethod.POST)
		public List<Dental_1> dental1(@RequestPart(value = "file") MultipartFile multiPartFile , Authentication auth) throws IOException {
			return uploadService.dental1(multiPartFile);
		}
		
		@RequestMapping(value = "/dental_2", method = RequestMethod.POST)
			public List<Dental_2> dental2(@RequestPart(value = "file") MultipartFile multiPartFile , Authentication auth) throws IOException {
				return uploadService.dental2(multiPartFile);
			}
			
		@RequestMapping(value="/individual-stop-loss" , method=RequestMethod.POST)
			public List<IndividualStopLoss> individualStopLoss(@RequestPart(value="file") MultipartFile multipartFile) throws IOException{
				return uploadService.individualStopLoss(multipartFile);
		}
		
		@RequestMapping(value="/vision" , method=RequestMethod.POST)
		public List<Vision> vision(@RequestPart(value="file") MultipartFile multipartFile) throws IOException{
			return uploadService.vision(multipartFile);
		}
		
		@RequestMapping(value="/clinic" , method=RequestMethod.POST)
		public List<Clinic> clinic(@RequestPart(value="file") MultipartFile multipartFile) throws IOException{
			return uploadService.clinic(multipartFile);
		}
		
		@GetMapping("/medicalrx1-data")
		public List<MedicalRx1Info> getData( Authentication auth){
			return uploadService.getAllData();
		}
		
	    @GetMapping("/medicalrx2-data")
		public APIResponse<List<MedicalRx2>> getMedicalRx2Data( Authentication auth){
			return uploadService.getMedicalRx2Data();
		}
		
	    @GetMapping("/rxonly1-data")
		public APIResponse<List<RxOnly1>> getRxOnly1Data(Authentication auth){
			return uploadService.getRxOnly1Data();
		}
		
	    @GetMapping("/rxonly2-data")
		public APIResponse<List<RxOnly2>> getRxOnly2Data(Authentication auth){
			return uploadService.getRxOnly2Data();
		}
		
	    @GetMapping("/dental1-data")
		public APIResponse<List<Dental_1>> getDental1Data(){
			return uploadService.getDental1Data();
		}
		
	    @GetMapping("/dental2-data")
		public APIResponse<List<Dental_2>> getDental2Data(){
			return uploadService.getDental2Data();
		}
		
	    @GetMapping("/individual-stop-loss-data")
		public APIResponse<List<IndividualStopLoss>> getIndividualStopLossData(){
			return uploadService.getIndividualStopLossData();
		}
	 
	    @GetMapping("/vision-data")
		public APIResponse<List<Vision>> getVisionData(){
			return uploadService.getVisionData();
		}
	    
	   @GetMapping("/clinic-data")
		public APIResponse<List<Clinic>> getClinicData(){
			return uploadService.getClinicData();
		}
}
