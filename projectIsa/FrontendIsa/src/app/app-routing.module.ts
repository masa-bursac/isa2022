import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BloodInStockOverviewComponent } from './pages/blood-in-stock-overview/blood-in-stock-overview.component';
import { CenterAdminOverviewComponent } from './pages/center-admin-overview/center-admin-overview.component';
import { CenterListComponent } from './pages/center-list/center-list.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { UserProfileCentreAdminComponent } from './pages/user-profile-centre-admin/user-profile-centre-admin.component';
import { SurveyForUserComponent } from './pages/survey-for-user/survey-for-user.component';
import { UserProfileComponent } from './pages/user-profile/user-profile/user-profile.component';
import { UsersComponent } from './pages/users/users.component';
import { LoginComponent } from './pages/login/login.component';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';

const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo:'landingPage'},
  { path: 'userProfile', component: UserProfileComponent },
  { path: 'userProfileCentreAdmin', component: UserProfileCentreAdminComponent },
  { path: 'registration', component: RegistrationComponent},
  { path: 'homePage', component: HomePageComponent},
  { path: 'blood', component: BloodInStockOverviewComponent},
  { path: 'center', component: CenterAdminOverviewComponent},
  { path: 'centerList', component: CenterListComponent},
  { path: 'users', component: UsersComponent },
  { path: 'takeSurvey', component: SurveyForUserComponent},
  { path: 'login', component: LoginComponent},
  { path: 'landingPage', component: LandingPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
