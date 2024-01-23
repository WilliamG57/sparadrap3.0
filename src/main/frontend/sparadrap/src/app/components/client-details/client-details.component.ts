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
    nom?: string;
    prenom?: string;
    adresse?: string;
    telephone?: string;
    medecinNom?: string
  } = {};

  constructor(private clientService: ClientService) {
  }

  //Recherche et affichage du client
  ngOnInit(): void {
    this.clientService.getClients().subscribe((data: any[]) => {
      this.clients = data;
      console.log(data)
    });
  }

  onClientSelect(): void {
    const client = this.clients.find(c => c.per_id == this.selectedClientId);
    if (client) {
      this.selectedClient = {
        nom: client.nom,
        prenom: client.prenom,
        adresse: client.adresse,
        telephone: client.telephone,
        medecinNom: client.medecin.nom
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
    this.clientService.updateClient(this.selectedClient).subscribe({
      next: (response) => {
        console.log("Client mis à jours");
        this.isEditable = false;
      },
      error: (error) => {
        console.error("Erreur lors de la mise à jours")
      }
    })
  }

  loadClients()
    :
    void {
    this.clientService.getClients().subscribe({
      next: (data) => this.clients = data,
      error: (error) => console.error('Erreur lors du chargement des clients', error)
    });
  }

//Suppression d'un client
  deleteClient(clientId
                 :
                 number | undefined
  ):
    void {
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
  toggleEdit()
    :
    void {
    this.isEditable = !this.isEditable;
  }
}
