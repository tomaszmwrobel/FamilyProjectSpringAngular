import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {FatherFormComponent} from './father-form/father-form.component';
import {ChildFormComponent} from './child-form/child-form.component';
import {FamilyListComponent} from './family-list/family-list.component';

const routes: Routes = [
{path: 'addFamily' , component: FatherFormComponent},
  {path: 'addChild', component: ChildFormComponent},

  {path: 'readFamily', component: FamilyListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
