import {Component, OnInit} from '@angular/core';
import {Medicament} from "../../models/medicament.model";
import {Medecin} from "../../models/medecin.model";
import {MedicamentService} from "../../services/medicament-service/medicament.service";
import {MedecinService} from "../../services/medecin-service/medecin.service";
import {PanierService} from "../../services/panier-service/panier.service";
import {Client} from "../../models/client.model";
import {ClientService} from "../../services/client-service/client.service";
import {Commande} from "../../models/commande.model";
import {Article} from "../../models/article.model";

@Component({
  selector: 'app-achat-medicament',
  templateUrl: './achat-medicament.component.html',
  styleUrls: ['./achat-medicament.component.css']
})
export class AchatMedicamentComponent implements OnInit {

  commande = new Commande();
  medicaments: Medicament[] = [];
  medecins: Medecin[] = [];
  clients: Client[] = [];
  selectedMedicament?: number;
  selectedMedecin?: number;
  selectedClient?: number
  selectedQuantite?: 1;
  ordonnance: boolean = false;
  message: string = '';

  constructor(
    private clientService: ClientService,
    private medicamentService: MedicamentService,
    private medecinService: MedecinService,
    private panierService: PanierService
  ) {
  }

  ngOnInit() {
    this.loadClients();
    this.loadMedicaments();
    this.loadMedecins();
    // this.commande = new Commande();
    // this.commande.date = '';
  }

  loadClients(): void {
    this.clientService.getClients().subscribe({
      next: (data) => {
        this.clients = data;
      }
    })
  }

  loadMedicaments(): void {
    this.medicamentService.getMedicament().subscribe({
      next: (data) => {
        this.medicaments = data;
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  loadMedecins(): void {
    this.medecinService.getMedecins().subscribe({
      next: (data) => {
        this.medecins = data;
        console.log(data)
      },
      error: (err) => {
        console.error(err)
      }
    })
  }

  ajoutPanier(): void {
    if (this.selectedMedicament && this.selectedQuantite && this.commande.date && this.selectedClient) {

      const panier = {
         commande: {
          date: this.commande.date,
          clientId: this.selectedClient,
          ordonnance: this.ordonnance
        },

         article: {
          medicamentId: this.selectedMedicament,
          quantite: this.selectedQuantite
        }
      }
      this.panierService.ajoutPanierService(panier);
    } else {
      this.message = "Bien remplir les champs svp.";
    }
  }
  protected readonly Commande = Commande;
}
