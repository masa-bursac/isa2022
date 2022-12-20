import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentsService } from 'src/app/services/appointments.service';

@Component({
  selector: 'app-patient-appointment-list',
  templateUrl: './patient-appointment-list.component.html',
  styleUrls: ['./patient-appointment-list.component.css']
})
export class PatientAppointmentListComponent implements OnInit {
  displayedColumns = ['id', 'date', 'duration', 'taken'];
  dataSource = [];
  id: any;

  constructor(private route: ActivatedRoute, private appointmentService: AppointmentsService, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.appointmentService.getUsersAppointment(this.id).subscribe(data=>{
      this.dataSource = data;
    })
  }

  public addReport($myParam: number = 0): void{
    const navigationDetails: string[] = ['/patientSurveyReportOverview'];
    console.log($myParam);
    const $myParam1 = this.id;
    if($myParam && $myParam1) {
      navigationDetails.push($myParam1.toString());
      navigationDetails.push($myParam.toString());
    }
    this.router.navigate(navigationDetails);
  }

}
