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

  public addAppointment(body:any): Observable<any>{
    console.log(body);
    return this.http.post(appointments_url+`/addFreeAppointment`, body);
  }
  
  public getTakenAppointments(adminId : number){
    return this.http.get(appointments_url+`/getTakenAppointment/${adminId}`);
  }

}
