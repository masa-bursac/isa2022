import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

interface Gender {
  value: string;
}

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  validateForm!: FormGroup;
  email: string = "";
  name: string = "";
  surname : string = "";
  password : string = "";
  confirmPassword : string = "";
  phone : string = "";
  address : string = "";
  jmbg : string = "";
  selectedValueGender = "Male";
  job: string = "";
  company: string = "";

  hide: boolean = true;
  hideRp: boolean = true;

  constructor(private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null,[Validators.required]],
      name: [null, [Validators.required]],
      surname: [null, [Validators.required]],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]],
      phone: [null, [Validators.required]],
      address: [null, [Validators.required]],
      jmbg: [null, [Validators.required]],
      job: [null, [Validators.required]],
      company: [null, [Validators.required]]
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

  genders: Gender[] = [
    {value: 'Male'},
    {value: 'Female'}
  ];

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
    this.name = this.validateForm.value.name;
    this.surname = this.validateForm.value.surname;
    this.email = this.validateForm.value.email;
    this.password = this.validateForm.value.password;
    this.phone = this.validateForm.value.phone;
    this.jmbg = this.validateForm.value.jmbg;
    this.job = this.validateForm.value.job;
    this.company = this.validateForm.value.company;
    this.address = this.validateForm.value.address;
  }

}
