import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveyForUserComponent } from './survey-for-user.component';

describe('SurveyForUserComponent', () => {
  let component: SurveyForUserComponent;
  let fixture: ComponentFixture<SurveyForUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SurveyForUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SurveyForUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
