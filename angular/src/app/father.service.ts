import { Injectable } from '@angular/core';


import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Router } from '@angular/router';

import { Father } from './father';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const httpOptions2 = {
  headers: {'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : '*'}
};


@Injectable({
  providedIn: 'root'
})
export class FatherService {

  private fatherUrl2 = 'api/father';  // URL to web api

  private fatherUrl = 'http://localhost:8080/api/father';  // URL to web api
  constructor(
    private http: HttpClient,
    private router: Router
  ) { }


  addFather(father: Father): Observable<Father> {
    const headerss = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin' : '*'
      });

  const options = { headers: headerss };

   return this.http.post<Father>(this.fatherUrl, father, options).pipe(
      tap(() => this.log(`added father`)),
      catchError(this.handleError<Father>('addFather'))
    );
  }
  addFather2(father: Father): Observable<Father> {

    const headerss = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin' : '*'
      });

  const options = { headers: headerss , observe: 'response' };
   return this.http.post<Father>(this.fatherUrl, father, httpOptions).pipe(
      tap(() => this.log(`added father`)),
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

 private log(message: string) {
    console.log(message);
  }
}
