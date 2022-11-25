import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { RegisterCenterComponent } from '../register-center/register-center.component';

@Component({
  selector: 'app-center-list',
  templateUrl: './center-list.component.html',
  styleUrls: ['./center-list.component.css']
})
export class CenterListComponent implements OnInit {

  public allCenters: any[] = [];
  public allFilteredAndSorted: any[] = [];
  public addForm: boolean = false;
  search : string = '';
  selectedValue : number = 0;
  role: any;

  constructor(private centerService : CenterService, private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length !== 0){
      if(this.tokenStorage.getUser().roles[0] === "ROLE_CENTERADMIN"){
        alert("Unauthorized!");
        this.router.navigate(['/homePage']);
      }else if(Object.keys(this.tokenStorage.getUser()).length === 0){
        this.role = "ROLE_UNREGISTERED"
      }else{
        this.role = this.tokenStorage.getUser().roles[0];
        console.log(this.role);
      }
    }
    this.showAllCenters();
  }

  public showAllCenters(): void {
    this.centerService.getAllCenters().subscribe(data => {
      this.allCenters = data;
    });
  }

  public searchCenters(): any {
    this.centerService.searchCenters(this.search).subscribe(data => {
      if(this.selectedValue === undefined){
        this.allFilteredAndSorted = data;
      }else if(this.allFilteredAndSorted.length !== 0 && this.selectedValue !== 0){
        this.allFilteredAndSorted = data;
        this.allFilteredAndSorted = this.allFilteredAndSorted.filter(center => center.rating === this.selectedValue);
      }else if(this.search === '' && this.selectedValue === undefined && this.allFilteredAndSorted.length !==0){
        this.allFilteredAndSorted = [];
      }else {
        this.allFilteredAndSorted = data;
      }
    });
  }

  public filterRating(value: number): void {
    this.selectedValue = value;
    if(this.allFilteredAndSorted.length === 0){
      this.allFilteredAndSorted = this.allCenters.filter(center => center.rating === value);
    }else if(this.selectedValue === undefined && this.allFilteredAndSorted.length === 0){
      this.searchCenters();
    }else if(this.search !== '' && this.selectedValue === undefined && this.allFilteredAndSorted.length !== 0){
      this.searchCenters();
    }else if(this.search !== '' && this.selectedValue !== 0 && this.allFilteredAndSorted.length !== 0){
      this.searchCenters();
    }else if(this.search !== ''){
      this.allFilteredAndSorted = this.allFilteredAndSorted.filter(center => center.rating === value);
    }else if(this.search === '' && this.selectedValue === undefined && this.allFilteredAndSorted.length !==0){
      this.allFilteredAndSorted = [];
    }else {
      this.allFilteredAndSorted = this.allCenters.filter(center => center.rating === value);
    }
  }

  public setCenters(): any {
    if(this.search === '' && this.selectedValue !== 0){
      this.allFilteredAndSorted = this.allCenters.filter(center => center.rating === this.selectedValue);
    }else if(this.search === '' && (this.selectedValue === 0 || this.selectedValue === undefined) && this.allFilteredAndSorted.length !==0){
      this.allFilteredAndSorted = [];
    }
  }

  ratings: any[] = [
    {value: 5, viewValue: '5'},
    {value: 4, viewValue: '4'},
    {value: 3, viewValue: '3'},
    {value: 2, viewValue: '2'},
    {value: 1, viewValue: '1'}
  ];

  public showAddCenter(): void {
      this.addForm = !this.addForm;
  }
  public RegisterCenterClosed(isClosed: any): void{
    this.addForm = false;
  }
  allDirections: any[] = [
    {value: 'ascending', viewValue: 'ascending'},
    {value: 'descending', viewValue: 'descending'}
  ];

  public sortByName(value: string) {
    if (value === 'ascending') {
      this.allCenters.sort((a,b) => a.name > b.name ? 1 : -1);
      this.allFilteredAndSorted.sort((a,b) => a.name > b.name ? 1 : -1);
    } else if (value === 'descending') {
      this.allCenters.sort((a,b) => a.name < b.name ? 1 : -1);
      this.allFilteredAndSorted.sort((a,b) => a.name < b.name ? 1 : -1);
    }
  }

  public sortByCity(value: string) {
    if (value === 'ascending') {
      this.allCenters.sort((a,b) => a.city > b.city ? 1 : -1);
      this.allFilteredAndSorted.sort((a,b) => a.city > b.city ? 1 : -1);
    } else if (value === 'descending') {
      this.allCenters.sort((a,b) => a.city < b.city ? 1 : -1);
      this.allFilteredAndSorted.sort((a,b) => a.city < b.city ? 1 : -1);
    }
  }

  public sortByRating(value: string) {
    if (value === 'ascending') {
      this.allCenters.sort((a,b) => a.rating > b.rating ? 1 : -1);
      this.allFilteredAndSorted.sort((a,b) => a.rating > b.rating ? 1 : -1);
    } else if (value === 'descending') {
      this.allCenters.sort((a,b) => a.rating < b.rating ? 1 : -1);
      this.allFilteredAndSorted.sort((a,b) => a.rating < b.rating ? 1 : -1);
    }
  }

}
