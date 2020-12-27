import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from '../profile';
import { ProfileService } from '../profile.service';
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
  

  constructor() { }

  ngOnInit() {
  }



}