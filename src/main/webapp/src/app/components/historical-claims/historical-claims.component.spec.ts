import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoricalClaimsComponent } from './historical-claims.component';

describe('HistoricalClaimsComponent', () => {
  let component: HistoricalClaimsComponent;
  let fixture: ComponentFixture<HistoricalClaimsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HistoricalClaimsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoricalClaimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
