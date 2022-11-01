import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ProfileService } from 'src/app/services/profile.service';

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
        name: [data.name,[Validators.required, Validators.pattern(/^[A-Z][a-z]{1,15}$/)]],
        surname: [data.surname,[Validators.required, Validators.pattern(/^[A-Z][a-z]{1,15}$/)]],
        email: [data.email,[Validators.required]],
        phoneNumber : [data.phoneNumber,[Validators.required]],
        jmbg: [data.jmbg,[Validators.required, Validators.pattern(/^[0-9]{13,13}$/)]],
        gender: [data.gender,[Validators.required]],
        street: [data.street,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
        houseNumber: [data.houseNumber,[Validators.required, Validators.pattern(/^[A-Za-z0-9]*$/)]],
        city: [data.city,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
        state: [data.state,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
        postcode: [data.postcode,[Validators.required, Validators.pattern(/^[0-9]{1,13}$/)]],
        education: [data.education,[Validators.required]],
        profession: [data.profession,[Validators.required]],
      });
      this.selectedValueGender = data.gender;
    });

  }

  submitForm(): void {
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
  }

}
