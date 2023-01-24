import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryOfAppointmentsComponent } from './history-of-appointments.component';

describe('HistoryOfAppointmentsComponent', () => {
  let component: HistoryOfAppointmentsComponent;
  let fixture: ComponentFixture<HistoryOfAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoryOfAppointmentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistoryOfAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
