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

  displayedColumns: string[] = ['name', 'role','gender','email', 'phoneNumber', 'jmbg','education','profession','address'];
  search: string = '';
  searchUsersOn: boolean = false;
  public searchedUsers: any[] = [];
  users: any[] = [];
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

}
