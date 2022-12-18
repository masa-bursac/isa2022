import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { SurveyService } from 'src/app/services/survey.service';

@Component({
  selector: 'app-patient-survey-overview',
  templateUrl: './patient-survey-overview.component.html',
  styleUrls: ['./patient-survey-overview.component.css']
})
export class PatientSurveyOverviewComponent implements OnInit {
  displayedColumns: string[] = ['id', 'question', 'answer'];
  dataSource = [];

  constructor(private router: Router, private appointmentService: AppointmentsService, private _snackBar: MatSnackBar, private surveyService: SurveyService) { }

  ngOnInit(): void {
    this.surveyService.GetAnsweredSurvey(5).subscribe(data=>{
      this.dataSource = data;
    });
    
  }
  patientDidntCome($myParam: number = 0, $myParam1: number = 0): void{
    const body = {
      id: $myParam1,
      patientId: $myParam,
      patientStatus: 2
    }
      this.appointmentService.setPatientStatus(body).subscribe(data=>{
        this._snackBar.open('Patient status set successfully', 'Close',{
          duration: 3000
        });
      });
  }
  patientNotFit($myParam: number = 0, $myParam1: number = 0): void{
    const body = {
      id: $myParam1,
      patientId: $myParam,
      patientStatus: 1
    }
    this.appointmentService.setPatientStatus(body).subscribe(data=>{
      this._snackBar.open('Patient status set successfully', 'Close',{
        duration: 3000
      });
    });
  }
  fillReport($myParam: number = 0, $myParam1: number = 0): void{
    const body = {
      id: $myParam1,
      patientId: $myParam,
      patientStatus: 0
    }
    this.appointmentService.setPatientStatus(body).subscribe(data=>{
      this._snackBar.open('Patient status set successfully', 'Close',{
        duration: 3000
      });
    });
    const navigationDetails: string[] = ['/addReport'];
    if($myParam && $myParam1) {
      navigationDetails.push($myParam.toString());
      navigationDetails.push($myParam1.toString());
    }
    console.log(navigationDetails)
    this.router.navigate(navigationDetails);
  }

}
