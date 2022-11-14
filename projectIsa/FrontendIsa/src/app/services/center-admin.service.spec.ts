import { TestBed } from '@angular/core/testing';

import { CenterAdminService } from './center-admin.service';

describe('CenterAdminService', () => {
  let service: CenterAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CenterAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
