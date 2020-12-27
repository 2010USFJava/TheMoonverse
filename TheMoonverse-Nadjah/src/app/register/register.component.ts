import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  user: User = new User();
  submitted = false;

  public registerInvalid: boolean;

  constructor(private userService: UserService, private _route: ActivatedRoute, private _router: Router) { }

  ngOnInit(): void {
  }


// newUser(): void {
//   this.submitted = false;
//   this.user = new User();

//   this.user.userId = 0;
//   this.user.numberPosts = 0;

//   this.isCollapsed = false;

// }

save() {
  this.registerInvalid = false;
  this.user.userId = 0;
  this.user.numberPosts = 0;
  this.userService.registerUser(this.user).subscribe(data => {
    console.log(data)
    this.user = new User();
    this._router.navigate(['login']);
  }, 
  error => console.log(error));
}

onSubmit() {
  this.registerInvalid = false;
  this.user.userId = 0;
  this.user.numberPosts = 0;
  try{
  this.userService.registerUser(this.user).subscribe(data => {
    console.log(data)
    this.user = new User();
    this._router.navigate(['login']);
  }
  ) 
}
  catch (err) {
    this.registerInvalid = true;  
}
}

}
