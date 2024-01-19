import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MeteoService {

  private openWeatherMapApiUrl = 'https://api.openweathermap.org/data/2.5/weather';
  private apiKey = 'e9e6a789aeb794ec2dd3f246d849964b';
  private nominatimApiUrl = 'https://nominatim.openstreetmap.org/search';

  constructor(private http: HttpClient) {
  }

  getCoordinate(address: string): Observable<any> {
    const params = new HttpParams()
      .set('q', address)
      .set('format', 'json');

    return this.http.get(this.nominatimApiUrl, {params});
  }

  getWeather(lat: string, lon: string): Observable<any> {
    const params = new HttpParams()
      .set('lat', lat)
      .set('lon', lon)
      .set('appid', this.apiKey)
      .set('units', 'metric');
    return this.http.get(this.openWeatherMapApiUrl, {params});
  }
}
