export class Medicament {
  id: number;
  nom: string;
  prix: number;
  stock: number;
  isEditable?: boolean;

  constructor() {
    this.id = 0;
    this.nom = '';
    this.prix = 0;
    this.stock = 0
  }
}
