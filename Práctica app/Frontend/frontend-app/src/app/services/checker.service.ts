import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AbstractControl, FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CheckerService {

  url = `${environment.base_url}/validation`;

  constructor(private http:HttpClient) { }

  validUsername(username:AbstractControl): Observable<any> {
    const user = `username/${username.value}`;    
    return this.http.get(`${this.url}/${user}`);
  }

  validEmail(email:AbstractControl): Observable<boolean>{
    const emailV = `email/${email.value}`;
    return this.http.get<boolean>(`${this.url}/${emailV}`);
  }
}
