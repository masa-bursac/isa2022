import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ProfileService } from 'src/app/profile.service';

interface Gender {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  validateForm = new FormGroup({
    name: new FormControl(),
    surname: new FormControl(),
    email: new FormControl(),
    phoneNumber : new FormControl(),
    jmbg : new FormControl(),
    gender: new FormControl(),
    street: new FormControl(),
    houseNumber: new FormControl(),
    city: new FormControl(),
    state: new FormControl(),
    postcode: new FormControl(),
    education: new FormControl(),
    profession: new FormControl(),  
  }); 

  selectedValueGender = 'MALE';

  genders: Gender[] = [
    {value: 'MALE', viewValue: 'MALE'},
    {value: 'FEMALE', viewValue: 'FEMALE'},
    {value: 'NONBINARY', viewValue: 'NONBINARY'},
    {value: 'OTHER', viewValue: 'OTHER'}
  ];


  constructor(private fb: FormBuilder, private profileService : ProfileService) { }

  ngOnInit(): void {
    //this.decoded_token = this.authService.getDataFromToken();
    this.profileService.getProfile('vlada@gmail.com').subscribe(data=> {
      this.validateForm = this.fb.group({
        name: [data.name,[Validators.required]],
        surname: [data.surname,[Validators.required]],
        email: [data.email,[Validators.required]],
        phoneNumber : [data.phoneNumber,[Validators.required]],
        jmbg: [data.jmbg,[Validators.required]],
        gender: [data.gender,[Validators.required]],
        street: [data.street,[Validators.required]],
        houseNumber: [data.houseNumber,[Validators.required]],
        city: [data.city,[Validators.required]],
        state: [data.state,[Validators.required]],
        postcode: [data.postcode,[Validators.required]],
        education: [data.education,[Validators.required]],
        profession: [data.profession,[Validators.required]],
      });
      this.selectedValueGender = data.gender;
    });

  }

  submitForm(): void {}

}
