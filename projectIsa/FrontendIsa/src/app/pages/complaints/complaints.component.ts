import { Component, OnInit } from '@angular/core';
import { ComplaintService } from 'src/app/services/complaint.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {

  complaints : any[] = [];
  constructor(private complaintService: ComplaintService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.getComplaints();
  }

  public getComplaints(): void{
    console.log(this.tokenStorage.getUser().id);
    this.complaintService.getComplaints().subscribe(data => {
      this.complaints = data;
      console.log(this.complaints)
    });
  }

  sortBy() {
    return this.complaints.sort((a,b) => ( a.answer == null ) && ( b.answer !=null )? -1 : 1);
  }
}
