import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AchatMedicamentComponent } from './achat-medicament.component';

describe('AchatMedicamentComponent', () => {
  let component: AchatMedicamentComponent;
  let fixture: ComponentFixture<AchatMedicamentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AchatMedicamentComponent]
    });
    fixture = TestBed.createComponent(AchatMedicamentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
