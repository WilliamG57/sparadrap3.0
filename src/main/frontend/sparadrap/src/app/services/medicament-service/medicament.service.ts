import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MedicamentService {

  private apiUrl = 'http://localhost:8080/medicaments';
  constructor(private http: HttpClient) { }

  getMedicaments(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  updateMedicaments(medicament: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${medicament.medi_id}`, medicament)
  }
}
