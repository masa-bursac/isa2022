import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const center_url = 'https://localhost:8080/center';

@Injectable({
  providedIn: 'root'
})
export class CenterService {

  constructor(private http: HttpClient) { }

  getCenter(body:any) : Observable<any> {
    return this.http.get(center_url+`/getCentreByAdminId/${body}`);
  }

  public editCenter(body: any): Observable<any>{
    return this.http.put(center_url+`/update`, body);
  }
    
  public getAllCenters(): Observable<any>{
    return this.http.get(center_url+`/getAllCenters`);
  }

  public searchCenters(body:any): Observable<any>{
    return this.http.get(center_url +`/searchCenters/${body}`);
  }

  public registerCenter(body:any): Observable<any>{
    console.log(body);
    return this.http.post(center_url +`/registerCenter`, body);
  }
}
