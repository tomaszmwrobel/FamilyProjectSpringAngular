export class Child {
  private childId: number;
  private firstName: string;
  private secondName: string;
  private sex: string;
  private pesel: string;
  contructor(
  childId: number,
    firstName: string,
    secondName: string,
    sex: string,
    pesel: string,

  )
  {}
  public get getFirstName(): string
  {
    return this.firstName;
  }
  public get getSecondName(): string
  {
    return this.secondName;
  }
  public get getSex(): string
  {
    return this.sex;
  }
  public get getPesel(): string
  {
    return this.pesel;
  }
  public setChildId(id: number): number
  {
    this.childId = id;
   return this.childId;
  }


}
