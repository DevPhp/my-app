import { Component, OnInit, ViewChild, QueryList, ViewChildren } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router} from '@angular/router';
import { StopLossService } from "../../services/stoploss.Service";

@Component({
  selector: 'app-stop-loss',
  templateUrl: './stop-loss.component.html',
  styleUrls: ['./stop-loss.component.css']
})
export class StopLossComponent implements OnInit {
	stoplossData: any = {};
  	result: any = {};
  	constructor(private router: Router,private stoplossService: StopLossService) { }

  	ngOnInit() {
  		this.getStopLoss();
  	}

  	getStopLoss(){
  		this.stoplossService.getstoploss().subscribe(
   			resp =>
	     		{  
		          	this.result = resp;
		          	this.stoplossData = this.result.response;
		          	console.log(this.stoplossData); 
	     		},            
	      		error => {
	       			console.log('Error');
	     		}
	    );
  	}


}
