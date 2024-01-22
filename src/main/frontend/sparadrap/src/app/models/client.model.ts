export class Client {
  nom: string;
  prenom: string;
  telephone: string;
  email: string;
  adresse: string;
  codePostal: string;
  ville: string;
  secuSociale: string;
  dateNaissance: string;
  medecinId: number;
  specialisteId: number;
  mutuelleId: number;


  constructor() {
    this.nom = '';
    this.prenom = '';
    this.telephone = '';
    this.email = '';
    this.adresse = '';
    this.codePostal = '';
    this.ville = '';
    this.secuSociale = '';
    this.dateNaissance = '';
    this.medecinId = 0;
    this.specialisteId = 0;
    this.mutuelleId = 0;
  }
}
