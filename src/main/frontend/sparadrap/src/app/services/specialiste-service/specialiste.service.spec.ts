import { TestBed } from '@angular/core/testing';

import { SpecialisteService } from './specialiste.service';

describe('SpecialisteService', () => {
  let service: SpecialisteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpecialisteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
