import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotFoundComponent } from './not-found/not-found.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { FeesAndRatesComponent } from './components/fees-and-rates/fees-and-rates.component';
import { HistoricalClaimsComponent } from './components/historical-claims/historical-claims.component';
import { StopLossComponent } from './components/stop-loss/stop-loss.component';
import { UserManagementComponent } from './components/user-management/user-management.component';
import { ClientDashboardComponent } from './components/client-dashboard/client-dashboard.component';

export const routes: Routes = [
  	{ path: '', component: DashboardComponent },
  	{ path: 'user-management', component: UserManagementComponent },
  	{ path: 'dashboard', component: DashboardComponent },
  	{ path: 'fees-rates', component: FeesAndRatesComponent },
  	{ path: 'stop-loss', component: StopLossComponent },
  	{ path: 'historical-claims', component: HistoricalClaimsComponent },
    { path: 'client-dashboard/:id', component: ClientDashboardComponent },
  	{ path: 'notfound', component: NotFoundComponent },
  	{ path: '**', redirectTo: '/notfound' },
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

