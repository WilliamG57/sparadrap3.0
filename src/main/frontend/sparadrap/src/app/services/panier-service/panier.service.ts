import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {Article} from "../../models/article.model";
import {HttpClient} from "@angular/common/http";
import {Panier} from "../../models/panier.model";
import {Commande} from "../../models/commande.model";

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  private apiUrl = 'http://localhost:8080/panier';
  private articlesPanierSubject = new BehaviorSubject<Panier[]>([]);
  public articlesPanier = this.articlesPanierSubject.asObservable();

  constructor(private http: HttpClient) {
  }

  getPanier(): Observable<Panier[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  ajoutPanierService(panierData: {
    commande: {
      date: string, ordonnance: boolean, clientId: number
    },
    article: {
      medicamentId: number, quantite: number
    } []
  }) {
    const nouvelleCommande = new Commande();
    nouvelleCommande.date = panierData.commande.date;
    nouvelleCommande.ordonnance = panierData.commande.ordonnance;
    nouvelleCommande.clientId = panierData.commande.clientId;

    const nouveauxArticles = panierData.article.map(articleData => {
      const nouvelArticle = new Article();
      nouvelArticle.medicamentId = articleData.medicamentId;
      nouvelArticle.quantite = articleData.quantite;
      return nouvelArticle
    })

    const nouveauPanier = new Panier(nouvelleCommande, nouveauxArticles);

    const panierEnCours = this.articlesPanierSubject.getValue();
    panierEnCours.push(nouveauPanier);

    this.articlesPanierSubject.next(panierEnCours);
  }
}
