import {Component, OnInit} from '@angular/core';
import {Medicament} from "../../models/medicament.model";
import {MedicamentService} from "../../services/medicament-service/medicament.service";
import {CategorieMediService} from "../../services/categorie-service/categorieMedi.service";

@Component({
  selector: 'app-create-medicament',
  templateUrl: './create-medicament.component.html',
  styleUrls: ['./create-medicament.component.css']
})
export class CreateMedicamentComponent implements OnInit{
  medicament: Medicament = new Medicament();
  categories: any[] = [];

  constructor(
    private medicamentService: MedicamentService,
    private categorieMediService: CategorieMediService
  ) {}

  ngOnInit(): void {
    this.categorieMediService.getCategorieMedi().subscribe({
      next: (data: any[]) => this.categories = data,
      error: (error: any) => console.error(error)
    });
  }

  onSubmit(): void {
    this.medicamentService.createMedicaments(this.medicament).subscribe({
      next: (data) => console.log('Médicament créé avec succès', data),
      error: (error) => console.error('Erreur lors de la création du médicament', error)
    });
  }
}
