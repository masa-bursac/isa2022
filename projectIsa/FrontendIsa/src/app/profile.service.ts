import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const profile_url = 'http://localhost:8080/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

  public getProfile(body:any): Observable<any>{
    return this.http.get(profile_url+`/getProfile/${body}`);
  }
}
