import {Component, OnInit} from '@angular/core';
import {MedecinService} from "../../services/medecin-service/medecin.service";
import {SpecialisteService} from "../../services/specialiste-service/specialiste.service";
import {MutuelleService} from "../../services/mutuelle-service/mutuelle.service";
import {ClientService} from "../../services/client-service/client.service";
import {Client} from "../../models/client.model";

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {
  client: Client = new Client();
  specialistes: any[] = [];
  medecins: any[] = [];
  mutuelles: any[] = [];

  constructor(
    private medecinService: MedecinService,
    private specialisteService: SpecialisteService,
    private mutuelleService: MutuelleService,
    private clientService: ClientService
  ) {
  }

  ngOnInit(): void {
    this.medecinService.getMedecins().subscribe({
      next: (data) => this.medecins = data,
      error: (error) => console.error(error)
    });
    this.specialisteService.getSpecialistes().subscribe({
      next: (data) => this.specialistes = data,
      error: (error) => console.error(error)
    })
    this.mutuelleService.getMutuelles().subscribe({
      next: (data) => this.mutuelles = data,
      error: (error) => console.error(error)
    })
  }

  onSubmit(): void {
    this.clientService.createClient(this.client).subscribe({

      next: (data) => {
        console.log("Client créer avec succès: ", data)
      },
      error: (error) => {
        console.error("Erreur lors de la création du client: ", error)
      }
    })
    console.log(this.client)
  }
}
