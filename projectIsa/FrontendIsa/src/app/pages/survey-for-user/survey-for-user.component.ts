import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatRadioChange } from '@angular/material/radio';
import { Router } from '@angular/router';
import { ProfileService } from 'src/app/services/profile.service';
import { SurveyService } from 'src/app/services/survey.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

interface Gender {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-survey-for-user',
  templateUrl: './survey-for-user.component.html',
  styleUrls: ['./survey-for-user.component.css']
})
export class SurveyForUserComponent implements OnInit {
  displayedColumns: string[] = ['id', 'question', 'answers'];
  public dataSource: any[] = [];
  validateForm = new FormGroup({
    name: new FormControl(),
    surname: new FormControl(),
    email: new FormControl(),
    phoneNumber : new FormControl(),
    jmbg : new FormControl(),
    gender: new FormControl(),
    street: new FormControl(),
    houseNumber: new FormControl(),
    city: new FormControl(),
    state: new FormControl(),
    postcode: new FormControl(),
    education: new FormControl(),
    profession: new FormControl()
  }); 

  selectedValueGender = 'MALE';

  genders: Gender[] = [
    {value: 'MALE', viewValue: 'MALE'},
    {value: 'FEMALE', viewValue: 'FEMALE'},
    {value: 'NONBINARY', viewValue: 'NONBINARY'},
    {value: 'OTHER', viewValue: 'OTHER'}
  ];

  finalArray: any[] = [];
  answeredArray: any[] = [];

  constructor(private fb: FormBuilder, private profileService : ProfileService, private surveyService : SurveyService, private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }else if(this.tokenStorage.getUser().roles[0] !== "ROLE_REGISTERED"){
      alert("Unauthorized!");
      this.router.navigate(['/homePage']);
    }

    this.profileService.getProfile(this.tokenStorage.getUser().email).subscribe(data=> {
      this.validateForm = this.fb.group({
        name: [data.name,[Validators.required, Validators.pattern(/^[A-Z][a-z]{1,15}$/)]],
        surname: [data.surname,[Validators.required, Validators.pattern(/^[A-Z][a-z]{1,15}$/)]],
        email: [data.email,[Validators.required]],
        phoneNumber : [data.phoneNumber,[Validators.required]],
        jmbg: [data.jmbg,[Validators.required, Validators.pattern(/^[0-9]{13,13}$/)]],
        gender: [data.gender,[Validators.required]],
        street: [data.street,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
        houseNumber: [data.houseNumber,[Validators.required, Validators.pattern(/^[A-Za-z0-9]*$/)]],
        city: [data.city,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
        state: [data.state,[Validators.required, Validators.pattern(/^[A-Za-z\s]*$/)]],
        postcode: [data.postcode,[Validators.required, Validators.pattern(/^[0-9]{1,13}$/)]],
        education: [data.education,[Validators.required]],
        profession: [data.profession,[Validators.required]]
      });
      this.selectedValueGender = data.gender;
    });

    this.surveyService.GetQuestions().subscribe((data: any)=>{
      this.dataSource = data;
    });
  }

  radioChange(event: MatRadioChange, data: { id: any; }) {
    var obj = this.dataSource.filter(x => x.id == data.id)[0];
    obj.selected = event.value;
    if (!this.finalArray.some(x => x.id == data.id)) {
      this.finalArray.push(obj);
    }
  }

  submitForm(): void {
   for(let i=0; i<this.dataSource.length; i++){
    for(let j=0; j<this.finalArray.length; j++){
      if(this.dataSource[i].id === this.finalArray[j].id){
        var newobj = {id: this.finalArray[j].id, answers: this.finalArray[j].selected, surveyId: this.dataSource[i].id, regUserId: this.tokenStorage.getUser().id};
        this.answeredArray.push(newobj);
      }
    }
   }
   this.surveyService.AddAnswers(this.answeredArray).subscribe((data: any) => {
    if(data){
      alert("Survey sent!");
    }
    else
      alert("Something went wrong!");
   });
  }
}
