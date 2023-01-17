import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CenterService } from 'src/app/services/center.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';


@Component({
  selector: 'app-register-center',
  templateUrl: './register-center.component.html',
  styleUrls: ['./register-center.component.css']
})
export class RegisterCenterComponent implements OnInit {

  displayedColumns: string[] = ['name', 'surname', 'email', 'phoneNumber', 'jmbg'];
  validateForm!: FormGroup;
  showRegisterAdminForm: boolean = false;
  centerAdmins: any[] = [];
  @Output()
  onClose: EventEmitter<boolean> = new EventEmitter();
  
  constructor(private fb: FormBuilder, private centerService: CenterService,
    private _snackBar: MatSnackBar, private router: Router, private tokenStorage: TokenStorageService) { 
    }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }else if(this.tokenStorage.getUser().roles[0] !== "ROLE_SYSTEMADMIN"){
      alert("Unauthorized!");
      this.router.navigate(['/homePage']);
    }
    this.validateForm = this.fb.group({
      name: ["", [Validators.required]],
      description: ["", [Validators.required]],
      street: ["", [Validators.required]],
      houseNumber: ["", [Validators.required]],
      city: ["", [Validators.required]],
      state: ["", [Validators.required]],
      postcode: ["", [Validators.required]]
    });
  }
  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
    const body = {
      id: 1,
      name : this.validateForm.value.name,
      description : this.validateForm.value.description,
      rating: 0,
      street : this.validateForm.value.street,
      houseNumber : this.validateForm.value.houseNumber,
      city : this.validateForm.value.city,
      state : this.validateForm.value.state,
      postcode : this.validateForm.value.postcode,
      centerAdmins: this.centerAdmins
    }
    if(this.validateForm.valid){
      this.centerService.registerCenter(body).subscribe(data => { 
        this._snackBar.open('Center registration successful', 'Close',{
          duration: 3000
        });
        
        this.onClose.emit(true);
      })
    }
  }

  public ShowRegisterAdminForm(): void{
    this.showRegisterAdminForm = !this.showRegisterAdminForm;
  }
  public RegisterAdminClosed(newAdmin: any): void{
    this.centerAdmins.push(newAdmin);
    this.centerAdmins = [...this.centerAdmins];
    this.showRegisterAdminForm = false;
  }
}
