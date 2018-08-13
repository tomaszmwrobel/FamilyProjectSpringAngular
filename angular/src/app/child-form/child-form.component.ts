import { Component, OnInit, Input } from '@angular/core';
import {Child} from '../child';

import { ChildService } from '../child.service';

import {Location } from '@angular/common';

@Component({
  selector: 'app-child-form',
  templateUrl: './child-form.component.html',
  styleUrls: ['./child-form.component.css']
})
export class ChildFormComponent implements OnInit {
@Input()
  model = new Child();
  
  constructor(
  private childService: ChildService,
    private location: Location
  ) { }

  ngOnInit() {
  }
  
  get diagnostic() {
    return JSON.stringify(this.model);
  }
  goBack(): void{
    this.location.back();
  }
  
  save(): void {
  
   this.childService.addChild(this.model)
     .subscribe(() => this.goBack());
 }

}
