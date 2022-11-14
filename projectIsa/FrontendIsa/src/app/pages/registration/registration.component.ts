import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthServiceService } from 'src/app/services/auth-service.service';

interface Gender {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  validateForm!: FormGroup;
  name: string = "";
  surname: string = "";
  email: string = "";
  password: string = "";
  confirmPassword: string = "";
  phoneNumber : string = "";
  jmbg : string = "";
  street: string = "";
  houseNumber: string = "";
  city: string = "";
  state: string = "";
  postcode: string = "";
  education: string = "";
  profession: string = "";  

  selectedValueGender = 'MALE';

  genders: Gender[] = [
    {value: 'MALE', viewValue: 'MALE'},
    {value: 'FEMALE', viewValue: 'FEMALE'},
    {value: 'NONBINARY', viewValue: 'NONBINARY'},
    {value: 'OTHER', viewValue: 'OTHER'}
  ];

  hide: boolean = true;
  hideRp: boolean = true;

  constructor(private fb: FormBuilder, private authService : AuthServiceService) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: [null,[Validators.required]],
      surname: [null,[Validators.required]],
      email: [null,[Validators.required]],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]],
      phoneNumber: [null,[Validators.required]],
      jmbg: [null,[Validators.required]],
      gender: [null,[Validators.required]],
      street: [null,[Validators.required]],
      houseNumber: [null,[Validators.required]],
      city: [null,[Validators.required]],
      state: [null,[Validators.required]],
      postcode: [null,[Validators.required]],
      education: [null,[Validators.required]],
      profession: [null,[Validators.required]],
    });
  }

  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.validateForm.controls['password'].value) {
      return { confirm: true, error: true };
    }
    return {};
  };

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
    
    const body = {
      name: this.validateForm.value.name,
      surname: this.validateForm.value.surname,
      email: this.validateForm.value.email,
      password: this.validateForm.value.password,
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
      console.log(body);
      this.authService.registration(body).subscribe(data => {
        console.log(data);
        if(data)
          alert("Successfully registered!");
        else
          alert("Something went wrong!");
      });
    }
  }

