import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeCenterAdminPasswordComponent } from './change-center-admin-password.component';

describe('ChangeCenterAdminPasswordComponent', () => {
  let component: ChangeCenterAdminPasswordComponent;
  let fixture: ComponentFixture<ChangeCenterAdminPasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeCenterAdminPasswordComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChangeCenterAdminPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
