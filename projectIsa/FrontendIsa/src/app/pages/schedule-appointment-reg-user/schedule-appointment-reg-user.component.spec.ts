import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleAppointmentRegUserComponent } from './schedule-appointment-reg-user.component';

describe('ScheduleAppointmentRegUserComponent', () => {
  let component: ScheduleAppointmentRegUserComponent;
  let fixture: ComponentFixture<ScheduleAppointmentRegUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleAppointmentRegUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScheduleAppointmentRegUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
