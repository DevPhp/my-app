import { Component, OnInit, ViewChild, QueryList, ViewChildren } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router} from '@angular/router';
import { ClientDashboardService } from "../../services/clientDashboard.Service";

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css']
})
export class ClientDashboardComponent implements OnInit {

  clientData: any = {};
  result: any = {};
  id: number;
  private cId: any;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private clientdashboardService: ClientDashboardService) { }

  ngOnInit() {
  	this.cId = this.route.params.subscribe(params => {
       this.id = +params['id'];
    });
  	this.clientDetail();
  }

  clientDetail(){
  	this.clientdashboardService.getclientData(this.id).subscribe(
	   	resp =>
		  	{  
				//console.log(resp);     
	      		this.result = resp;
	      		this.clientData = this.result.response;
			},            
		error => 
			{
	      		console.log('Error');
	   		}
	    );  	
  }

}
