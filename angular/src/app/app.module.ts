import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { FatherComponent } from './father/father.component';
import { FatherFormComponent } from './father-form/father-form.component';

import {HttpClientModule } from '@angular/common/http';
import { ChildFormComponent } from './child-form/child-form.component';
import { FamilyListComponent } from './family-list/family-list.component';
import { FamilyComponent } from './family/family.component';
import { ChildModalComponent } from './child-modal/child-modal.component';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    FatherComponent,
    FatherFormComponent,
    ChildFormComponent,
    FamilyListComponent,
    FamilyComponent,
    ChildModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
     NgbModule.forRoot(),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
