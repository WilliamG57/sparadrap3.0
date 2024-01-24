import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClientDetailsComponent} from "./components/client-details/client-details.component";
import {CreateClientComponent} from "./components/create-client/create-client.component";
import {MeteoComponent} from "./components/meteo/meteo.component";
import {DetailsMedicamentsComponent} from "./components/details-medicaments/details-medicaments.component";
import {CreateMedicamentComponent} from "./components/create-medicament/create-medicament.component";

const routes: Routes = [
  {path: 'client-details', component: ClientDetailsComponent},
  {path: 'create-patient', component: CreateClientComponent},
  {path: 'details-medicaments', component: DetailsMedicamentsComponent},
  {path: 'create-medicament', component: CreateMedicamentComponent},
  {path: 'meteo', component: MeteoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
