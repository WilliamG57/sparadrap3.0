import {Article} from "./article.model";
import {Commande} from "./commande.model";

export class LigneCommande{
  ligne_id?: number;
  commande: Commande;
  article: Article;

  constructor() {
    this.commande= new Commande();
    this.article= new Article()
  }
}
