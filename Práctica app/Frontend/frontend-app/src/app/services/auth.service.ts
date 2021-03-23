import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { JwtToken } from '../models/jwt-token.model';
import { UserLogin } from '../models/user-login.model';
import { UserRegister } from '../models/user-register.model';
import { TokenService } from './token.service';

const LOGIN = '/login';
const REGISTER = '/register';
const REFRESH = '/refresh';
const HOME = '/home';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

   url = environment.base_url;
   private _isAuth:boolean;

  constructor(private http: HttpClient,
              private ts: TokenService,
              private router: Router) { }

  login(user:UserLogin):Observable<string>{
    const uri = `${this.url}${LOGIN}`;
    return this.http.post<JwtToken>(uri, user)
            .pipe(map((jwt:JwtToken) => jwt.token));
  }

  register(user:UserRegister):Observable<void>{
    const uri = `${this.url}${REGISTER}`;
    return this.http.post<void>(uri, user)
  }

  logout():void{
    this.deleteToken();
    this._isAuth = false;
    this.navigate(LOGIN);
  }

  setIsAuth(auth:boolean, token?:string){
    this._isAuth = auth;
    if(!this._isAuth){
      this.deleteToken();
      this.navigate(LOGIN);
    }else{
      if(token){
        this.setToken(token);
        this.navigate(HOME);
      }
    }
  }

  refreshToken(jwt:JwtToken):Observable<string>{
    return this.refreshToken(jwt);
  }

  getToken():string{
    return this.ts.getToken();
  }

  setToken(token:string){
    this.ts.setToken(token);
  }

  deleteToken():void{
    this.ts.deleteToken();
  }

  get isAuth(){
    return this._isAuth;
  }

  private navigate(path:string):void{
    this.router.navigate([path]);
  }
}
