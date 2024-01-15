import {Component, OnInit, signal} from '@angular/core';
import {ClientService} from '../../services/client.service';
import {FormsModule} from "@angular/forms";
import {NgForOf} from "@angular/common";


@Component({
  selector: 'app-client-details',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf
  ],
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css']
})
export class ClientDetailsComponent implements OnInit {

  clients: any[] = [];
  selectedClientId: number | undefined;
  selectedClient = {nom: '', prenom: '', adresse: ''};

  constructor(private clientService: ClientService) {
  }

  ngOnInit(): void {
    this.clientService.getClients().subscribe((data: any[]) => {
      this.clients = data;
    });
  }

  onClientSelect(): void {
    console.log("Selected Client ID:", this.selectedClientId);
    const client = this.clients.find(c => c.id === this.selectedClientId);
    if (client) {
      this.selectedClient = client;
    } else {
      this.selectedClient = {nom: '', prenom: '', adresse: ''};
    }
  }
}
