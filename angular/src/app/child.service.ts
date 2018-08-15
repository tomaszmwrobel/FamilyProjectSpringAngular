import { Injectable } from '@angular/core';

import {HttpClient, HttpHeaders } from '@angular/common/http';


import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import {Child } from './child';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ChildService {

  private childUrl = 'http://localhost:8080/api/child';
  constructor(
  private http: HttpClient
  ) { }

  addChild (child: Child): Observable<Child> {

    return this.http.post<Child>(this.childUrl, child, httpOptions).pipe(
    tap(() => this.log('added Child')),
      catchError(this.handleError<Child>('addChild'))
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


