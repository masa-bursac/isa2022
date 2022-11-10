import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterAdminOverviewComponent } from './center-admin-overview.component';

describe('CenterAdminOverviewComponent', () => {
  let component: CenterAdminOverviewComponent;
  let fixture: ComponentFixture<CenterAdminOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterAdminOverviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CenterAdminOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
