import { TestBed, inject } from '@angular/core/testing';

import { PhoneServiceService } from './phone-service.service';

describe('PhoneServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PhoneServiceService]
    });
  });

  it('should be created', inject([PhoneServiceService], (service: PhoneServiceService) => {
    expect(service).toBeTruthy();
  }));
});
