import {Component, OnInit} from '@angular/core';
import {PanierService} from "../../services/panier-service/panier.service";
import {MedicamentService} from "../../services/medicament-service/medicament.service";
import {Panier} from "../../models/panier.model";
import {Medicament} from "../../models/medicament.model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit{
  panier: Panier[] = [];

  constructor(private panierService: PanierService, private medicamentService: MedicamentService) {}

  ngOnInit(): void {
    this.loadPanier();
  }

  loadPanier(): void {
    this.panierService.getPanier().subscribe((data) => {
      this.panier = data
    })
  }

  getMedicament(medicamentId: number): Observable<Medicament> {
    return this.medicamentService.getMedicamentById(medicamentId);
  }

  // retirerDuPanier(item: LigneCommande): void {
  //   this.panierService.retirerDuPanier(item.article.art_id);
  //   this.loadPanier();
  // }

  getTotal(): number {
    let total = 0;
    this.panier.forEach((panier) => {
      panier.article.forEach((article) => {
        const medicament = this.medicamentService.getMedicamentById(article.medicamentId);
        // if (medicament) {
        //   total += article.quantite * medicament.prix;
        // }
        console.log(medicament)
      });
    });
    return total;
  }
}
