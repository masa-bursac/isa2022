import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { ReportService } from 'src/app/services/report.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';


interface BloodType {
  value: string;
  viewValue: string;
}

interface Place {
  value: string;
  viewValue: string;
}

interface level{
  value: boolean;
  viewValue: string;
}

interface hour {
  id?: number,
  name?: string
}

interface minute {
  id?: number,
  name?: string
}


@Component({
  selector: 'app-add-report',
  templateUrl: './add-report.component.html',
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent implements OnInit {

  bloodTypes: BloodType[] = [
    {value: '0', viewValue: 'A'},
    {value: '1', viewValue: 'B'},
    {value: '2', viewValue: 'O'},
    {value: '3', viewValue: 'AB'}
  ];

  places: Place[] = [
    {value: 'R', viewValue: 'Right arm'},
    {value: 'L', viewValue: 'Left arm'},
  ];

  levels: level[] = [
    {value: true, viewValue: "Normal"},
    {value: false, viewValue: 'Lower than normal'},
  ];


  hoursStart : hour[] = [{id: 1, name:"08"},
  {id: 2, name:"09"},
  {id: 3, name:"10"},
  {id: 4, name:"11"},
  {id: 5, name:"12"},
  {id: 6, name:"13"},
  {id: 7, name:"14"},
  {id: 8, name:"15"},
  {id: 9, name:"16"}];

  hoursEnd : hour[] = [{id: 1, name:"08"},
  {id: 2, name:"09"},
  {id: 3, name:"10"},
  {id: 4, name:"11"},
  {id: 5, name:"12"},
  {id: 6, name:"13"},
  {id: 7, name:"14"},
  {id: 8, name:"15"},
  {id: 9, name:"16"}];

  minutesStart : minute[] = [{id: 1, name:"00"},
  {id: 2, name:"10"},
  {id: 3, name:"20"},
  {id: 4, name:"30"},
  {id: 5, name:"40"},
  {id: 6, name:"50"}];

  minutesEnd : minute[] = [{id: 1, name:"00"},
  {id: 2, name:"10"},
  {id: 3, name:"20"},
  {id: 4, name:"30"},
  {id: 5, name:"40"},
  {id: 6, name:"50"}];

  selectedHourStart?: hour;
  selectedHourEnd?: hour;
  selectedMinuteStart?: minute;
  selectedMinuteEnd?: minute;
  selectedLevel?: any;
  quantityTaken?: number;
  accepted: boolean = false;

  id: any;//patientid
  ap: any;//appointmentid
  dataApp: any;
  dateEnd!: Date;


  validateForm = new FormGroup({
    bloodType: new FormControl(),
    noteToDoctor: new FormControl(),
    bakar: new FormControl(),
    bagNumber: new FormControl(),
    puncturePlace: new FormControl(),
    reasonForEndingEarly: new FormControl(),
    quantityTaken: new FormControl(),
    bloodPressure: new FormControl(),
    patientWeight: new FormControl(),
    pulse: new FormControl(),
    lungs: new FormControl(),
    reasonForRejection: new FormControl(),
    levelHem: new FormControl(),
    dateStart: new FormControl()
  }); 

  constructor(private fb: FormBuilder, private _snackBar: MatSnackBar, private reportService: ReportService, private appointmentService: AppointmentsService,
    private router: Router, private tokenStorage: TokenStorageService, private route: ActivatedRoute) { }

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

  
  }
  submitForm(): void {
    this.quantityTaken = this.validateForm.value.quantityTaken;
    if(this.quantityTaken == null){
      this.quantityTaken = 0;
    }
    if((this.validateForm.value.reasonForRejection == ("/"))|| (this.validateForm.value.reasonForRejection == null)){
      this.accepted = true;
    }
    if(this.accepted == false){
      const bodyPatient = {
        id: this.ap, 
        patientStatus: 1, //not able
        patientId: this.id 
      }
      console.log(bodyPatient)
      this.appointmentService.setPatientStatus(bodyPatient).subscribe(data=>{});
    }

 this.appointmentService.findAppointmentById(this.ap).subscribe(data=>{
  const format = "yyyy-MM-ddTHH:mm:ss";
  this.dataApp = data;
  const date = this.dataApp.date[0]+","+this.dataApp.date[1]+","+this.dataApp.date[2];
  const dateStart =  new Date(date);
  const dateEnd = new Date(date);

  switch ( this.selectedHourEnd ) {
    case "08":
     dateEnd.setHours(8);
        break;
    case "09":
     dateEnd.setHours(9);
        break;
    case "10":
     dateEnd.setHours(10);
          break;
    case "11":
     dateEnd.setHours(11);
          break;
    case "12":
     dateEnd.setHours(12);
          break;
    case "13":
     dateEnd.setHours(13);
          break;
    case "14":
     dateEnd.setHours(14);
          break;
    case "15":
     dateEnd.setHours(15);
          break;
    case "16":
     dateEnd.setHours(16);
          break;
    default: 
          break;
  }
  switch ( this.selectedMinuteEnd ) {
  case "00":
   dateEnd.setMinutes(0);
      break;
  case "10":
   dateEnd.setMinutes(10);
      break;
  case "20":
   dateEnd.setMinutes(20);
        break;
  case "30":
   dateEnd.setMinutes(30);
        break;
  case "40":
   dateEnd.setMinutes(40);
        break;
  case "50":
   dateEnd.setMinutes(50);
        break;
  default: 
        break;
  }

  switch ( this.selectedHourStart ) {
    case "08":
      dateStart.setHours(8);
        break;
    case "09":
      dateStart.setHours(9);
        break;
    case "10":
      dateStart.setHours(10);
          break;
    case "11":
      dateStart.setHours(11);
          break;
    case "12":
      dateStart.setHours(12);
          break;
    case "13":
      dateStart.setHours(13);
          break;
    case "14":
      dateStart.setHours(14);
          break;
    case "15":
      dateStart.setHours(15);
          break;
    case "16":
      dateStart.setHours(16);
          break;
    default: 
          break;
 }
 switch ( this.selectedMinuteStart ) {
  case "00":
    dateStart.setMinutes(0);
      break;
  case "10":
    dateStart.setMinutes(10);
      break;
  case "20":
    dateStart.setMinutes(20);
        break;
  case "30":
    dateStart.setMinutes(30);
        break;
  case "40":
    dateStart.setMinutes(40);
        break;
  case "50":
    dateStart.setMinutes(50);
        break;
  default: 
        break;
}
  
     const body = {
       patientId: this.id,
       doctorId: this.tokenStorage.getUser().id,
       bloodType: this.validateForm.value.bloodType,
       noteToDoctor: this.validateForm.value.noteToDoctor,
       bakarSulfatLevel: this.validateForm.value.bakar,
       bagNumber: this.validateForm.value.bagNumber,
       puncturePlace: this.validateForm.value.puncturePlace,
       reasonForEndingEarly: this.validateForm.value.reasonForEndingEarly,
       quantityTaken: this.quantityTaken,
       bloodPressure: this.validateForm.value.bloodPressure,
       patientWeight: this.validateForm.value.patientWeight,
       pulse: this.validateForm.value.pulse,
       lungs: this.validateForm.value.lungs,
       reasonForRejection: this.validateForm.value.reasonForRejection,
       accepted: this.accepted, 
       levelHem: this.validateForm.value.levelHem,
       startTime: formatDate(dateStart,format, "en-US"),
       endTime: formatDate(dateEnd,format, "en-US")
     }
     console.log(body)
     if(this.validateForm.valid){
      this.reportService.addReport(body).subscribe(data=>{
          this._snackBar.open('Report added successfully', 'Close',{
            duration: 3000
          });
          this.router.navigate(['/landingPage']);
      });
      
   }
   else{
    this._snackBar.open('Error! All feilds are required!', 'Close',{
      duration: 3000
    });
   }
     

})


  }
}