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

  constructor(private tokenStorage: TokenStorageService, private authService: AuthServiceService, private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorage.getUser();
    if(Object.keys(this.currentUser).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }
    if(this.currentUser.role === 'ROLE_REGISTERED') {
      this.authService.getPenals(this.currentUser.id).subscribe(data => this.penals = data);
    }
  }

}
