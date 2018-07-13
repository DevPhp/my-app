import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  activeColor(e){
   $('#activeLeadsli').addClass('active');
   $('#activeAdminli').removeClass('active');
  }
  activeAdminColor(e){
    $('#activeAdminli').addClass('active');
    $('#activeLeadsli').removeClass('active');
  }
}
