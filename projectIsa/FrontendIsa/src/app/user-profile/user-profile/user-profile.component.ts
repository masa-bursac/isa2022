import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public id!: number;
  public name: string = "";
  public surname: string = "";
  public email: string = "email.com";
  public password: string = "";
  public phoneNumber: string = "";
  //public dateOfBirth = new Date();
  public jmbg: string = "";
  public gender: string = "";
  
  public street: string = "";
  public houseNumber!: number;
  public city: string = "";
  public state: string = "";
  public postcode!: number;

  public education: string = "";
  public profession: string = "";


  constructor() { }

  onSubmit(f: NgForm) {
    console.log(f.value); 
    console.log(f.valid);  
  }

  ngOnInit(): void {
  }

}
