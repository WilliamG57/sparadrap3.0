import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../../models/client.model";
import {Medicament} from "../../models/medicament.model";

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

  createMedicaments(medicament: Medicament): Observable<Medicament> {
    return this.http.post<Medicament>(this.apiUrl,medicament);
  }

  deleteMedicaments(id: number | undefined) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
