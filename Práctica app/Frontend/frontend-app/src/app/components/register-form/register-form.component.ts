import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRegister } from 'src/app/models/user-register.model';
import { AuthService } from 'src/app/services/auth.service';
import { CheckerService } from 'src/app/services/checker.service';
import { ValidatorService } from 'src/app/services/validator.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  form:FormGroup;
  userRegister:UserRegister;
  registerError:boolean

  constructor(private fb:FormBuilder, 
              private vs:ValidatorService,
              private as:AuthService,
              private router:Router,
              private ch:CheckerService) { 
    this.initForm();
  }

  ngOnInit(): void {
    this.registerError = false;
  }

  private initForm(){
    this.form = this.fb.group({
      name:['', [Validators.required]],
      familyName:['', [Validators.required]],
      email:['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')], [this.vs.validateEmail(this.ch)]],
      username:['', [Validators.required], [this.vs.validateUsername(this.ch)]],
      password:['', [Validators.required, Validators.minLength(8), Validators.maxLength(20)]],
      password2:['', [Validators.required]]
    },
    {
      validators: this.vs.validPasswords('password', 'password2')
    });
  }

  register(){
    this.userRegister = {
      name: this.form.controls.name.value,
      familyName: this.form.controls.familyName.value,
      email: this.form.controls.email.value,
      username: this.form.controls.username.value,
      password: this.form.controls.password.value
    }
    this.as.register(this.userRegister).subscribe(
      res => this.router.navigate(['/login']),
      error => this.registerError = true
    )
  }

  get nameInvalid() {
    return this.form.get('name').invalid && this.form.get('name').touched;
  }

  get familyNameInvalid() {
    return this.form.get('familyName').invalid && this.form.get('familyName').touched;
  }

  get emailEmpty() {
    return !this.form.get('email').value && this.form.get('email').touched;
  }

  get emailFormatInvalid() {        
    if(this.form.get('email').value && this.form.get('email').touched){
      const email = this.form.get('email').value;
      const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      
      return !re.test(String(email).toLowerCase());
    }        
  }

  get  emailNotAvilable(){
    return this.form.get('email').hasError('isNotAvilable') 
          && this.form.get('email').touched;
  }
   get emailValid(){
    return this.form.get('email').valid && this.form.get('email').touched;
   }

  get usernameEmpty() {
    return !this.form.get('username').value && this.form.get('username').touched;
  }

  get usernameInvalid() {
    return this.form.get('username').invalid && this.form.get('username').touched;
  }

  get usernameValid() {
    return this.form.get('username').valid && this.form.get('username').touched;
  }

  get passwordEmpty() {
    return !this.form.get('password').value && this.form.get('password').touched;
  }

  get passwordLengthInvalid() {
    return this.form.get('password').invalid && this.form.get('password').touched;
  }

  get password2Empty() {
    return !this.form.get('password2').value && this.form.get('password2').touched;
  }

  get passwordsNotEqual() {
    const p1 = this.form.get('password').value;
    const p2 = this.form.get('password2').value;
    
    return (p1 !== p2) && this.form.get('password2').touched ? true : false;
  }

  get formInvalid() {
    return this.form.invalid;
  }

}
