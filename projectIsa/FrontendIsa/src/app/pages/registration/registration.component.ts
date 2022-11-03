import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { RegistrationDTO } from './registrtion.dto';

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
  phoneNumber : string = "";
  jmbg : string = "";
  selectedValueGender = "Male";
  street: string = "";
  houseNumber: number = 0;
  city: string = "";
  state: string = "";
  postcode: string = "";
  education: string = "";
  profession: string = "";

  hide: boolean = true;
  hideRp: boolean = true;

  public register: RegistrationDTO = new RegistrationDTO();

  constructor(private fb: FormBuilder, private authService : AuthServiceService, private router: Router) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null,[Validators.email, Validators.required]],
      name: [null, [Validators.required]],
      surname: [null, [Validators.required]],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required, this.confirmationValidator]],
      phoneNumber: [null, [Validators.required]],
      jmbg: [null, [Validators.required]],
      street: [null, [Validators.required]], 
      houseNumber: [null, [Validators.required]],
      city: [null, [Validators.required]],
      state: [null, [Validators.required]],
      postcode: [null, [Validators.required]],
      education: [null, [Validators.required]],
      profession: [null, [Validators.required]],
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
    this.register.Name = this.validateForm.value.name;
    this.register.Surname = this.validateForm.value.surname;
    this.register.Email = this.validateForm.value.email;
    this.register.Password = this.validateForm.value.password;
    this.register.CheckPassword = this.validateForm.value.confirmPassword;
    this.register.PhoneNumber = this.validateForm.value.phoneNumber;
    this.register.Jmbg = this.validateForm.value.jmbg;
    this.register.Street = this.validateForm.value.street;
    this.register.HouseNumber = this.validateForm.value.houseNumber;
    this.register.City = this.validateForm.value.city;
    this.register.State = this.validateForm.value.state;
    this.register.Postcode = this.validateForm.value.postcode;
    this.register.Education = this.validateForm.value.education;
    this.register.Profession = this.validateForm.value.profession;
    this.register.Gender = this.selectedValueGender;

    if(this.validateForm.valid){
      this.authService.registration(this.register).subscribe(data => {
        console.log(data);
        console.log(this.register);
        localStorage.setItem('Role', JSON.stringify(this.register.Role)); 
          alert("Registration successfull");
          this.router.navigate(['userProfile']);
      }, error => {
        console.log(error.status);
        if(error.status == 409){
          alert("Email already exists");
        }
      });
    }
  }

}
