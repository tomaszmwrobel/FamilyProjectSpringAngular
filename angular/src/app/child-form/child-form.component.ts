import { Component, OnInit, Input } from '@angular/core';
import {Child} from '../child';

import { ChildService } from '../child.service';

import {Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

import { Router } from '@angular/router';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-child-form',
  templateUrl: './child-form.component.html',
  styleUrls: ['./child-form.component.css']
})
export class ChildFormComponent implements OnInit {
@Input()
  model = new Child();
childId: number;

    private mdlSampleIsOpen: boolean;


  submitted = false;

private openModal(open: boolean): void {
    this.mdlSampleIsOpen = open;
}
  closeModal(close: boolean): void {
    this.mdlSampleIsOpen = close;
  }

  constructor(
  private childService: ChildService,
    private location: Location,
    private route: ActivatedRoute,
    private router: Router,
    private modalService: NgbModal

  ) {
    this.childId = this.route.snapshot.params.fatherId; }

  ngOnInit() {
    this.route.params.subscribe(paramsId => {
      console.log(paramsId.fatherId);

      this.model.setChildId(paramsId.fatherId);
      this.childId  = paramsId.fatherId;

    });

   this.mdlSampleIsOpen = false;


  }


  onSubmit() { this.submitted = true; }
  
  get diagnostic() {
    return JSON.stringify(this.model);
  }
  goBack(): void {
    this.location.back();
  }

  save(): void {
   this.childService.addChild(this.model)
     .subscribe(() => this.openModal(true));
 }

  addNext(): void {
    this.model = new Child();
      this.model.setChildId(this.childId);
    this.closeModal(false);
    this.submitted = false;
  }
    Show(): void {
  this.router.navigate(['/showFamily', this.childId]);

}
}

