import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { filterAgent } from './filter.pipe';
import { filterState } from './filter.pipe';
import { filterCounty } from './filter.pipe';
import { filterZipCode } from './filter.pipe';
import { filterInvoice } from './filter.pipe';
import { filterProductCode } from './filter.pipe';
import { filterUndispositionedLeads } from './filter.pipe';
import { filterUserName } from './filter.pipe';
import { filterNpn } from './filter.pipe';
import { filterReceivedDateRange } from './filter.pipe';
import { AuthInterceptor } from "./auth.interceptor";
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { NgxPaginationModule } from 'ngx-pagination';
import { HeaderComponent } from './header/header.component';
import { DataTablesModule } from "angular-datatables";
import { NgDatepickerModule } from 'ng2-datepicker';
import { MyDatePickerModule } from 'mydatepicker';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';


import { AdminService } from "./services/admin.Service";
import { DashboardService } from "./services/dashboard.Service";
import { StopLossService } from "./services/stoploss.Service";
import { UserManagementService } from "./services/userManagement.Service";
import { ClientDashboardService } from "./services/clientDashboard.Service";

import { NotFoundComponent } from './not-found/not-found.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { FeesAndRatesComponent } from './components/fees-and-rates/fees-and-rates.component';
import { HistoricalClaimsComponent } from './components/historical-claims/historical-claims.component';
import { StopLossComponent } from './components/stop-loss/stop-loss.component';
import { UserManagementComponent } from './components/user-management/user-management.component';
import { AddClientModalComponent } from "./components/dashboard/add-client-modal/add-client-modal.component";
import { AddUserModalComponent } from './components/user-management/add-user-modal/add-user-modal.component';
import { ClientDashboardComponent } from './components/client-dashboard/client-dashboard.component';
import { ClientHeaderComponent } from './components/client-header/client-header.component';



@NgModule({
  declarations: [
    AppComponent,
    filterAgent,
    filterState,
    filterCounty,
    filterZipCode,
    filterInvoice,
    filterProductCode,
    filterUndispositionedLeads,
    filterUserName,
    filterNpn,
    filterReceivedDateRange,   
    HeaderComponent,
    DashboardComponent,
    FeesAndRatesComponent,
    HistoricalClaimsComponent,
    StopLossComponent,
    UserManagementComponent,
    NotFoundComponent,
    AddClientModalComponent,
    AddUserModalComponent,
    ClientDashboardComponent,
    ClientHeaderComponent,
  ],
  entryComponents: [
    AddClientModalComponent,
    AddUserModalComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataTablesModule,    
    Ng2SearchPipeModule,
    Ng2OrderModule,
    NgxPaginationModule,
    NgDatepickerModule,
    MyDatePickerModule,
    Ng4LoadingSpinnerModule.forRoot()
  ],
  providers: [
    AdminService,
    {
      provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true
    },
    DashboardService,
    ClientDashboardService,
    StopLossService,
    UserManagementService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
