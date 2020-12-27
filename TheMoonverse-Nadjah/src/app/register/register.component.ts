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

  user: User = new User();
  submitted = false;

  //isCollapsed : boolean = true;

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit() {
  }


newUser(): void {
  this.submitted = false;
  this.user = new User();
 // this.isCollapsed = false;

}

save() {
  this.userService
  .registerUser(this.user).subscribe(data => {
    console.log(data)
    this.user = new User();
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
}
}
