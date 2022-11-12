import { Component, OnInit } from '@angular/core';
import { ProfileService } from 'src/app/services/profile.service';


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
  constructor(private profileService: ProfileService) { }

  ngOnInit(): void {
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
