import { Component, OnInit, Input } from '@angular/core';
import { Family } from '../family';
import { FamilyService } from '../family.service';
import {Father} from '../father';
import {Child} from '../child';

import {Observable} from "rxjs";
import * as _ from 'lodash';

import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-family-list',
  templateUrl: './family-list.component.html',
  styleUrls: ['./family-list.component.css']
})
export class FamilyListComponent implements OnInit {
  
  @Input()
  model = new Child();
  
  families: Family[] = [];

  courses$: Observable<Family[]>;
  constructor(private familyService: FamilyService, private http: HttpClient) { }

  ngOnInit() {
    this.getFamilies();
    /*
    this.courses$ = this.http
            .get<Family[]>("/courses.json")
            .map(data => _.values(data))
            .do(console.log);*/
  }

  getFamilies(): void {
    this.familyService.getFamilies()
     .subscribe(families => this.families = families);
  }


  get diagnostic() { return JSON.stringify(this.families); }
  
  search(): void {
    this.familyService.SearchFamilies(this.model)
     .subscribe(families => this.families = families);
    this.model = new Child();
  }
  
  goTo(childArr: Array<Child>) {
    return JSON.stringify(childArr);
  }
}






/*import { Component, OnInit } from '@angular/core';

//@Component({
  selector: 'app-family-list',
  templateUrl: './family-list.component.html',
  styleUrls: ['./family-list.component.css']
})
export class FamilyListComponent implements OnInit {

 
  constructor() { }

 // ngOnInit() {
  }

  

}*/
