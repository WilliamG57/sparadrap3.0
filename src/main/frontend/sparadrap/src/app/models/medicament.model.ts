export class Medicament {
  medi_id: number;
  nom: string;
  prix: number;
  stock: number;
  categorieId : number;
  isEditable?: boolean;

  constructor() {
    this.medi_id = 0;
    this.nom = '';
    this.prix = 0;
    this.stock = 0
    this.categorieId= 0;
  }
}
