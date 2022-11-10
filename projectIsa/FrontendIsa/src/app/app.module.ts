import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table'  
import { AppRoutingModule } from './app-routing.module';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatSelectModule } from '@angular/material/select';
import { MatNativeDateModule } from '@angular/material/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserProfileComponent } from './pages/user-profile/user-profile/user-profile.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { UserProfileCentreAdminComponent } from './pages/user-profile-centre-admin/user-profile-centre-admin.component';
import { BloodInStockOverviewComponent } from './pages/blood-in-stock-overview/blood-in-stock-overview.component';
import { CenterAdminOverviewComponent } from './pages/center-admin-overview/center-admin-overview.component';
import {MatDividerModule} from '@angular/material/divider';
import { CenterListComponent } from './pages/center-list/center-list.component';

@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    RegistrationComponent,
    HomePageComponent,
    NavbarComponent,
    UserProfileCentreAdminComponent,
    BloodInStockOverviewComponent,
    CenterAdminOverviewComponent,
    CenterListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSelectModule,
    MatNativeDateModule,
    MatToolbarModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatTableModule,
    MatDividerModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }