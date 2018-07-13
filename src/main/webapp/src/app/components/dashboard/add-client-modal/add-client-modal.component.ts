import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DashboardService } from "../../../services/dashboard.Service";

@Component({
  selector: 'app-add-client-modal',
  templateUrl: './add-client-modal.component.html',
  styleUrls: ['./add-client-modal.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class AddClientModalComponent implements OnInit {
  clientForm: FormGroup;
  isSubmitted:boolean=false;

  constructor(public activeModal: NgbActiveModal,
    private modalService: NgbModal, private fb: FormBuilder,private dashboardService: DashboardService ) { }

  ngOnInit() {

    this.clientForm = this.fb.group({
      clientName: ["", [Validators.required, Validators.minLength(2), Validators.maxLength(35)]],
      accountNo: ["", [Validators.required]],
      employees: ["", [Validators.required]],
      members: ["", [Validators.required]],
      renewalDate: ["", [Validators.required]],
      agency: ["", [Validators.required]],
      clientManager: ["", [Validators.required]],
      clientID:123456
    });
  }

  numberOnly(event): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;

  }


  addClient()
  {
    if(this.clientForm.status=="VALID")
    {
      this.dashboardService.addClients(this.clientForm.value).subscribe(res=>{
        console.log(res); this.activeModal.close(true);
      },error=>{console.log(error);});
        
    }
    else
    {
      this.isSubmitted = true;
      console.log(this.clientForm.value);
    }
    
  }

  close() {
    this.activeModal.close(false);
  }

}
