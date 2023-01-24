import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  currentUser: any;
  penals: number = 0;
  role: any;

  constructor(private tokenStorage: TokenStorageService, private authService: AuthServiceService, private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorage.getUser();
    if(Object.keys(this.currentUser).length === 0){
      this.role = "ROLE_UNREGISTERED"
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }else{
      this.role = this.tokenStorage.getUser().roles[0];
      console.log(this.role);
    }
    if(this.role === "ROLE_REGISTERED") {
      this.authService.getPenals(this.currentUser.id).subscribe(data => {
        this.penals = data;
        console.log(data);
      });
    }
  }

}
