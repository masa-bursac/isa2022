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
          //console.log(this.dataSource)
    });
    
  }
  patientDidntCome(): void{
    const body = {
      id: 1, //CHANGE
      patientId: 5,//CHANGE
      patientStatus: 2
    }
      this.appointmentService.setPatientStatus(body).subscribe(data=>{
        this._snackBar.open('Patient status set successfully', 'Close',{
          duration: 3000
        });
      });
  }
  patientNotFit(): void{
    const body = {
      id: 1, //CHANGE
      patientId: 5,//CHANGE
      patientStatus: 1
    }
    this.appointmentService.setPatientStatus(body).subscribe(data=>{
      this._snackBar.open('Patient status set successfully', 'Close',{
        duration: 3000
      });
    });
  }
  fillReport(): void{
    const body = {
      id: 1, //CHANGE
      patientId: 5,//CHANGE
      patientStatus: 0
    }
    this.appointmentService.setPatientStatus(body).subscribe(data=>{
      this._snackBar.open('Patient status set successfully', 'Close',{
        duration: 3000
      });
    });
    this.router.navigate(['/addReport']);
  }

}
