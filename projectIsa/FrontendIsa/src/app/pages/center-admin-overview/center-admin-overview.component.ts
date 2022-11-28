import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { CenterAdminService } from 'src/app/services/center-admin.service';
import { Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';
import { ProfileService } from 'src/app/services/profile.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

interface address {
  street?: string,
  houseNumber?: string,
  city?: string,
  state?: string,
  postcode?: string
}

interface staff {
  id?: number,
  name?: string,
  surname?: string
}

interface hour {
  id?: number,
  name?: string
}

interface minute {
  id?: number,
  name?: string
}

interface duration {
  id?: number,
  name?: string
}

@Component({
  selector: 'app-center-admin-overview',
  templateUrl: './center-admin-overview.component.html',
  styleUrls: ['./center-admin-overview.component.css']
})
export class CenterAdminOverviewComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'surname', 'email'];
  displayedColumns1: string[] = ['id', 'date', 'duration', 'staff'];
  dataSource = [];
  dataSource1= [];
  staffs?: staff[];
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

  adminId : number = 0;
  centerid: number = 0;

  selectedHour?: hour;
  selectedMinute?: minute;

  centerAddress: address = {};

  durations : duration[] = [
    {id: 1, name:"10"},
    {id: 2, name:"20"},
    {id: 2, name:"30"}
  ];
  selectedDuration?: duration;

  validateForm = new FormGroup({
    name: new FormControl(),
    street: new FormControl(),
    houseNumber: new FormControl(),
    city: new FormControl(),
    state: new FormControl(),
    postcode: new FormControl(),
    description: new FormControl(),
    rating: new FormControl()
  }); 

  validateForm1 = new FormGroup({
    durations: new FormControl(),
    date: new FormControl(),
    staff: new FormControl(),
    hours: new FormControl(),
    minutes: new FormControl()
  })
  
  constructor(private fb: FormBuilder,private adminService: CenterAdminService,private _snackBar: MatSnackBar, private centreService : CenterService, private profileService: ProfileService, private appointmentService: AppointmentsService, private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }else if(this.tokenStorage.getUser().roles[0] !== "ROLE_CENTERADMIN"){
      alert("Unauthorized!");
      this.router.navigate(['/homePage']);
    }

    this.profileService.getProfile(this.tokenStorage.getUser().email).subscribe(data=>{
      this.adminId = data.id;
      this.centreService.getCenter(this.adminId).subscribe((data : any)=> {
        this.validateForm = this.fb.group({
          name: [data.name,[Validators.required, Validators.pattern(/^[A-Z\s][A-Za-z\s]*$/)]],
          street: [data.centerAddress.street,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
          houseNumber: [data.centerAddress.houseNumber,[Validators.required, Validators.pattern(/^[A-Za-z0-9]*$/)]],
          city: [data.centerAddress.city,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
          state: [data.centerAddress.state,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
          postcode: [data.centerAddress.postcode,[Validators.required, Validators.pattern(/^[0-9]{1,13}$/)]],
          description: [data.description,[Validators.required]],
          rating: [data.rating,[Validators.required]],
        });
        this.dataSource = data.staff;
        this.appointmentService.getAllCenters(data.id).subscribe((data : any)=> {
          this.dataSource1 = data;
        });
        this.adminService.getAdmins(data.id).subscribe((data : any)=> {
          this.staffs = data;
        });
      });
    })
  }

  submitForm(): void {
    this.centreService.getCenter(this.adminId).subscribe((data : any)=> {
      this.centerid = data.id;
      this.validateForm.markAllAsTouched();
    if (this.validateForm.valid) {

        this.centerAddress.street = this.validateForm.value.street;
        this.centerAddress.houseNumber = this.validateForm.value.houseNumber;
        this.centerAddress.city = this.validateForm.value.city;
        this.centerAddress.state = this.validateForm.value.state;
        this.centerAddress.postcode = this.validateForm.value.postcode;

      const body = {
        name: this.validateForm.value.name,
        centerAddress: this.centerAddress,
        description: this.validateForm.value.description,
        rating: Number(this.validateForm.value.rating),
        id: this.centerid,
      }

      this.centreService.editCenter(body).subscribe((data:any) => {
        if(data)
          alert("Profile successfully edited");
        else
          alert("Something went wrong");
      });
    } else {
      alert('Form is not valid');
    }
  
  });
    
  }
  addAppointment():void{
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

    this.centreService.getCenter(this.adminId).subscribe((data : any)=> {
      const body = {
        centerId: data.id,
        duration: this.validateForm1.value.durations,
        date: formatDate(date,format, "en-US"),
        staffIds: this.validateForm1.value.staff
      }
      if(this.validateForm1.valid){
        this.appointmentService.addAppointment(body).subscribe(data=>{
          if(data.id===null){
            this._snackBar.open('Appointment already exist', 'Close',{
              duration: 3000
            });
          }else {
            this._snackBar.open('Appointment added successfully', 'Close',{
              duration: 3000
            });
            window.location.reload();
          }
        });
     }
     else{
      this._snackBar.open('Error! All feilds are required!', 'Close',{
        duration: 3000
      });
     }
    });
  }
}
