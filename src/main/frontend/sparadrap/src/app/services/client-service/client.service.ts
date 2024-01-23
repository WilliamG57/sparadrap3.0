import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Client} from "../../models/client.model";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl = 'http://localhost:8080/clients';

  constructor(private http: HttpClient) { }

  getClients(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  updateClient(client: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${client.per_id}`, client)
  }

  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.apiUrl,client);
  }

  deleteClient(id: number | undefined) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
