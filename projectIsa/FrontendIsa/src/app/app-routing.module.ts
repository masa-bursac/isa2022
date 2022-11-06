import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BloodInStockOverviewComponent } from './pages/blood-in-stock-overview/blood-in-stock-overview.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { UserProfileCentreAdminComponent } from './pages/user-profile-centre-admin/user-profile-centre-admin.component';
import { UserProfileComponent } from './pages/user-profile/user-profile/user-profile.component';

const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo:'homePage'},
  { path: 'userProfile', component: UserProfileComponent },
  { path: 'userProfileCentreAdmin', component: UserProfileCentreAdminComponent },
  { path: 'registration', component: RegistrationComponent},
  { path: 'homePage', component: HomePageComponent},
  { path: 'blood', component: BloodInStockOverviewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
