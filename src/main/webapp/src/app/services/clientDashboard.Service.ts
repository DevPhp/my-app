import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import { environment } from '../../environments/environment';

@Injectable()
export class ClientDashboardService {
    constructor(private http: HttpClient) { }

    getclientData(clientID) {     
      return this.http.get(environment.apiURL+'/get-client/'+clientID);
    }

 }


