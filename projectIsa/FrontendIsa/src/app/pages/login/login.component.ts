import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  validateForm!: FormGroup;
  email: any;
  password: any;

  hide: boolean = true;

  isLoggedIn = false;

  constructor(private authService: AuthServiceService, private route: ActivatedRoute, private fb: FormBuilder, private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });

    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }

    const token = this.route.snapshot.params['token'];
    console.log(token);
    if (token != undefined) {
      console.log('yes');
      this.authService.continueRegistration(token).subscribe(() => {
        this.router.navigateByUrl(`/login`);
      },
      error => {
      });
    }
  }

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }

    this.authService.login(this.validateForm.value.email, this.validateForm.value.password).subscribe(data => {
      if(data){
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoggedIn = true;
        if(data.hasToChangePass == true){
          this.router.navigate(['/changePassword']);
        }
        else{
        this.router.navigate(['/homePage']);
        }
      }
      else
        alert("Something went wrong!");
    });
  }

}
