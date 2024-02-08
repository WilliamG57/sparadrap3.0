import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from "./components/header/header.component";
import {MenuComponent} from "./components/menu/menu.component";
import {FooterComponent} from "./components/footer/footer.component";
import { CreateClientComponent } from './components/create-client/create-client.component';
import { MeteoComponent } from './components/meteo/meteo.component';
import {FormsModule} from "@angular/forms";
import { DetailsMedicamentsComponent } from './components/details-medicaments/details-medicaments.component';
import { CreateMedicamentComponent } from './components/create-medicament/create-medicament.component';
import { AchatMedicamentComponent } from './components/achat-medicament/achat-medicament.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateClientComponent,
    MeteoComponent,
    DetailsMedicamentsComponent,
    CreateMedicamentComponent,
    AchatMedicamentComponent,
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        HeaderComponent,
        MenuComponent,
        FooterComponent,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

