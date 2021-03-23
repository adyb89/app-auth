import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AuthGuard } from './guards/auth.guard';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { NotFoundPageComponent } from './pages/not-found-page/not-found-page.component';

const routes: Routes = [
  {path:'home', component:HomePageComponent, canActivate:[AuthGuard]},
  {path:'', component:HomePageComponent, canActivate:[AuthGuard]},
  {path:'register', component:RegisterPageComponent},
  {path:'login', component:LoginPageComponent},
  {path:'**', component:NotFoundPageComponent, pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
