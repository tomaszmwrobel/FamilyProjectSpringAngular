import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';


import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import {Family} from './family';
import {Child} from './child';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FamilyService {

  private familyUrl = 'http://localhost:8080/api/families';
  
  private familySearchUrl = 'http://localhost:8080/api/families/search';
  
  private famylyByIdUrl = 'http://localhost:8080/api/family/';
  constructor(private http: HttpClient) { }

   getFamilies (): Observable<Family[]> {

    return this.http.get<Family[]>(this.familyUrl)
      .pipe(
        tap(families => this.log('fetched families')),
        catchError(this.handleError('getFamilies', []))
      );
  }
  
  
  getFamilyById(id: number): Observable<Family[]>
  {
    const familyIdUrl = (this.famylyByIdUrl + id);
    
    return this.http.get<Family[]>(familyIdUrl)
      .pipe(
        tap(families => this.log('fetched families')),
        catchError(this.handleError('getFamilies', []))
      );
  }
  SearchFamilies (child: Child): Observable<Family[]> {

      let params = new HttpParams();
      if ( child.getFirstName != null) {
      params = params.append('firstName', child.getFirstName);
      }
    if ( child.getSecondName != null)
     {
      params = params.append('secondName', child.getSecondName);
    }
     if ( child.getSex != null) {
      params = params.append('sex', child.getSex);
      }
     if ( child.getPesel != null) {
      params = params.append('pesel', child.getPesel);
      }
    
    if ( child.getDate != null)
      {
      params = params.append('birthDate',child.getDate);
    }
    return this.http.get<Family[]>(this.familySearchUrl, {params: params})
      .pipe(
        tap(families => this.log('fetched families')),
        catchError(this.handleError('getFamilies', []))
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

  /** Log */
 private log(message: string) {

  }
}
