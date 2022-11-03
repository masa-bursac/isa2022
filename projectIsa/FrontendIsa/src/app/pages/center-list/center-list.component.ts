import { Component, OnInit } from '@angular/core';
import { CenterService } from 'src/app/services/center.service';

interface Rating {
  value: number;
  viewValue: string;
}

interface City {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-center-list',
  templateUrl: './center-list.component.html',
  styleUrls: ['./center-list.component.css']
})
export class CenterListComponent implements OnInit {

  public allCenters: any[] = [];
  public searchedCenters: any[] = [];
  public allFiltered: any[] = [];
  search : string = '';

  constructor(private centerService : CenterService) { }

  ngOnInit(): void {
    this.showAllCenters();
  }

  public showAllCenters(): void {
    this.centerService.getAllCenters().subscribe(data => {
      this.allCenters = data;
    });
  }

  public searchCenters(): void {
    this.centerService.searchCenters(this.search).subscribe(data => {
      this.searchedCenters = data;
    }
    );
  }

  ratings: Rating[] = [
    {value: 5, viewValue: '5'},
    {value: 4, viewValue: '4'},
    {value: 3, viewValue: '3'},
    {value: 2, viewValue: '2'},
    {value: 1, viewValue: '1'}
  ];

  citys: City[] = [
    {value: 'Novi Sad', viewValue: 'Novi Sad'},
    {value: 'Beograd', viewValue: 'Beograd'}
  ];

  public filterRating(value: number): void {
    this.allFiltered = this.allCenters.filter(center => center.rating === value);
  }

  public filterCity(value: string): void {
    this.allFiltered = this.allCenters.filter(center => center.city === value);
  }

}
