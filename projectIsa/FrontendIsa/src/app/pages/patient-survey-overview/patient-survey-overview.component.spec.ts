import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientSurveyOverviewComponent } from './patient-survey-overview.component';

describe('PatientSurveyOverviewComponent', () => {
  let component: PatientSurveyOverviewComponent;
  let fixture: ComponentFixture<PatientSurveyOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientSurveyOverviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientSurveyOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
