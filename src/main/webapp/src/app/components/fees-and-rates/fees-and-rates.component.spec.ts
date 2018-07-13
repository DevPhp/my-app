import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeesAndRatesComponent } from './fees-and-rates.component';

describe('FeesAndRatesComponent', () => {
  let component: FeesAndRatesComponent;
  let fixture: ComponentFixture<FeesAndRatesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeesAndRatesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeesAndRatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
