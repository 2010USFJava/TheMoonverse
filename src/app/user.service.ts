import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl= 'http://localhost:8080'
  http: any;
  constructor() { }

  getUser(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${userId}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, user);
  }

  updateUSer(userId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${userId}`, value);
  }

  deleteUsere(userId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${userId}`, { responseType: 'text' });
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}


