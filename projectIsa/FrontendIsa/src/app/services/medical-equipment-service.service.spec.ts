import { TestBed } from '@angular/core/testing';

import { MedicalEquipmentServiceService } from './medical-equipment-service.service';

describe('MedicalEquipmentServiceService', () => {
  let service: MedicalEquipmentServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicalEquipmentServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
