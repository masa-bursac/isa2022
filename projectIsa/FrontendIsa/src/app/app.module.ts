import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table'  
import { AppRoutingModule } from './app-routing.module';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatSelectModule } from '@angular/material/select';
import { MatNativeDateModule } from '@angular/material/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import {MatRadioModule} from '@angular/material/radio';
import {MatMenuModule} from '@angular/material/menu';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';

import { UserProfileComponent } from './pages/user-profile/user-profile/user-profile.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { UserProfileCentreAdminComponent } from './pages/user-profile-centre-admin/user-profile-centre-admin.component';
import { BloodInStockOverviewComponent } from './pages/blood-in-stock-overview/blood-in-stock-overview.component';
import { CenterAdminOverviewComponent } from './pages/center-admin-overview/center-admin-overview.component';
import { MatDividerModule } from '@angular/material/divider';
import { CenterListComponent } from './pages/center-list/center-list.component';
import { RegisterCenterComponent } from './pages/register-center/register-center.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { RegisterCenterAdministratorComponent } from './pages/register-center-administrator/register-center-administrator.component';
import { ChangeCenterAdminPasswordComponent } from './pages/change-center-admin-password/change-center-admin-password.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { NgxMatDatetimePickerModule } from '@angular-material-components/datetime-picker';
import { UsersComponent } from './pages/users/users.component';
import { SurveyForUserComponent } from './pages/survey-for-user/survey-for-user.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { LoginComponent } from './pages/login/login.component';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';
import { ComplaintsComponent } from './pages/complaints/complaints.component';
import { ChangePasswordComponent } from './pages/change-password/change-password.component';
import { AppointmentsComponent } from './pages/appointments/appointments.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { ScheduleAppointmentRegUserComponent } from './pages/schedule-appointment-reg-user/schedule-appointment-reg-user.component';

@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    HomePageComponent,
    NavbarComponent,
    CenterListComponent,
    RegisterCenterComponent,
    RegisterCenterAdministratorComponent,
    RegistrationComponent,
    UserProfileCentreAdminComponent,
    BloodInStockOverviewComponent,
    CenterAdminOverviewComponent,
    ChangeCenterAdminPasswordComponent,
    UsersComponent,
    SurveyForUserComponent,
    LoginComponent,
    LandingPageComponent,
    ComplaintsComponent,
    ChangePasswordComponent,
    AppointmentsComponent,  
    ScheduleAppointmentRegUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatTableModule,
    MatInputModule,
    MatButtonModule,
    MatRadioModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSelectModule,
    MatNativeDateModule,
    MatToolbarModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatMenuModule,
    MatSnackBarModule,
    MatDividerModule,
    MatDatepickerModule,
    NgxMatDatetimePickerModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
    
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }