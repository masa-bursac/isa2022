import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-change-center-admin-password',
  templateUrl: './change-center-admin-password.component.html',
  styleUrls: ['./change-center-admin-password.component.css']
})
export class ChangeCenterAdminPasswordComponent implements OnInit {

  validateForm!: FormGroup;
  public username: any;
  public id!: number;
  hide: boolean = true;
  hideRp: boolean = true;
  passwordBoolean: boolean = false;

  constructor(private fb: FormBuilder, private profileService: ProfileService) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      password: [null, [Validators.required]],
      rePassword: [null, [Validators.required, this.confirmationValidator]]
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
    //this.username = this.route.snapshot.params.token;
    this.profileService.getProfile('mila@gmail.com').subscribe(data=>{
      this.id = data.id;
      for (const i in this.validateForm.controls) {
        this.validateForm.controls[i].markAsDirty();
        this.validateForm.controls[i].updateValueAndValidity();
      }
    
      const body = {
            id: this.id,
            password: this.validateForm.value.password,
          }
      this.profileService.changeCenterAdminPassword(body).subscribe((data: any) => {
        alert("Password changed sucessfully!");
      })
    });
  }
  

}
