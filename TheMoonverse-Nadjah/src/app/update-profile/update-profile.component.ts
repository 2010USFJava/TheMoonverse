import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from '../profile';
import { ProfileService } from '../profileService';
import { User } from '../user';
import { UserService } from '../user.service';


@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  profile: Profile = new Profile();
  submitted = false;
  user: User = new User();
  

  constructor(private userService: UserService, private profileService: ProfileService,
    private router: Router) { }

  ngOnInit() {
  }


newUser(): void {
  this.submitted = false;
  this.user = new User();
}

newProfile(): void{
  this.submitted = false;
  this.profile = new Profile;
}

save() {
  this.userService.updateUser(Number(this.user.userId), this.user)
  .subscribe(data => {
    console.log(data)
    this.user = new User();
    this.gotoList();
  }, 
  error => console.log(error));

  this.profileService.updateProfile(Number(this.user.userId), this.profile)
  .subscribe(data => {
    console.log(data)
    this.profile = new Profile();
    this.gotoList();
  }, 
  error => console.log(error));
}

onSubmit() {
  this.submitted = true;
  this.save();    
}

gotoList() {
  this.router.navigate(['/user']);
  this.router.navigate(['/profile']);
}
}