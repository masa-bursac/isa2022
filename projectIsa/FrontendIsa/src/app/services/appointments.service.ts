import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const appointments_url = 'http://localhost:8080/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentsService {

  constructor(private http: HttpClient) { }

  public getAllCenters(body:any): Observable<any>{
    return this.http.get(appointments_url+`/getAllFreeAppointments/${body}`);
  }

}
