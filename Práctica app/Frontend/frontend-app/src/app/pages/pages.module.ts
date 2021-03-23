import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponentsModule } from '../components/components.module';
import { RegisterPageComponent } from './register-page/register-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NotFoundPageComponent } from './not-found-page/not-found-page.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    RegisterPageComponent, 
    LoginPageComponent, 
    HomePageComponent, 
    NotFoundPageComponent
  ],
  imports: [
    CommonModule,
    ComponentsModule,
    RouterModule
  ]
})
export class PagesModule { }
