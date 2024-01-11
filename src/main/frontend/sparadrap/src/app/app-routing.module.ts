import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { ClientDetailsComponent } from "./components/client-details/client-details.component";

const routes: Routes = [
  {path: 'client-details', component: ClientDetailsComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
