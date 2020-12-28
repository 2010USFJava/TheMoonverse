import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';


@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent implements OnInit {
  email: string;
  birthDate: string;
  password: string;
  user: User = new User();
<<<<<<< HEAD
  submitted = false;
  tempBirth: Date;
  tempEmail: string;

  constructor(private userService: UserService, 
    private router: Router) { }
=======

  //submitted = false;
  
  birth: Date;
  email: string;
  public resetInvalid: boolean;


>>>>>>> cbc3cc4f977dd45eda5d2c103a18964266b77c45

  constructor(private userService: UserService, private _route: ActivatedRoute, private _router: Router) { }

  ngOnInit(): void {    
  }

<<<<<<< HEAD

newUser(): void {
  this.submitted = false;
  this.user = new User();
}

save() {
  this.userService.updateUser(Number(this.user.userId), this.user)
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
=======
  onSubmit() {
    this.resetInvalid = false;
    try{
    this.userService.updatePassword(this.user.email, this.user.birthDate, this.user.password).subscribe(
      data => {
      console.log(data);
      this._router.navigate(['login']);
    }
    ) 
  }
    catch (err) {
      this.resetInvalid = true;  
  }
  }
>>>>>>> cbc3cc4f977dd45eda5d2c103a18964266b77c45
}
