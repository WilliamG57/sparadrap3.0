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
  constructor(private meteoService: MeteoService) {
  }


  searchAddress(): void {
    this.meteoService.getCoordinate(this.ville).subscribe({
      next: (data: NominatimResponse []) => {
        // Traitez les données de réponse ici
        // Par exemple, extrayez la latitude et la longitude
        const coordinate = data.length > 0 ? {lat: data[0].lat, lon: data[0].lon} : null
        console.log(coordinate);
      },
      error: (error: any) => {
        console.error('Erreur lors de la récupération des coordonnées', error);
      }
    });
  }
}
