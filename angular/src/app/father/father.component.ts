import { Component, OnInit } from '@angular/core';
import {Father} from'../father';
@Component({
  selector: 'app-father',
  templateUrl: './father.component.html',
  styleUrls: ['./father.component.css']
})
export class FatherComponent implements OnInit {

  father: Father;

  constructor() { }

  ngOnInit() {
  }

}
