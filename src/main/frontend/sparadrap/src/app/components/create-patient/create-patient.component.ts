import { Component } from '@angular/core';
import {MedecinService} from "../../services/medecin-service/medecin.service";
import {SpecialisteService} from "../../services/specialiste-service/specialiste.service";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent {
  specialistes: any[] = [];
  medecins: any[] = [];

  constructor(
    private medecinService: MedecinService,
    private specialisteService: SpecialisteService) {}

  ngOnInit(): void {
    this.medecinService.getMedecins().subscribe({
      next: (data) => this.medecins = data,
      error: (error) => console.error(error)
    });
    this.specialisteService.getSpecialistes().subscribe({
      next: (data) => this.specialistes = data,
      error: (error) => console.log(error)
    })
  }
}
