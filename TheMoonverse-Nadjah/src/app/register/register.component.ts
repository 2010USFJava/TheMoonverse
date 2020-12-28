import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  //@Input('user') user: User;
  user: User = new User();
  submitted = false;

  public registerInvalid: boolean;

  constructor(private userService: UserService, private _route: ActivatedRoute, private _router: Router) { }

  ngOnInit(): void {
  }

onSubmit() {
  this.registerInvalid = false;
  this.user.userId = 0;
  this.user.numberPosts = 0;
  try{
  this.userService.registerUser(this.user).subscribe(data => {
    console.log(data)
    this.user = new User();
   
  }, 
  error => console.log(error));
}
}
}
