import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  currentUser: any;

  constructor(private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorage.getUser();
    if(Object.keys(this.currentUser).length === 0){
      alert("Unauthorized!");
      this.router.navigate(['/landingPage']);
    }
  }

}
