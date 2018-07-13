import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserManagementService } from "../../../services/userManagement.Service";

@Component({
  selector: 'app-add-user-modal',
  templateUrl: './add-user-modal.component.html',
  styleUrls: ['./add-user-modal.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class AddUserModalComponent implements OnInit {
  userForm: FormGroup;
  isSubmitted: boolean = false;

  constructor(public activeModal: NgbActiveModal,
    private modalService: NgbModal, private fb: FormBuilder, private usermanagementService: UserManagementService) { }

  ngOnInit() {

    this.userForm = this.fb.group({
      userName: ["", [Validators.required, Validators.minLength(2), Validators.maxLength(35)]],
      permissionStatus: ["", [Validators.required]],
      clientAssigned: 123456,
      agency: ["", [Validators.required]],
      accountStatus: ["", [Validators.required]],
      //  myDate: [null, Validators.required]
    });
  }



  addUser() {
    if (this.userForm.status == "VALID") {
      this.usermanagementService.addUser(this.userForm.value).subscribe(res => {
        console.log(res); this.activeModal.close(true);
      }, error => { console.log(error); });

    }
    else {
      this.isSubmitted = true;
      console.log(this.userForm.value);
    }

  }

  close() {
    this.activeModal.close(false);
  }


}
