import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsMedicamentsComponent } from './details-medicaments.component';

describe('DetailsMedicamentsComponent', () => {
  let component: DetailsMedicamentsComponent;
  let fixture: ComponentFixture<DetailsMedicamentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailsMedicamentsComponent]
    });
    fixture = TestBed.createComponent(DetailsMedicamentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
