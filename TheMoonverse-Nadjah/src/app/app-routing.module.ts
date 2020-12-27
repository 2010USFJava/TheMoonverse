
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProfileComponent } from './profile/profile.component';
import {PostsComponent} from './posts/posts.component';
import{FeedComponent} from './feed/feed.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
  { path: '', redirectTo: 'index', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'profile', component: ProfileComponent },
  { path: 'update/:id', component: UpdateUserComponent },
  { path: 'posts', component: PostsComponent},
  { path: 'feed', component: FeedComponent},  
  { path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }