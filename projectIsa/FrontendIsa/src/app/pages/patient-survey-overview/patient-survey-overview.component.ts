import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { SurveyService } from 'src/app/services/survey.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-patient-survey-overview',
  templateUrl: './patient-survey-overview.component.html',
  styleUrls: ['./patient-survey-overview.component.css']
})
export class PatientSurveyOverviewComponent implements OnInit {
  displayedColumns: string[] = ['id', 'question', 'answer'];
  dataSource = [];
  id: any;
  ap: any;

  constructor(private router: Router, private appointmentService: AppointmentsService, private _snackBar: MatSnackBar, private surveyService: SurveyService,
    private tokenStorage: TokenStorageService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }else if(this.tokenStorage.getUser().roles[0] !== "ROLE_CENTERADMIN"){
      alert("Unauthorized!");
      this.router.navigate(['/homePage']);
    }
    this.id = this.route.snapshot.paramMap.get('id');
    this.ap = this.route.snapshot.paramMap.get('ap');
    this.surveyService.GetAnsweredSurvey(this.id).subscribe(data=>{
      this.dataSource = data;
    });
    
  }
  patientDidntCome(): void{
    const body = {
      id: this.ap,
      patientId: this.id,
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
      id: this.ap,
      patientId: this.id,
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
      id: this.ap,
      patientId: this.id,
      patientStatus: 0
    }
    this.appointmentService.setPatientStatus(body).subscribe(data=>{
      this._snackBar.open('Patient status set successfully', 'Close',{
        duration: 3000
      });
    });
    const navigationDetails: string[] = ['/addReport'];
    const $myParam = this.id;
    const $myParam1 = this.ap;
    if($myParam && $myParam1) {
      navigationDetails.push($myParam.toString());
      navigationDetails.push($myParam1.toString());
    }
    this.router.navigate(navigationDetails);
  }

}
