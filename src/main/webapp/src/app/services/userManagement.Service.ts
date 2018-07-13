import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import { environment } from '../../environments/environment';

@Injectable()
export class UserManagementService {
    constructor(private http: HttpClient) { }

    getusers() {     
      return this.http.get(environment.apiURL+'/users');
    }

  addUser(data) {
    return this.http.post(environment.apiURL + '/add-user', data);
  }

 }


