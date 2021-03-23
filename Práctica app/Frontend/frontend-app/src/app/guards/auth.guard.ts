import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router:Router,              
              private as:AuthService){}

  canActivate(
    route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
      const token = this.as.getToken();
      if(token){                
        return true;
      }
      this.router.navigate(['/login']);
      return false;
  }
  
}
