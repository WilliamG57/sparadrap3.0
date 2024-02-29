import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Medecin} from "../../models/medecin.model";

@Injectable({
  providedIn: 'root'
})
export class MedecinService {

  private apiUrl = 'http://localhost:8080/medecins';

  constructor(private http: HttpClient) {
  }

  getMedecins(): Observable<Medecin[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
