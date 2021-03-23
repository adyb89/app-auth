
import { Injectable } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { CheckerService } from './checker.service';

@Injectable({
  providedIn: 'root'
})
export class ValidatorService {
  
  deb: any;

  constructor() { }

  validateUsername(ch:CheckerService): any{
    return (control:FormControl) => {
      return ch.validUsername(control).pipe(
        map(res => {
          return res ? null : {isNotAvilable: true};
        }),
        catchError(error => {
          control.setErrors({isNotAvilable: true});
          return of({isNotAvilable: true});
        })
      );
    };      
  }

  validateEmail(ch:CheckerService):any{
    return (control:FormControl) => {
      return ch.validEmail(control).pipe(
        map(res => {
          return res ? null : {isNotAvilable: true};
        }),
        catchError(error => {
          control.setErrors({isNotAvilable: true});
          return of({isNotAvilable: true});
        })
      );
    };
    
  }

  validPasswords(p1:string, p2:string){

    return (form:FormGroup) => {
      
      if(form.controls[p1].value === form.controls[p2].value){
        form.controls[p2].setErrors(null);
      }else{
        form.controls[p2].setErrors({invalid: true});
      }
    }
  }

  
}
