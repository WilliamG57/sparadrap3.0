import {Component} from '@angular/core';
import {MeteoService} from '../../services/meteo-service/meteo.service';

interface NominatimResponse {
  lat: string;
  lon: string;
}


@Component({
  selector: 'app-meteo',
  templateUrl: './meteo.component.html',
  styleUrls: ['./meteo.component.css']
})
export class MeteoComponent {
  ville: string = '';
  weatherData: any = null;

  constructor(private meteoService: MeteoService) {
  }

  searchAddress(): void {
    this.meteoService.getCoordinate(this.ville).subscribe({
      next: (data: NominatimResponse []) => {
        const coordinate = data.length > 0 ? {lat: data[0].lat, lon: data[0].lon} : null
        console.log(coordinate);
        if (coordinate) {
          this.searchWeather(coordinate.lat, coordinate.lon);
        }
      },
      error: (error: any) => {
        console.error('Erreur lors de la récupération des coordonnées', error);
      }
    });
  }

  searchWeather(lat: string, lon: string): void {
    this.meteoService.getWeather(lat, lon).subscribe({
      next: (data) => {
        this.weatherData = data;
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données météo', error);
      }
    });
  }
}
