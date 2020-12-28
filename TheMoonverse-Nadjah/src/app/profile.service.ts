import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  
  private baseUrl= 'http://localhost:9090/api/v2'
  
  constructor(private http: HttpClient) {}

  getProfile(userId: any):Observable<any>{
    return this.http.get(`${this.baseUrl}/profile/${userId}`) ;
  }
  createProfile(profile: object):Observable<any>{
    return this.http.post(`${this.baseUrl}/addprofile`, profile);
  }
}