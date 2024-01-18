import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MeteoService {

  private nominatimApiUrl = 'https://nominatim.openstreetmap.org/search';
  constructor(private http: HttpClient) {
  }
  getCoordinate(address: string): Observable<any> {
    const params = new HttpParams()
      .set('q', address)
      .set('format', 'json');

    return this.http.get(this.nominatimApiUrl, { params });
  }
}
