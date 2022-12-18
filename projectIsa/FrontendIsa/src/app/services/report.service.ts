import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const report_url = 'http://localhost:8080/report';


@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) { }

  public addReport(body:any): Observable<any>{
    console.log(body);
    return this.http.post(report_url+`/addReport`, body);
  }
}
