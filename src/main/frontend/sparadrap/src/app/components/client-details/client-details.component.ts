import {Component, OnInit} from '@angular/core';
import {ClientService} from '../../services/client-service/client.service';
import {FormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-client-details',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css']
})
export class ClientDetailsComponent implements OnInit {

  isEditable = false;
  clients: any[] = [];
  selectedClientId: number | undefined;
  selectedClient: {
    per_id?: number;
    nom?: string;
    prenom?: string;
    adresse?: string;
    codePostal?: string;
    ville?: string;
    email?: string
    secuSociale?: string
    dateNaissance?: string
    telephone?: string;
    medecinId?: number;
    specialisteId?: number;
    mutuelleId?: number;
    medecinNom?: string
  } = {};

  constructor(private clientService: ClientService) {
  }

  //Recherche et affichage du client
  ngOnInit(): void {
    this.clientService.getClients().subscribe((data: any[]) => {
      this.clients = data;
    });
  }

  onClientSelect(): void {
    const client = this.clients.find(c => c.per_id == this.selectedClientId);
    console.log(client);
    if (client) {
      this.selectedClient = {
        per_id: client.per_id,
        nom: client.nom,
        prenom: client.prenom,
        adresse: client.adresse,
        codePostal: client.codePostal,
        ville: client.ville,
        telephone: client.telephone,
        email: client.email,
        secuSociale: client.secuSociale,
        dateNaissance: client.dateNaissance,
        medecinId: client.medecin ? client.medecin.per_id : undefined,
        specialisteId: client.specialiste ? client.specialiste.per_id : undefined,
        mutuelleId: client.mutuelle ? client.mutuelle.mut_id : undefined,
        medecinNom: client.medecin ? client.medecin.nom : undefined,
      };
    } else {
      this.selectedClient = {};
    }
  }

//Possibilité de modifier un client
  modifyClient(): void {
    this.isEditable = true;
  }

//Sauvegarde des modifications
  saveClient(): void {
    if (this.selectedClient && this.selectedClient.per_id) {
      this.clientService.updateClient(this.selectedClient).subscribe({
        next: (response) => {
          console.log("Client mis à jour", response);
          this.isEditable = false;
          this.loadClients(); // Rechargez les clients pour voir la mise à jour
        },
        error: (error) => {
          console.error("Erreur lors de la mise à jour", error);
        }
      });
    } else {
      console.error("ID du client manquant ou données du client incomplètes");
    }
  }

  loadClients(): void {
    this.clientService.getClients().subscribe({
      next: (data) => this.clients = data,
      error: (error) => console.error('Erreur lors du chargement des clients', error)
    });
  }

//Suppression d'un client
  deleteClient(clientId: number | undefined): void {
    const confirmation = window.confirm("Êtes-vous sûr de vouloir supprimer le client? ")
    if (confirmation) {
      this.clientService.deleteClient(clientId).subscribe({
        next: () => {
          console.log("Client supprimé avec succès");
          this.loadClients();
        },
        error: (error) => console.error("Echec de la suppression du client", error)
      })
    }
  }

//Condition pour les champs éditable ou non
  toggleEdit(): void {
    this.isEditable = !this.isEditable;
  }
}
