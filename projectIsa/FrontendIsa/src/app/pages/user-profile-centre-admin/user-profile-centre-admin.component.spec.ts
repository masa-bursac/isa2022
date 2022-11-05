import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserProfileCentreAdminComponent } from './user-profile-centre-admin.component';

describe('UserProfileCentreAdminComponent', () => {
  let component: UserProfileCentreAdminComponent;
  let fixture: ComponentFixture<UserProfileCentreAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserProfileCentreAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserProfileCentreAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
