import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClientDetailsComponent} from "./components/client-details/client-details.component";
import {CreatePatientComponent} from "./components/create-patient/create-patient.component";

const routes: Routes = [
  {path: 'client-details', component: ClientDetailsComponent},
  {path: `create-patient`, component: CreatePatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
