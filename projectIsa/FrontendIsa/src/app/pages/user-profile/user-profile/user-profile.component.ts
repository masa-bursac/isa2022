import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AppointmentsService } from 'src/app/services/appointments.service';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ProfileService } from 'src/app/services/profile.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

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
    phoneNumber: new FormControl(),
    jmbg: new FormControl(),
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
    { value: 'MALE', viewValue: 'MALE' },
    { value: 'FEMALE', viewValue: 'FEMALE' },
    { value: 'NONBINARY', viewValue: 'NONBINARY' },
    { value: 'OTHER', viewValue: 'OTHER' }
  ];

  public allUsersAppointments: any[] = [];

  penals: number = 0;

  constructor(private fb: FormBuilder, private _snackBar: MatSnackBar, private profileService: ProfileService, private router: Router, private tokenStorage: TokenStorageService, private appointmentService: AppointmentsService, private authService: AuthServiceService) { }

  ngOnInit(): void {
    if (Object.keys(this.tokenStorage.getUser()).length === 0) {
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    } else if (this.tokenStorage.getUser().roles[0] !== "ROLE_REGISTERED") {
      alert("Unauthorized!");
      this.router.navigate(['/homePage']);
    }

    this.profileService.getProfile(this.tokenStorage.getUser().email).subscribe(data => {
      this.validateForm = this.fb.group({
        name: [data.name, [Validators.required, Validators.pattern(/^[A-Z][A-Za-z\s]{1,25}$/)]],
        surname: [data.surname, [Validators.required, Validators.pattern(/^[A-Z][A-Za-z\s]{1,25}$/)]],
        email: [data.email, [Validators.required]],
        phoneNumber: [data.phoneNumber, [Validators.required, Validators.pattern(/^(\s*[0-9]+)+$/)]],
        jmbg: [data.jmbg, [Validators.required, Validators.pattern(/^[0-9]{13,13}$/)]],
        gender: [data.gender, [Validators.required]],
        street: [data.street, [Validators.required, Validators.pattern(/^[A-Z][A-Za-z\s]*$/)]],
        houseNumber: [data.houseNumber, [Validators.required, Validators.pattern(/^[A-Za-z0-9]*$/)]],
        city: [data.city, [Validators.required, Validators.pattern(/^[A-Z][A-Za-z\s]*$/)]],
        state: [data.state, [Validators.required, Validators.pattern(/^[A-Z][A-Za-z\s]*$/)]],
        postcode: [data.postcode, [Validators.required, Validators.pattern(/^[0-9]{1,13}$/)]],
        education: [data.education, [Validators.required, Validators.pattern(/^(?:[A-Za-z]+)(?:[A-Za-z0-9 _]*)$/)]],
        profession: [data.profession, [Validators.required, Validators.pattern(/^(?:[A-Za-z]+)(?:[A-Za-z0-9 _]*)$/)]],
      });
      this.selectedValueGender = data.gender;
    });

    this.appointmentService.getUsersAppointment(this.tokenStorage.getUser().id).subscribe(data => {
      this.allUsersAppointments = data;
    });

    this.authService.getPenals(this.tokenStorage.getUser().id).subscribe(data => {
      this.penals = data;
    });

  }

  public cancelAppointment(appointmentId: number): void {
    this.appointmentService.cancelAppointment(appointmentId).subscribe(data => {
      if (data === true) {
        this._snackBar.open("Appointment successfully canceled!", 'Close', {
          duration: 5000
        });
        window.location.reload();
      } else {
        this._snackBar.open("Appointment can be canceled minimum 24 hours before appointment starts!", 'Close', {
          duration: 5000
        });
      }
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
        if (data)
          alert("Profile successfully edited");
        else
          alert("Something went wrong");
      });
    } else {
      alert('Form is not valid');
    }
  }

}
