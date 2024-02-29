import {Article} from "./article.model";
import {Commande} from "./commande.model";

export class Panier {
  constructor(
    public commande: Commande,
    public article: Article [],
  ) {}
}
