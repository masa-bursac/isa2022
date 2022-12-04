import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProfileService } from 'src/app/services/profile.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  validateForm!: FormGroup;
  public username: any;
  public id!: number;
  hide: boolean = true;
  hideRp: boolean = true;
  passwordBoolean: boolean = false;

  constructor(private fb: FormBuilder, private profileService: ProfileService, private tokenStorage: TokenStorageService,
    private router: Router) { }

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

    console.log(this.tokenStorage.getUser().email)
    
    const body = {
          id: this.tokenStorage.getUser().id,
          password: this.validateForm.value.password,
        }
    this.profileService.changeSystemAdminPassword(body).subscribe((data: any) => {
      alert("Password changed sucessfully!");
      
      this.tokenStorage.signOut();
      this.router.navigate(['/landingPage']);
    })
  }

}


