import {Component, OnInit, signal} from '@angular/core';
import {ClientService} from '../../services/client-service/client.service';
import {FormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {error} from "@angular/compiler-cli/src/transformers/util";


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
  selectedClient: { nom?: string; prenom?: string; adresse?: string } = {};

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
      this.selectedClient = client;
    } else {
      this.selectedClient = {nom: '', prenom: '', adresse: ''}
    }
  }

  //Modification d'un client
  modifyClient(): void {
    this.isEditable = true;
  }

  //Sauvegarde des modification
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

  //Suppression d'un client
  deleteClient(): void {

  }

  //Condition pour les champs éditable ou non
  toggleEdit(): void {
    this.isEditable = !this.isEditable;
  }
}
