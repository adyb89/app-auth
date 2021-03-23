import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { JwtToken } from '../models/jwt-token.model';

const TOKEN = 'token';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  url = environment.base_url;

  constructor(private http: HttpClient) { }

  getToken():string {
    return localStorage.getItem(TOKEN);
  }

  setToken(token:string):void {
    localStorage.setItem(TOKEN, token)
  }

  deleteToken(){
    localStorage.removeItem(TOKEN);
  }

  refreshToken(jwt:JwtToken):Observable<string>{
    const uri = `${this.url}/refresh`;
    return this.http.post<JwtToken>(uri, jwt).pipe(
      map((jwt:JwtToken) => jwt.token)
    );
  }
}
