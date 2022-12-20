import { ChangeDetectorRef, Component, EventEmitter, OnInit, TemplateRef } from '@angular/core';
import { MatCalendar } from '@angular/material/datepicker';
import { Router } from '@angular/router';
import { CalendarEvent, CalendarEventTitleFormatter } from 'angular-calendar';
import { WeekViewHourSegment } from 'calendar-utils';
import { addDays, addMinutes, endOfWeek } from 'date-fns';
import { fromEvent, finalize, takeUntil } from 'rxjs';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { ProfileService } from 'src/app/services/profile.service';
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
  events: CalendarEvent[] = [];
  appointmentsFree : any = [];
  appointmentsAllFree : any = [];
  hourSegmentClicked!: EventEmitter<{
    date: Date;
    sourceEvent: MouseEvent;
}>;
eventClicked!: EventEmitter<{
  event: CalendarEvent;
  sourceEvent: MouseEvent | KeyboardEvent;
}>;
  constructor( private appointmentsService: AppointmentsService,private tokenStorage: TokenStorageService, private profileService: ProfileService, private router: Router) {}

  ngOnInit(): void {
    this.getAppointments();
    this.getFreeAppointments();
  
  }

  public getAppointments(){
    this.appointmentsService.getTakenAppointments(this.tokenStorage.getUser().id).subscribe(data => {
      this.appointmentsFree = data;
      console.log(this.appointmentsFree)
      this.mapAppointmentsToEvent(data);
    });
  }

  public getFreeAppointments(){
    this.appointmentsService.getFreeAppointment(this.tokenStorage.getUser().id).subscribe(data => {
      this.appointmentsFree = data;
      //console.log('freeAppointments', this.appointmentsAllFree)
      this.mapFreeAppointmentsToEvent(data);
    });
  }
  
  public mapAppointmentsToEvent(appointments: any){
    for(let appointment of appointments){
      let startDate = new Date();
      startDate.setFullYear(Number(appointment.date[0]));
      startDate.setMonth(Number(appointment.date[1]-1));
      startDate.setDate(appointment.date[2]);
      startDate.setHours(Number(appointment.date[3]));
      startDate.setMinutes(Number(appointment.date[4]));
      var endDate = new Date(startDate);
      endDate.setMinutes(startDate.getMinutes()+appointment.duration)
      this.events.push({
        start:  startDate,
        title: appointment.userName+ " "+ appointment.userSurname+ " "+startDate.getHours()
        +":"+startDate.getMinutes()+this.makeMinutesNicer(startDate)
        +"-"+endDate.getHours()+":"+endDate.getMinutes()+this.makeMinutesNicer(endDate), 
        end: endDate,
        color: {primary:'Gray',secondary:'#FF9696', secondaryText: 'White'},
        id: appointment.id,
        cssClass: appointment.email
      })
    }
  }

  public mapFreeAppointmentsToEvent(appointments: any){
    for(let appointment of appointments){
      let startDate = new Date();
      startDate.setFullYear(Number(appointment.date[0]));
      startDate.setMonth(Number(appointment.date[1]-1));
      startDate.setDate(appointment.date[2]);
      startDate.setHours(Number(appointment.date[3]));
      startDate.setMinutes(Number(appointment.date[4]));
      var endDate = new Date(startDate);
      endDate.setMinutes(startDate.getMinutes()+appointment.duration)
      this.events.push({
        start:  startDate,
        title: startDate.getHours()
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
  public monthBefore(){
    this.viewDate = new Date(this.viewDate.setMonth(this.viewDate.getMonth() - 1));
  }
  public monthAfter(){
    this.viewDate = new Date(this.viewDate.setMonth(this.viewDate.getMonth() + 1));
  }
  public yearBefore(){
    this.viewDate = new Date(this.viewDate.setFullYear(this.viewDate.getFullYear() - 1));
  }
  public yearAfter(){
    this.viewDate = new Date(this.viewDate.setFullYear(this.viewDate.getFullYear() + 1));
  }

  click($event: { event: CalendarEvent<any>; sourceEvent: MouseEvent|KeyboardEvent; }) {
    this.profileService.getProfile($event.event.cssClass).subscribe(data=>{
      const navigationDetails: string[] = ['/patientSurveyReportOverview'];
      const $param = data.id;
      const $param1 = $event.event.id;
   
      if($param && $param1){
        navigationDetails.push($param.toString());
        navigationDetails.push($param1.toString());
      }

      this.router.navigate(navigationDetails);
    })
  }
  
}
