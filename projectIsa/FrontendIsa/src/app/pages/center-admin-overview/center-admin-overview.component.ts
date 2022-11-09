import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CenterService } from 'src/app/services/center.service';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-center-admin-overview',
  templateUrl: './center-admin-overview.component.html',
  styleUrls: ['./center-admin-overview.component.css']
})
export class CenterAdminOverviewComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'surname', 'email'];
  dataSource = [];

  adminId : number = 0;

  validateForm = new FormGroup({
    name: new FormControl(),
    street: new FormControl(),
    houseNumber: new FormControl(),
    city: new FormControl(),
    state: new FormControl(),
    postcode: new FormControl(),
    description: new FormControl(),
    rating: new FormControl(),  
  }); 
  
  constructor(private fb: FormBuilder, private centreService : CenterService, private profileService: ProfileService) { }

  ngOnInit(): void {
    //this.decoded_token = this.authService.getDataFromToken();
    this.profileService.getProfile('mila@gmail.com').subscribe(data=>{
      this.adminId = data.id;
      this.centreService.getCenter(this.adminId).subscribe((data : any)=> {
        this.validateForm = this.fb.group({
          name: [data.name,[Validators.required, Validators.pattern(/^[A-Z][a-z]{1,15}$/)]],
          street: [data.centerAddress.street,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
          houseNumber: [data.centerAddress.houseNumber,[Validators.required, Validators.pattern(/^[A-Za-z0-9]*$/)]],
          city: [data.centerAddress.city,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
          state: [data.centerAddress.state,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
          postcode: [data.centerAddress.postcode,[Validators.required, Validators.pattern(/^[0-9]{1,13}$/)]],
          description: [data.description,[Validators.required]],
          rating: [data.rating,[Validators.required]],
        });
        this.dataSource = data.staff;
      });
    })
  }

  /*submitForm(): void {
    this.validateForm.markAllAsTouched();
    if (this.validateForm.valid) {

      const body = {
        name: this.validateForm.value.name,
        surname: this.validateForm.value.surname,
        email: this.validateForm.value.email,
        phoneNumber: this.validateForm.value.phoneNumber,      
        jmbg: this.validateForm.value.jmbg, 
        gender: this.validateForm.value.gender,
        street: this.validateForm.value.street,
        houseNumber: this.validateForm.value.houseNumber,
        city: this.validateForm.value.city,
        state: this.validateForm.value.state,
        postcode: this.validateForm.value.postcode,
        education: this.validateForm.value.education,
        profession: this.validateForm.value.profession
      }

      this.profileService.editProfile(body).subscribe(data => {
        if(data)
          alert("Profile successfully edited");
        else
          alert("Something went wrong");
      });
    } else {
      alert('Form is not valid');
    }
  }*/

}
