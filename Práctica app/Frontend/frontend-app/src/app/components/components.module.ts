import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import  { ReactiveFormsModule, FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

@NgModule({
  declarations: [
    LoginFormComponent, 
    RegisterFormComponent,
    NavBarComponent
  ],
  exports: [
    LoginFormComponent, 
    RegisterFormComponent,
    NavBarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ]
})
export class ComponentsModule { }
