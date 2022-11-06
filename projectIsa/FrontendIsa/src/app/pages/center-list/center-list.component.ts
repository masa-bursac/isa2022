import { Component, OnInit } from '@angular/core';
import { CenterService } from 'src/app/services/center.service';
import { RegisterCenterComponent } from '../register-center/register-center.component';

@Component({
  selector: 'app-center-list',
  templateUrl: './center-list.component.html',
  styleUrls: ['./center-list.component.css']
})
export class CenterListComponent implements OnInit {

  public allCenters: any[] = [];
  public searchedCenters: any[] = [];
  public allFiltered: any[] = [];
  public addForm: boolean = false;
  search : string = '';
  selectedValue : number = 0;

  constructor(private centerService : CenterService) { }

  ngOnInit(): void {
    this.showAllCenters();
  }

  public showAllCenters(): void {
    this.centerService.getAllCenters().subscribe(data => {
      this.allCenters = data;
    });
  }

  public searchCenters(): any {
      this.centerService.searchCenters(this.search).subscribe(data => {
        this.searchedCenters = data;
        if(this.selectedValue !== 0){
          this.allFiltered = this.searchedCenters.filter(center => center.rating === this.selectedValue);
        }
      }
    );
  }

  ratings: any[] = [
    {value: 5, viewValue: '5'},
    {value: 4, viewValue: '4'},
    {value: 3, viewValue: '3'},
    {value: 2, viewValue: '2'},
    {value: 1, viewValue: '1'}
  ];

  public filterRating(value: number): void {
    this.selectedValue = value;
    if(this.search===''){
      this.searchedCenters = [];
    }
    if(this.searchedCenters.length === 0) {
      this.allFiltered = this.allCenters.filter(center => center.rating === value);
    } else {
      this.allFiltered = this.searchedCenters.filter(center => center.rating === value);
    }
  }

  public showAddCenter(): void {
      this.addForm = true;
  }
  public RegisterCenterClosed(isClosed: any): void{
    this.addForm = false;
  }

}
