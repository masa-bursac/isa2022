import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

interface hour {
  id?: number,
  name?: string
}

interface minute {
  id?: number,
  name?: string
}

@Component({
  selector: 'app-schedule-appointment-reg-user',
  templateUrl: './schedule-appointment-reg-user.component.html',
  styleUrls: ['./schedule-appointment-reg-user.component.css']
})

export class ScheduleAppointmentRegUserComponent implements OnInit {

  public allCenters: any[] = [];
  public isEmpty: boolean = false;

  hours : hour[] = [{id: 1, name:"08"},
  {id: 2, name:"09"},
  {id: 3, name:"10"},
  {id: 4, name:"11"},
  {id: 5, name:"12"},
  {id: 6, name:"13"},
  {id: 7, name:"14"},
  {id: 8, name:"15"},
  {id: 9, name:"16"}];

  minutes : minute[] = [{id: 1, name:"00"},
  {id: 2, name:"30"}];

  selectedHour?: hour;
  selectedMinute?: minute;

  format = "yyyy-MM-ddTHH:mm:ss";
  date = new Date(new Date().setDate(new Date().getDate() + 1));
  todayDate = formatDate(this.date, this.format, "en-US");

  validateForm1 = new FormGroup({
    date: new FormControl(),
    hours: new FormControl(),
    minutes: new FormControl()
  })

  allDirections: any[] = [
    {value: 'ascending', viewValue: 'ascending'},
    {value: 'descending', viewValue: 'descending'}
  ];

  constructor(private fb: FormBuilder, private _snackBar: MatSnackBar, private appointmentService: AppointmentsService, private router: Router, private tokenStorage: TokenStorageService) { }


  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }else if(this.tokenStorage.getUser().roles[0] !== "ROLE_REGISTERED"){
      alert("Unauthorized!");
      this.router.navigate(['/homePage']);
    }
  }

   findAppointment():void{
    const format = "yyyy-MM-ddTHH:mm:ss";
    const date = new Date(this.validateForm1.value.date);
    switch ( this.selectedHour ) {
      case "08":
          date.setHours(8);
          break;
      case "09":
          date.setHours(9);
          break;
      case "10":
            date.setHours(10);
            break;
      case "11":
            date.setHours(11);
            break;
      case "12":
            date.setHours(12);
            break;
      case "13":
            date.setHours(13);
            break;
      case "14":
            date.setHours(14);
            break;
      case "15":
            date.setHours(15);
            break;
      case "16":
            date.setHours(16);
            break;
      default: 
            break;
    }

    if(this.selectedMinute == "00"){
      date.setMinutes(0);
    }else if(this.selectedMinute == "30"){
      date.setMinutes(30);
    }

    if(this.validateForm1.valid){
      this.appointmentService.findAppointment(formatDate(date, format, "en-US")).subscribe(data=>{
        this.allCenters = data;
        if(this.allCenters.length === 0){
          this._snackBar.open('There are no free appointments for that time', 'Close',{
            duration: 3000
          });
        }
      });
    } else{
      this._snackBar.open('Error! All feilds are required!', 'Close',{
        duration: 3000
      });
    }
  }

  public sortByRating(value: string) {
    if (value === 'ascending') {
      this.allCenters.sort((a,b) => a.rating > b.rating ? 1 : -1);
    } else if (value === 'descending') {
      this.allCenters.sort((a,b) => a.rating < b.rating ? 1 : -1);
    }
  }
}
