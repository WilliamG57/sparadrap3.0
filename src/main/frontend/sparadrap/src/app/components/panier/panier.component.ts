import {Component, OnInit} from '@angular/core';
import {LigneCommande} from "../../models/ligneCommande.model";
import {PanierService} from "../../services/panier-service/panier.service";
import {Panier} from "../../models/panier.model";

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit{
  panier: Panier[] = [];

  constructor(private panierService: PanierService) {}

  ngOnInit(): void {
    this.loadPanier();
  }

  loadPanier(): void {
    this.panierService.getPanier().subscribe((data) => {
      this.panier = data
    })
  }

  // retirerDuPanier(item: LigneCommande): void {
  //   this.panierService.retirerDuPanier(item.article.art_id);
  //   this.loadPanier();
  // }

  getTotal(): number {
    return this.panier.reduce((acc, item) => acc + (item.article.medicament.prix * item.quantite), 0);
  }
}
