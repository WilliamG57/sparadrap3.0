import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SpecialisteService {
  private apiUrl = 'http://localhost:8080/specialistes';

  constructor(private http: HttpClient) { }

  getSpecialistes(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
