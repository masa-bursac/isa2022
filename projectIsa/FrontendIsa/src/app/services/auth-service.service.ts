import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const auth_url = 'http://localhost:8080/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http: HttpClient) { }

  public registration(body: any) : Observable<any>{ 
    return this.http.post(auth_url + `/registration`, body);
  }
}
