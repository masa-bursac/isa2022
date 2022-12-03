import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const complaint_url = 'http://localhost:8080/complaint';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {
  
  constructor(private http: HttpClient) { }

  public getComplaints(): Observable<any>{
    return this.http.get(complaint_url+`/getComplaints`);
  }
  public sendAnswer(body: any): Observable<any> {
    return this.http.put(complaint_url+`/sendAnswer`, body);

  }
}
