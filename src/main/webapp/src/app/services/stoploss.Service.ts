import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import { environment } from '../../environments/environment';

@Injectable()
export class StopLossService {
    constructor(private http: HttpClient) { }

    getstoploss() {     
      return this.http.get(environment.apiURL+'/individual-stop-loss-data');
    }

 }


