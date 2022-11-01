import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { UserProfileComponent } from './pages/user-profile/user-profile/user-profile.component';

const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo:'homePage'},
  { path: 'userProfile', component: UserProfileComponent },
  { path: 'registration', component: RegistrationComponent},
  { path: 'homePage', component: HomePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
