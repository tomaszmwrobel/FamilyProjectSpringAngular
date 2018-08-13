import { Injectable } from '@angular/core';


import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Father } from './father';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const httpOptions2 = {
  headers: {'Content-Type': 'application/json','Access-Control-Allow-Origin' : '*'}
};


@Injectable({
  providedIn: 'root'
})
export class FatherService {

  private fatherUrl2 = 'api/father';  // URL to web api

  private fatherUrl = 'http://localhost:8080/api/father';  // URL to web api
  constructor(
    private http: HttpClient) { }


  addFather(father: Father): Observable<Father> {
   /* let headers2: HttpHeaders = new HttpHeaders();
headers2 = headers2.append('Content-Type', 'application/json');
headers2 = headers2.append('Access-Control-Allow-Methods', 'GET, POST, DELETE, PUT');*/
    let headerss = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin' : '*'
      });

  let options = { headers: headerss };
    
   return this.http.post<Father>(this.fatherUrl, father, options).pipe(
      tap((father: Father) => this.log(`added father`)),
      catchError(this.handleError<Father>('addFather'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
 private log(message: string) {
    //this.messageService.add(`HeroService: ${message}`);
  }
}
