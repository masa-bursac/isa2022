import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReportService } from 'src/app/services/report.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-history-of-appointments',
  templateUrl: './history-of-appointments.component.html',
  styleUrls: ['./history-of-appointments.component.css']
})
export class HistoryOfAppointmentsComponent implements OnInit {

  public allUsersAppointments: any[] = [];
  public startHour: number  = 0;
  public startMinute: number = 0;
  public endHour: number  = 0;
  public endMinute: number = 0;
  public durationHour: number = 0;
  public durationMinute: number  = 0;
  public duration: number[] = [];
  public numbers: number[] = [0, 1];

  constructor(private router: Router, private tokenStorage: TokenStorageService, private reportService: ReportService) { }

  ngOnInit(): void {
    this.reportService.getHistoryForPatient(this.tokenStorage.getUser().id).subscribe(data=> {
      this.allUsersAppointments = data;
      console.log(data);
      this.allUsersAppointments.map((el) => {
        this.startHour = el.startTime[3];
        this.startMinute = el.startTime[4];
        this.endHour = el.endTime[3];
        this.endMinute = el.endTime[4];
        if(this.startHour <= this.endHour) {
          this.durationHour = this.endHour - this.startHour;
          this.durationMinute = this.endMinute - this.startMinute;
          if(this.durationHour >= 1) {
            this.duration.push(this.durationHour + this.durationMinute);
          } else {
            this.duration.push(this.durationMinute);
          }
        }
      });
      console.log(this.duration);
    });
  }

  allDirections: any[] = [
    {value: 'ascending', viewValue: 'ascending'},
    {value: 'descending', viewValue: 'descending'}
  ];

  public sortByDate(value: string) {
    if (value === 'ascending') {
      this.allUsersAppointments.sort((a,b) => a.startTime > b.startTime ? 1 : -1);
    } else if (value === 'descending') {
      this.allUsersAppointments.sort((a,b) => a.startTime < b.startTime ? 1 : -1);
    }
  }

  public sortByDuration(value: string) {
    if (value === 'ascending') {
      this.allUsersAppointments.sort((a,b) => a.duration > b.duration ? 1 : -1);
    } else if (value === 'descending') {
      this.allUsersAppointments.sort((a,b) => a.duration < b.duration ? 1 : -1);
    }
  }

}
