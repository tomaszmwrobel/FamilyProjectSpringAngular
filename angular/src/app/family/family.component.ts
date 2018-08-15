import { Component, OnInit, Input } from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Observable} from "rxjs";

import { Family } from '../family';
import {Father} from '../father';
import {Child} from '../child';


import { ActivatedRoute } from '@angular/router';

import { FamilyService } from '../family.service';

@Component({
  selector: 'app-family',
  templateUrl: './family.component.html',
  styleUrls: ['./family.component.css']
})
export class FamilyComponent implements OnInit {

  
  @Input()
  modelFamily = new Family();
  familyId: number;
  
  families: Family[] = [];
  
  constructor(private familyService: FamilyService, private http: HttpClient, private route: ActivatedRoute) { }

  ngOnInit() {
    this.modelFamily.fatherFamily = new Father();
    this.getFamily();
    this.families = [];
  }

  
  getFamily(): void {
    this.route.params.subscribe(paramsId => {
      console.log(paramsId.childId);
       this.familyId  = paramsId.childId;
      });
    
    this.familyService.getFamilyById(this.familyId)
     .subscribe(families => this.families = families);
    
  }
}
