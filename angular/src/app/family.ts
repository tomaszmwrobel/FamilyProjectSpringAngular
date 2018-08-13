import {Father} from './father';
import {Child} from './child';

export class Family {
  familyId: number;
  fatherFamily: Father;
  childFamily: Array<Child>;
}
