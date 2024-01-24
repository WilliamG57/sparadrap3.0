import {Component} from '@angular/core';
import {HeaderComponent} from "../header/header.component";
import {RouterLink} from "@angular/router";
import {NgIf} from "@angular/common";
import {MenuService} from "../../services/menu-service/menu.service";

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [
    HeaderComponent,
    RouterLink,
    NgIf
  ],
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(public menuService: MenuService) {
  }

  showSubMenuGestionPatients = false;
  showSubMenuMedicaments: boolean = false;

  toggleSubMenuGestionPatients(): void {
    this.showSubMenuGestionPatients = !this.showSubMenuGestionPatients;
    this.showSubMenuMedicaments = false;
  }

  toggleSubMenuMedicament(): void {
    this.showSubMenuMedicaments = !this.showSubMenuMedicaments;
    this.showSubMenuGestionPatients = false;
  }
}
