import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {FatherFormComponent} from './father-form/father-form.component';
import {ChildFormComponent} from './child-form/child-form.component';
import {FamilyListComponent} from './family-list/family-list.component';
import {FamilyComponent} from './family/family.component';

const routes: Routes = [
{path: 'addFamily' , component: FatherFormComponent},
  {path: 'addChild', component: ChildFormComponent},
  
  {path: 'addChild/:fatherId', component: ChildFormComponent},

  {path: 'showFamily', component: FamilyComponent},
  {path: 'showFamily/:childId', component: FamilyComponent},
  {path: 'readFamily', component: FamilyListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
