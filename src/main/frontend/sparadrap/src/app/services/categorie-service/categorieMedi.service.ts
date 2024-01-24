import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CategorieMedi} from "../../models/categorieMedi.model";

@Injectable({
  providedIn: 'root'
})
export class CategorieMediService {
  private apiUrl = 'http://localhost:8080/categories';

  constructor(private http: HttpClient) { }

  getCategorieMedi(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  updateCategorieMedi(categorieMedi: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${categorieMedi.cat_id}`, categorieMedi)
  }

  createCategorieMedi(categorieMedi: CategorieMedi): Observable<CategorieMedi> {
    return this.http.post<CategorieMedi>(this.apiUrl,categorieMedi);
  }

  deleteCategorieMedi(id: number | undefined) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
