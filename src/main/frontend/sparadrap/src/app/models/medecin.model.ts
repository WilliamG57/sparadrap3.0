export class Medecin{
  per_id?: number;
  nom: string;
  prenom: string;
  telephone: string;
  email: string;
  adresse: string;
  codePostal: string;
  ville: string;
  numAgreement: number;

  constructor() {
    this.nom = '';
    this.prenom = '';
    this.telephone = '';
    this.email = '';
    this.adresse = '';
    this.codePostal = '';
    this.ville = '';
    this.numAgreement = 0;
  }
}
