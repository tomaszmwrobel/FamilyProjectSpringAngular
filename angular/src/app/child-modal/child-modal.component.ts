import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';

import {NgbModal, NgbActiveModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-child-modal',
  templateUrl: './child-modal.component.html',
  styleUrls: ['./child-modal.component.css']
})
export class ChildModalComponent implements OnInit {

  closeResult: string;
  constructor(private modalService: NgbModal,
  public activeModal: NgbActiveModal
  ) { }

  ngOnInit() {
  }
openBackDropCustomClass(content) {
    this.modalService.open(content, {backdropClass: 'light-blue-backdrop'});
  }

  openWindowCustomClass(content) {
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }

  openSm(content) {
    this.modalService.open(content, { size: 'sm' });
  }

  openLg(content) {
    this.modalService.open(content, { size: 'lg' });
  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true });
  }

}
