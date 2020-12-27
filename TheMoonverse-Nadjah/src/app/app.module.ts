import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfileComponent } from './profile/profile.component';
import { PostsComponent } from './posts/posts.component';
import { FeedComponent } from './feed/feed.component';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ResetComponent } from './reset/reset.component';



@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    PostsComponent,
    PostsComponent,
    FeedComponent,
    LoginComponent,
    RegisterComponent,
    UpdateProfileComponent,
    ResetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(
    InMemoryDataService, { dataEncapsulation: false }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }