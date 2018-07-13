import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import { environment } from '../../environments/environment';

@Injectable()
export class DashboardService {
    constructor(private http: HttpClient) { }

    getclients() {     
      return this.http.get(environment.apiURL+'/clients');
    }

  addClients(data) {
    return this.http.post(environment.apiURL + '/add-client',data);
  }

 }


