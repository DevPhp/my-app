import { Component, OnInit, ViewChild, QueryList, ViewChildren } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router} from '@angular/router';
import { AdminService } from "../../services/admin.Service";
import { DashboardService } from "../../services/dashboard.Service";
import { AddClientModalComponent } from "./add-client-modal/add-client-modal.component";
import { NgbModal,NgbModalOptions } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  today = Date.now();
  clientData: any = {};
  result: any = {};
  //sorting
  key: string = 'name'; //set default
  reverse: boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
  }
  //initializing p to one
  p: number = 1;
	constructor(
    private router: Router, 
    private dashboardService: DashboardService, 
    private modalService: NgbModal) { }

  	ngOnInit() {
  		this.getClients();            
  	}

  	getClients(){
  		this.dashboardService.getclients().subscribe(
   			resp =>
	     		{  
						//console.log(resp);     
          	this.result = resp;
          	this.clientData = this.result.response;
	     		},            
	      		error => {
	       			console.log('Error');
	     		}
	    );
	  }



	add_client() {
    const options : NgbModalOptions = {
        windowClass: 'success-modal',
    };
		this.modalService.open(AddClientModalComponent, options)
    .result.then((result)=>{
      if(result) {
        this.getClients();
      }
    },(reason)=>{
      console.log(reason)
    });
	}
}
