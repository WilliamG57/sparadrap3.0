import {Component, OnInit, signal} from '@angular/core';
import {ClientService} from '../../services/client.service';
import {FormsModule} from "@angular/forms";


@Component({
  selector: 'app-client-details',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './client-details.component.html',
  styleUrl: './client-details.component.css'
})
export class ClientDetailsComponent implements OnInit {

  clients: any[] = [];
  selectedClient: any;

  constructor(private clientService: ClientService) {
  }

  ngOnInit(): void {
    this.clientService.getClients().subscribe(data => {
      this.clients = data;
    });
  }

  onClientSelect(): void {
    console.log(this.selectedClient);
  }
}
