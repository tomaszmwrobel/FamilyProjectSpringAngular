import { Component, OnInit, Input } from '@angular/core';
import {Father} from '../father';

import { FatherService } from '../father.service';

import { Location } from '@angular/common';


import { Router } from '@angular/router';

@Component({
  selector: 'app-father-form',
  templateUrl: './father-form.component.html',
  styleUrls: ['./father-form.component.css']
})
export class FatherFormComponent implements OnInit {
@Input()
  model = new Father();

  submitted = false;
 
  constructor(
  private fatherService: FatherService,
  private location: Location,
  private router: Router
  ) { }

  ngOnInit() {
    this.model = new Father();
  }

  onSubmit() { this.submitted = true; }

   // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }
 goBack(): void {
  this.location.back();
}
save(): void {

   this.fatherService.addFather(this.model)
     .subscribe(() => this.goBack());
 }
  btnClick(): void {
    this.redirect();
  }
  redirect(): void {
    this.fatherService.addFather2(this.model).subscribe(
      model => this.model = model,
      error => console.log('Error: ', error),
      () => this.router.navigate(['/addChild', this.model.fatherId])
    );
  }
}
