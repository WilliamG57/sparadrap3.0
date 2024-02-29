import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Medicament} from "../../models/medicament.model";

@Injectable({
  providedIn: 'root'
})
export class MedicamentService {

  private apiUrl = 'http://localhost:8080/medicaments';

  constructor(private http: HttpClient) {
  }

  getMedicament(): Observable<Medicament[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getMedicamentById(id: number): Observable<Medicament> {
    return this.http.get<Medicament>(`${this.apiUrl}/${id}`);
  }

  updateMedicament(medicament: Medicament): Observable<Medicament> {
    return this.http.put<Medicament>(`${this.apiUrl}/${medicament.medi_id}`, medicament)
  }

  createMedicament(medicament: Medicament): Observable<Medicament> {
    return this.http.post<Medicament>(this.apiUrl, medicament);
  }

  deleteMedicament(id: number) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
