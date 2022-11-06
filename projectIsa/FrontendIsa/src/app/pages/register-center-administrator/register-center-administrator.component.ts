import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-center-administrator',
  templateUrl: './register-center-administrator.component.html',
  styleUrls: ['./register-center-administrator.component.css']
})
export class RegisterCenterAdministratorComponent implements OnInit {

  validateForm!: FormGroup;

  @Output()
  onClose: EventEmitter<any> = new EventEmitter();

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: ["", [Validators.required]],
      surname: ["", [Validators.required]],
      email: ["", [Validators.required]],
      jmbg: ["", [Validators.required]],
      phoneNumber: ["", [Validators.required]],
      password: ["", [Validators.required]],
      repeatPassword: ["", [Validators.required]],
      street: ["", [Validators.required]],
      houseNumber: ["", [Validators.required]],
      city: ["", [Validators.required]],
      state: ["", [Validators.required]],
      postcode: ["", [Validators.required]],
      gender: ["", [Validators.required]],
      education: ["", [Validators.required]],
      profession: ["", [Validators.required]],
    });
  }
  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
    const admin = {
      id: 1,
      name : this.validateForm.value.name,
      surname : this.validateForm.value.surname,
      email : this.validateForm.value.email,
      jmbg : this.validateForm.value.jmbg,
      phoneNumber : this.validateForm.value.phoneNumber,
      password : this.validateForm.value.password,
      gender : this.validateForm.value.gender,
      education : this.validateForm.value.education,
      profession : this.validateForm.value.profession,

      street : this.validateForm.value.street,
      houseNumber : this.validateForm.value.houseNumber,
      city : this.validateForm.value.city,
      state : this.validateForm.value.state,
      postcode : this.validateForm.value.postcode
    }
    if(this.validateForm.valid){
      this.onClose.emit(admin);
    }
  }

}
