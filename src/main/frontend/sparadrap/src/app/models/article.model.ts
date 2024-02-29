import {Medicament} from "./medicament.model";

export class Article {
  art_id?: number;
  medicamentId: number;
  quantite: number;

  constructor() {
    this.art_id = undefined;
    this.medicamentId = 0;
    this.quantite = 0;
  }
}
