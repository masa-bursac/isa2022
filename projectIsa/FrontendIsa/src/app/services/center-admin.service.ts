import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const admin_url = 'http://localhost:8080/centerAdmin';

@Injectable({
  providedIn: 'root'
})
export class CenterAdminService {

  constructor(private http: HttpClient) { }

  public getAdmins(body:any): Observable<any>{
    return this.http.get(admin_url+`/getAllCentreAdminByCenterId/${body}`);
  }
}
