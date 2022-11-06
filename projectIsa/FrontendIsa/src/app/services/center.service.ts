import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const post_url = 'http://localhost:8080/center';

@Injectable({
  providedIn: 'root'
})
export class CenterService {

  constructor(private http: HttpClient) { }

  public getAllCenters(): Observable<any>{
    return this.http.get(post_url+`/getAllCenters`);
  }

  public searchCenters(body:any): Observable<any>{
    return this.http.get(post_url+`/searchCenters/${body}`);
  }

  public registerCenter(body:any): Observable<any>{
    console.log(body);
    return this.http.post(post_url+`/registerCenter`, body);
  }
}
