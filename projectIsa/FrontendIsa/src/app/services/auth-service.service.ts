import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const auth_url = 'https://localhost:8080/auth';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http: HttpClient) { }

  public login(email: string, password: string): Observable<any> {
    const data = {
      email: email,
      password: password
  };
    return this.http.post(auth_url + '/login', data, httpOptions);
  }

  public registration(body: any) : Observable<any>{ 
    return this.http.post(auth_url + '/registration', body, httpOptions);
  }

  public continueRegistration(email: string | null) : Observable<any> {
    return this.http.post(auth_url + '/continueRegistration', email, httpOptions);
  }

  public getPenals(body: number) : Observable<any> {
    return this.http.get(auth_url + `/getPenals/${body}`);
  }

}
