import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentUser: any;
  role: any;

  constructor(private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorage.getUser();
    console.log(this.currentUser);
    if(Object.keys(this.currentUser).length === 0){
      this.role = "ROLE_UNREGISTERED"
    }else{
      this.role = this.tokenStorage.getUser().roles[0];
      console.log(this.role);
    }
  }

  public LogOut(): void {
    this.tokenStorage.signOut();
    this.router.navigate(['/landingPage']);
    localStorage.clear();
  }

}
