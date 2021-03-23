import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthGuard } from './auth.guard';



@NgModule({
  declarations: [
    AuthGuard
  ],
  exports: [
    AuthGuard
  ],
  imports: [
    CommonModule
  ]
})
export class GuardsModule { }
