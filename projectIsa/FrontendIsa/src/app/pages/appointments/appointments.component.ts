import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CalendarEvent, CalendarEventTitleFormatter } from 'angular-calendar';
import { WeekViewHourSegment } from 'calendar-utils';
import { addDays, addMinutes, endOfWeek } from 'date-fns';
import { fromEvent, finalize, takeUntil } from 'rxjs';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';


@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {

  optionView : string = "weekly";
  viewDate : Date = new Date();
  weekStartsOn: 1 = 1;
  dayStartsHour: 7 = 7;
  dayEndsHour: 19 = 19;
  daysExcluded : any[]= [0,6];
  dragToCreateActive = false;
  events: CalendarEvent[] = [];
  appointmentsFree : any = [];
  days: any[] = [];
  slots: any[] = [];
  constructor(private cdr: ChangeDetectorRef, private appointmentsService: AppointmentsService,
    private tokenStorage: TokenStorageService) {}

  ngOnInit(): void {
    this.getAppointments();
  }

  public getAppointments(){
    
    this.appointmentsService.getTakenAppointments(this.tokenStorage.getUser().id).subscribe(data => {
      this.appointmentsFree = data;
      console.log(this.appointmentsFree)
      this.mapAppointmentsToEvent(data);
    });
  }
  initDays() {
    
  }
  public mapAppointmentsToEvent(appointments: any){
    for(let appointment of appointments){
      console.log(appointment.date);
      let startDate = new Date();
      startDate.setFullYear(Number(appointment.date[0]));
      startDate.setMonth(Number(appointment.date[1]-1));
      startDate.setDate(appointment.date[2]);
      startDate.setHours(Number(appointment.date[3]));
      startDate.setMinutes(Number(appointment.date[4]));

      var endDate = new Date(startDate);
      endDate.setMinutes(startDate.getMinutes()+appointment.duration)
      console.log(endDate)

      this.events.push({
        start:  startDate,
        title: appointment.userName+ " "+ appointment.userSurname+ " "+startDate.getHours()
        +":"+startDate.getMinutes()+this.makeMinutesNicer(startDate)
        +"-"+endDate.getHours()+":"+endDate.getMinutes()+this.makeMinutesNicer(endDate),
        
        end: endDate,
        color: {primary:'Gray',secondary:'#FF9696', secondaryText: 'White'}
      })
    }
  }
  makeMinutesNicer(date: any){
    if(date.getMinutes()<10)
      return '0';
      else{
        return '';
      }
  }
  public weekBefore(){
    this.viewDate = new Date(this.viewDate.setDate(this.viewDate.getDate() - 7));
  }
  public weekAfter(){
    this.viewDate = new Date(this.viewDate.setDate(this.viewDate.getDate() + 7));
  }


}
