import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterlineComponent } from './footerline.component';

describe('FooterlineComponent', () => {
  let component: FooterlineComponent;
  let fixture: ComponentFixture<FooterlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
