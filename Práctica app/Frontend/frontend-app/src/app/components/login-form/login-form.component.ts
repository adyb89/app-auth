import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserLogin } from 'src/app/models/user-login.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  form: FormGroup;
  userLogin: UserLogin;
  loginError: boolean;

  constructor(private fb: FormBuilder,
    private as: AuthService,
    private router: Router) {
    this.initForm();
  }

  ngOnInit(): void {
    if (this.as.isAuth) {
      this.router.navigate(['/home']);
    }

    this.loginError = false;
  }

  private initForm() {
    this.form = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]
    })
  }

  login() {
    this.userLogin = {
      username: this.form.controls.username.value,
      password: this.form.controls.password.value
    }
    this.as.login(this.userLogin).subscribe((token: string) => {
      if (token) {
        this.as.setIsAuth(true, token);
      }
    },
      error => this.loginError = true
    );
  }

  get usernameInvalid() {
    return this.form.get('username').invalid && this.form.get('username').touched;
  }

  get passwordInvalid() {
    return this.form.get('password').invalid && this.form.get('password').touched;
  }

  get formInvalid() {
    return this.form.invalid;
  }
}
