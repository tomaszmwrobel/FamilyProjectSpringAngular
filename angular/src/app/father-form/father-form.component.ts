import { Component, OnInit, Input } from '@angular/core';
import {Father} from '../father';

import { FatherService } from '../father.service';

import { Location } from '@angular/common';

@Component({
  selector: 'app-father-form',
  templateUrl: './father-form.component.html',
  styleUrls: ['./father-form.component.css']
})
export class FatherFormComponent implements OnInit {
@Input()
  model = new Father();

  constructor(
  private fatherService: FatherService,
  private location: Location
  ) { }

  ngOnInit() {
  }

   // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }
 goBack(): void {
  this.location.back();
}
save(): void {

   this.fatherService.addFather(this.model)
     .subscribe(() => this.goBack());
 }
}
