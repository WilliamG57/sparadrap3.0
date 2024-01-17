import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor() {
  }

  showMenu = true;

  toggleMenu(): void {
    this.showMenu = !this.showMenu;
  }
}
