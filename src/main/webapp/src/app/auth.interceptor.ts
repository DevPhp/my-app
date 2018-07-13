import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(){}
  intercept (req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const newReq = req.clone(
      {
        withCredentials: true
      }
    );
    return next.handle(newReq);
  }
}
