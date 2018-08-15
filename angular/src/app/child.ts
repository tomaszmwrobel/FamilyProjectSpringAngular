export class Child {
  private childId: number;
  private firstName: string;
  private secondName: string;
  private sex: string;
  private pesel: string;
  private birthDate: Date;

  contructor(
  childId: number,
    firstName: string,
    secondName: string,
    sex: string,
    pesel: string,
    birthDate: Date

  ) {}
  public get getFirstName(): string {
    return this.firstName;
  }
  public get getSecondName(): string {
    return this.secondName;
  }
  public get getSex(): string {
    return this.sex;
  }
  public get getPesel(): string {
    return this.pesel;
  }
  public get getDate(): Date {
    return this.birthDate;
  }
  public setChildId(id: number): number {
    this.childId = id;
   return this.childId;
  }


}
