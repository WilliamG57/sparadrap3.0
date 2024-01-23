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
    this.medicamentService.getMedicaments().subscribe((data: any[]) => {
      this.medicaments = data.map(medicament => ({...medicament, isEditable: false}));
      console.log(data)
    })
  }

  toggleEdit(medicament: Medicament): void {
    medicament.isEditable = !medicament.isEditable;
  }

  saveMedicament(medicament: Medicament): void {
    this.medicamentService.updateMedicaments(medicament).subscribe({
      next: (response) => {
        console.log("Client mis à jours");
        medicament.isEditable = false;
      },
      error: (error) => {
        console.error("Erreur lors de la mise à jours")
      }
    })
  }
}
