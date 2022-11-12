import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CenterListComponent } from './pages/center-list/center-list.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { SurveyForUserComponent } from './pages/survey-for-user/survey-for-user.component';
import { UserProfileComponent } from './pages/user-profile/user-profile/user-profile.component';

const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo:'homePage'},
  { path: 'userProfile', component: UserProfileComponent },
  { path: 'homePage', component: HomePageComponent},
  { path: 'centerList', component: CenterListComponent},
  { path: 'takeSurvey', component: SurveyForUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
