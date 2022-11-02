import { Component, OnInit } from '@angular/core';
import { CenterService } from 'src/app/services/center.service';

@Component({
  selector: 'app-center-list',
  templateUrl: './center-list.component.html',
  styleUrls: ['./center-list.component.css']
})
export class CenterListComponent implements OnInit {

  public allCenters: any[] = [];
  public searchedCenters: any[]= [];
  search : string ='';

  constructor(private centerService : CenterService) { }

  ngOnInit(): void {
    this.showAllCenters();
  }

  public showAllCenters(): void {
    this.centerService.getAllCenters().subscribe(data => {
      this.allCenters = data;
    });
  }

  public Search(): void {
    this.centerService.searchCenters(this.search).subscribe(data => {
      this.searchedCenters = data;
    }
    );
  }

}
