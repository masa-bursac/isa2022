import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as moment from 'moment';
import { ReportService } from 'src/app/services/report.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-history-of-appointments',
  templateUrl: './history-of-appointments.component.html',
  styleUrls: ['./history-of-appointments.component.css']
})
export class HistoryOfAppointmentsComponent implements OnInit {

  public allUsersAppointments: any[] = [];
  public duration: any[] = [];

  constructor(private router: Router, private tokenStorage: TokenStorageService, private reportService: ReportService) { }

  ngOnInit(): void {
    this.reportService.getHistoryForPatient(this.tokenStorage.getUser().id).subscribe(data=> {
      this.allUsersAppointments = data;
      this.allUsersAppointments.map((el) => {
        const format = "YYYY-MM-DDTHH:mm:ss";
        var start = moment(el.startTime, format);
        var end = moment(el.endTime, format);
        this.duration.push(moment.duration(end.diff(start)).asMinutes());
        //.duration = moment(el.endTime, format).diff(moment(el.startTime, format));
      });
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
