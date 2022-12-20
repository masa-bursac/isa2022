import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileService } from 'src/app/services/profile.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {

  displayedColumns: string[] = ['name', 'role','gender','email', 'phoneNumber', 'jmbg','education','profession','address', 'appointments'];
  search: string = '';
  searchUsersOn: boolean = false;
  public searchedUsers: any[] = [];
  addForm: boolean = false;
  users: any[] = [];
  type: string = "systemAdmin"
  constructor(private profileService: ProfileService, private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if(Object.keys(this.tokenStorage.getUser()).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }else if(this.tokenStorage.getUser().roles[0] === "ROLE_REGISTERED"){
      alert("Unauthorized!");
      this.router.navigate(['/homePage']);
    }
    this.getAllUsers();
  }

  public showAppointments($myParam: number = 0) : void{
    const navigationDetails: string[] = ['/patientAppointments'];
    if($myParam) {
      navigationDetails.push($myParam.toString());
    }
    this.router.navigate(navigationDetails);
  }

  public getAllUsers(): void {
    this.profileService.getAllUsers().subscribe(data => {
      this.users = data;
      console.log(this.users)
    });
  }

  public searchUsers(): void {
    this.searchUsersOn = true;
    for(let user of this.users){
      if(user.name.includes(this.search) || user.surname.includes(this.search) || (user.name + ' '+ user.surname).includes(this.search)) {
        this.searchedUsers.push(user);
      }
    }
  }
  public disableSearch(): void {
    this.searchUsersOn = false;
    this.search = '';
    this.searchedUsers = [];
  }

  public ShowRegisterAdminForm(): void {
    this.addForm = !this.addForm;
}
public RegisterAdminClosed(newAdmin: any): void{
  this.addForm = false;
}
}
