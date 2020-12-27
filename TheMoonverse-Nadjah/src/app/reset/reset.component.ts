import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent implements OnInit {

  user: User = new User();
  
  tempBirth: Date;
  tempEmail: string;


  submitted = false;

  constructor(private userService: UserService, 
    private router: Router) { }

    //need to check birthdat or pasword to whatever the user puts in matches what 
    //the user has on file

  ngOnInit() {    
  }


newUser(): void {
  this.submitted = false;
  this.user = new User();
}

save() {
  this.userService.updateUser(Number(this.user.id), this.user)
  .subscribe(data => {
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
