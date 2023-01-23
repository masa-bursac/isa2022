import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileService } from 'src/app/services/profile.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-donors-list',
  templateUrl: './donors-list.component.html',
  styleUrls: ['./donors-list.component.css']
})
export class DonorsListComponent implements OnInit {

  allDirections: any[] = [
    {value: 'ascending', viewValue: 'ascending'},
    {value: 'descending', viewValue: 'descending'},
    {value: 'none', viewValue: 'none'}
  ];
  allCriterias: any[] = [
    {value: 'name', viewValue: 'name'},
    {value: 'surname', viewValue: 'surname'},
    {value: 'date', viewValue: 'date'},
    {value: 'none', viewValue: 'none'}
  ];

  public allDonors: any[] = [];
  public sortByCriteria?: string;

  publ
  role: any;

  public sortBy(value: string) {
    if (value === 'name') {
      this.sortByCriteria = "name";
    } else if (value === 'surname') {
      this.sortByCriteria = "surname";
    }else if (value === 'date') {
      this.sortByCriteria = "date";
    }
  }

  public sort(value: string) {
    if(this.sortByCriteria === "name"){
      if (value === 'ascending') {
        this.allDonors.sort((a,b) => a.name > b.name ? 1 : -1);
      } else if (value === 'descending') {
        this.allDonors.sort((a,b) => a.name < b.name ? 1 : -1);
      }
    }else if(this.sortByCriteria === "surname"){
      if (value === 'ascending') {
        this.allDonors.sort((a,b) => a.surname > b.surname ? 1 : -1);
      } else if (value === 'descending') {
        this.allDonors.sort((a,b) => a.surname < b.surname ? 1 : -1);
      }
    }else if(this.sortByCriteria === "date"){
      if (value === 'ascending') {
        this.allDonors.sort((a,b) => a.gaveBlood > b.gaveBlood ? 1 : -1);
      } else if (value === 'descending') {
        this.allDonors.sort((a,b) => a.gaveBlood < b.gaveBlood ? 1 : -1);
      }
    }else if(this.sortByCriteria === "none"){}
   
  }


  constructor(private router: Router, private tokenStorage: TokenStorageService, private profileService: ProfileService) { }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length !== 0){
      if(this.tokenStorage.getUser().roles[0] !== "ROLE_CENTERADMIN"){
        alert("Unauthorized!");
        this.router.navigate(['/homePage']);
      }else if(Object.keys(this.tokenStorage.getUser()).length === 0){
        this.role = "ROLE_UNREGISTERED"
      }else{
        this.role = this.tokenStorage.getUser().roles[0];
        console.log(this.role);
      }
    }
    this.showAllDonors();
  }

  public showAllDonors(): void {
    this.profileService.getAllDonors().subscribe(data => {
      this.allDonors = data;
    });
  }

}
