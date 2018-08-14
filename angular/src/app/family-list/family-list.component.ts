import { Component, OnInit, Input } from '@angular/core';
import { Family } from '../family';
import { FamilyService } from '../family.service';
import {Father} from '../father';
import {Child} from '../child';


import {Observable} from "rxjs";




import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-family-list',
  templateUrl: './family-list.component.html',
  styleUrls: ['./family-list.component.css']
})
export class FamilyListComponent implements OnInit {
  
  @Input()
  model = new Child();
  @Input()
  modelFamily = new Family();
  
    private mdlSampleIsOpen : boolean;
  
  
  families: Family[] = [];

  //courses$: Observable<Family[]>;
  constructor(private familyService: FamilyService, private http: HttpClient) { }

  ngOnInit() {
    this.getFamilies();
    this.modelFamily.fatherFamily = new Father();
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
  
  showFamily(mFamily: Family, mFather: Father): void {
   this.modelFamily = mFamily;
   // mFather.
    this.modelFamily.fatherFamily = mFather;
    this.openModal(true);
  }
  
  
private openModal(open : boolean) : void {
    this.mdlSampleIsOpen = open;
}
  closeModal(close: boolean) : void {
    this.mdlSampleIsOpen = close;
  }
}
