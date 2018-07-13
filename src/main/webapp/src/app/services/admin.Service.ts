import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import { environment } from '../../environments/environment';

@Injectable()
export class AdminService {
    constructor(private http: HttpClient) { }

    // Get all
	  getAll(url: any) {
	    return this.http.get(url);
	  }

	  // Count all
	  count(url: any) {
	    return this.http.get(url);
	  }

	  // add
	  add(url: any, entity: any) {
	    return this.http.post(url, entity);
	  }

	  // Get by id
	  getById(url: any, entity: any) {
	    return this.http.get(url + `/${entity._id}`);
	  }

	  // Update by id
	  editById(url: any, entity: any) {
	    return this.http.put(url + `/${entity._id}`, entity);
	  }

	  // Delete by id
	  deleteById(url: any, entity: any) {
	    return this.http.delete(url + `/${entity._id}`);
	  }

 }


