import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildModalComponent } from './child-modal.component';

describe('ChildModalComponent', () => {
  let component: ChildModalComponent;
  let fixture: ComponentFixture<ChildModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
