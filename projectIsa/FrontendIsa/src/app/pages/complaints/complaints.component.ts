import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ComplaintService } from 'src/app/services/complaint.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {

  currentAnswer : any = "";
  complaints : any[] = [];

  @Output()
  onClose: EventEmitter<boolean> = new EventEmitter();
  
  constructor(private complaintService: ComplaintService, private tokenStorage: TokenStorageService,
    private _snackBar: MatSnackBar) { }

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

  public sendAnswer(complaint: any){
    const body = {
      id: complaint.id,
      answer: complaint.currentAnswer,
      adminAnswerId : this.tokenStorage.getUser().id
    }
    this.complaintService.sendAnswer(body).subscribe(data => { 
      this._snackBar.open('Answer sent successfully', 'Close',{
        duration: 3000
      });
      window.location.reload();
      this.onClose.emit(true);
    })
  }
}
