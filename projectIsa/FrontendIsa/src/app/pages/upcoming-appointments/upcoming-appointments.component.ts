import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-upcoming-appointments',
  templateUrl: './upcoming-appointments.component.html',
  styleUrls: ['./upcoming-appointments.component.css']
})
export class UpcomingAppointmentsComponent implements OnInit {

  public allAppointments: any[] = [];
  role: any;
  public centerId = localStorage.getItem('center');

  constructor(private router: Router, private _snackBar: MatSnackBar, private appointmentService: AppointmentsService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length !== 0){
      if(this.tokenStorage.getUser().roles[0] === "ROLE_CENTERADMIN"){
        alert("Unauthorized!");
        this.router.navigate(['/homePage']);
      }else if(Object.keys(this.tokenStorage.getUser()).length === 0){
        this.role = "ROLE_UNREGISTERED"
      }else{
        this.role = this.tokenStorage.getUser().roles[0];
        console.log(this.role);
      }
    }
    this.showAllAppointments();
  }

  public showAllAppointments(): void {
    this.appointmentService.getAllCenters(this.centerId).subscribe(data => {
      console.log(data);
      this.allAppointments = data;
    });
  }

  public scheduleAppointment(date: string): void {
    const body = {
      date: date,
      userId: this.tokenStorage.getUser().id,
      centerId: this.centerId
    }

    this.appointmentService.scheduleAppointment(body).subscribe(data=>{
      if(data.message == "You can make an appointment only if you take survey"){
        this._snackBar.open(data.message, 'Close',{
          duration: 5000
        });
        this.router.navigate(['/takeSurvey']);
      }else if(data.message == "You can make an appointment only if you have not donated blood in the last 6 months"){
        this._snackBar.open(data.message, 'Close',{
          duration: 5000
        });
      }else if(data.message == "You can make an appointment only if you take survey again"){
        this._snackBar.open(data.message, 'Close',{
          duration: 5000
        });
        this.router.navigate(['/takeSurvey']);
      }else {
        this._snackBar.open(data.message, 'Close',{
          duration: 5000
        });
      }
        
    });
  }

}
