import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const profile_url = 'http://localhost:8080/medicalEquipment';

@Injectable({
  providedIn: 'root'
})
export class MedicalEquipmentServiceService {
  constructor(private http: HttpClient) { }

  GetBlood(): Observable<any>{
    return this.http.get<any>(profile_url+`/getBlood`);
  }
}
