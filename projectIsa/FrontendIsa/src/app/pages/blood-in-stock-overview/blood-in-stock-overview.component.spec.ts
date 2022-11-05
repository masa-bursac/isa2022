import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodInStockOverviewComponent } from './blood-in-stock-overview.component';

describe('BloodInStockOverviewComponent', () => {
  let component: BloodInStockOverviewComponent;
  let fixture: ComponentFixture<BloodInStockOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodInStockOverviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloodInStockOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
