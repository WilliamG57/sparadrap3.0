import {Component, OnInit} from '@angular/core';
import {MedicamentService} from "../../services/medicament-service/medicament.service";
import {Medicament} from "../../models/medicament.model";

@Component({
  selector: 'app-details-medicaments',
  templateUrl: './details-medicaments.component.html',
  styleUrls: ['./details-medicaments.component.css']
})
export class DetailsMedicamentsComponent implements OnInit {

  medicaments: Medicament[] = [];

  constructor(private medicamentService: MedicamentService) {
  }


  ngOnInit() {
    this.medicamentService.getMedicament().subscribe((data: any[]) => {
      this.medicaments = data.map(medicament => ({...medicament, isEditable: false}));
      console.log("Médicaments chargés :", this.medicaments);
      console.log(data)
    })
  }

  loadMedicaments(): void {
    this.medicamentService.getMedicament().subscribe((data) => {
      this.medicaments = data
    });
  }

  toggleEdit(medicament: Medicament): void {
    medicament.isEditable = !medicament.isEditable;
  }

  saveMedicament(medicament: Medicament): void {
    this.medicamentService.updateMedicament(medicament).subscribe({
      next: (response) => {
        console.log("Médicament mis à jours");
        medicament.isEditable = false;
      },
      error: (error) => {
        console.error("Erreur lors de la mise à jours")
      }
    })
  }

  deleteMedicament(medi_id: number): void {
    const confirmation = window.confirm("Etes-vous sûr de vouloir supprimer ce médicament ?")
    if (confirmation) {
      this.medicamentService.deleteMedicament(medi_id).subscribe(() => {
        console.log("Médicament supprimé avec succès")
        this.loadMedicaments();
      })
    }
  }
}
