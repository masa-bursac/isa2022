import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

interface Gender {
  value: string;
}

@Component({
  selector: 'app-register-center-administrator',
  templateUrl: './register-center-administrator.component.html',
  styleUrls: ['./register-center-administrator.component.css']
})
export class RegisterCenterAdministratorComponent implements OnInit {

  validateForm!: FormGroup;
  selectedValueGender = "Male";
  hide: boolean = true;
  hideRp: boolean = true; 

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
      repeatPassword: [null, [Validators.required, this.confirmationValidator]],
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
    {value: 'Female'},
    {value: 'Non-Binary'},
  ];
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
      gender: this.selectedValueGender,   
      education : this.validateForm.value.education,
      profession : this.validateForm.value.profession,

      street : this.validateForm.value.street,
      houseNumber : this.validateForm.value.houseNumber,
      city : this.validateForm.value.city,
      state : this.validateForm.value.state,
      postcode : this.validateForm.value.postcode
    }
    console.log("ovde sam")
    this.onClose.emit(admin);
  }

}
