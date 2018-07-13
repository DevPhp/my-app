import { Component, OnInit, ViewChild, QueryList, ViewChildren } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router} from '@angular/router';
import { UserManagementService } from "../../services/userManagement.Service";
import { AddUserModalComponent } from "./add-user-modal/add-user-modal.component";
import { NgbModal,NgbModalOptions } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
	usersData: any = {};
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
	constructor(private router: Router, private usermanagementService: UserManagementService, private modalService: NgbModal) { }

  	ngOnInit() {
  		this.getUsers();            
  	}

  	getUsers(){
  		this.usermanagementService.getusers().subscribe(
   			resp => {            
		     	this.result = resp;
		     	this.usersData = this.result.response;
	     	},            
	      	error => {
	       		console.log('Error');
	     	}
	    );
	  }
	  
	adduser() {
		const options : NgbModalOptions = {
			windowClass: 'success-modal',
		};
		this.modalService.open(AddUserModalComponent, options)
		.result.then((result)=>{
			if(result) {
				this.getUsers();
			}
		},(reason)=>{
			console.log(reason)
		});
	}
}
