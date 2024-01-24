import { TestBed } from '@angular/core/testing';

import { CategorieMediService } from './categorieMedi.service';

describe('CategorieService', () => {
  let service: CategorieMediService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CategorieMediService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
