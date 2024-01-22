import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MutuelleService {
  private apiUrl = 'http://localhost:8080/mutuelles';

  constructor(private http: HttpClient) { }

  getMutuelles(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl)
  }
}
