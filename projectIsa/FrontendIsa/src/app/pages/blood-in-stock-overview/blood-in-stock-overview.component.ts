import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MedicalEquipmentServiceService } from 'src/app/services/medical-equipment-service.service';

export interface Blood {
  id: number,
  type: number,
  quantity: number
}

@Component({
  selector: 'app-blood-in-stock-overview',
  templateUrl: './blood-in-stock-overview.component.html',
  styleUrls: ['./blood-in-stock-overview.component.css']
})
export class BloodInStockOverviewComponent implements OnInit{

  displayedColumns: string[] = ['id', 'type', 'quantity'];
  dataSource = [];

  constructor(private medicalEquipmentService: MedicalEquipmentServiceService, private router: Router) { }

  ngOnInit(): void {
    this.medicalEquipmentService.GetBlood().subscribe((data: any)=> {
      this.dataSource = data;
    });
  }
}
