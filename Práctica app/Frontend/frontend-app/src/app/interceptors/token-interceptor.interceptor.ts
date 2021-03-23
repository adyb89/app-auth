import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AuthService } from '../services/auth.service';
import { catchError, concatMap } from 'rxjs/operators';
import { JwtToken } from '../models/jwt-token.model';

const AUTHORIZATION =  'Authorization';
const BEARER = 'Bearer ';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private as:AuthService) {}

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    if(!this.as.isAuth){
      return next.handle(req);  
    }

    let request = req;
    const token = this.as.getToken();
    let headers = `${BEARER}${token}`;      
    request = this.cloneRquest(req, headers);
    
    return next.handle(request).pipe(catchError((error:HttpErrorResponse) => {
      if(error.status === 401){
        const jwt:JwtToken = {token: this.as.getToken()};
        this.as.refreshToken(jwt).pipe(concatMap((token:string) => {
          this.as.setToken(token);
          headers = `${BEARER}${token}`;
          request = this.cloneRquest(req, headers);
          return next.handle(request);
        }));
      }else{
        this.as.logout();
        return throwError(error);
      }
    }));
  }

  private cloneRquest(req: HttpRequest<unknown>, token:string):HttpRequest<unknown>{
    return req.clone({headers: req.headers.set(AUTHORIZATION, token)});
  }
}
