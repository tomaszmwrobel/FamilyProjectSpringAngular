import { Component, OnInit, Input } from '@angular/core';
import {Child} from '../child';

import { ChildService } from '../child.service';

import {Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-child-form',
  templateUrl: './child-form.component.html',
  styleUrls: ['./child-form.component.css']
})
export class ChildFormComponent implements OnInit {
@Input()
  model = new Child();
childId: string;
  
  constructor(
  private childService: ChildService,
    private location: Location,
    private route: ActivatedRoute,
    
    
  ) {
    this.childId = this.route.snapshot.params.fatherId; }

  ngOnInit() {
  //this.childId = this.route.snapshot.paramMap.get('fatherId');
    this.route.params.subscribe(paramsId => {
      console.log(paramsId.fatherId);
      //this.model.setChildId(this.childId);
      
      this.model.setChildId(paramsId.fatherId);
  
    });
    //console.log(this.childId);
    
  }
  
  get diagnostic() {
    return JSON.stringify(this.model);
  }
  goBack(): void{
    this.location.back();
  }
  
  save(): void {
  //this.model.setChildId(Number(this.childId));
   this.childService.addChild(this.model)
     .subscribe(() => this.goBack());
 }

}
