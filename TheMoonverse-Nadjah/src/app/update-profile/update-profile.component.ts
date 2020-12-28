import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
 
  uid: number;

  user: User = new User();
  profile: Profile = new Profile();
  submitted = false;  

<<<<<<< HEAD
  constructor() { }
=======
  /*  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: EmployeeService) { } */
  constructor(private route: ActivatedRoute, private userService: UserService,
     private profileService: ProfileService, private router: Router) { }
>>>>>>> c111cb5740873ba2770dfcd6a0b9831970a8c2e0

  ngOnInit() {
    this.user = new User();
    this.profile = new Profile();

    this.uid = this.route.snapshot.params['uid']; 

<<<<<<< HEAD

=======
    this.userService.getUser(this.uid)
      .subscribe(data => {
        console.log(data)
        this.user = data;
      }, error => console.log(error));

      this.profileService.getProfile(this.uid)
      .subscribe(data => {
        console.log(data)
        this.profile = data;
      }, error => console.log(error));
  }


update() {
  this.userService.updateUser(this.uid, this.user)
  .subscribe(data => {
    console.log(data);
    this.user = new User();
    this.gotoList();
  }, error => console.log(error));

  this.profileService.updateProfile(this.uid, this.user)
  .subscribe(data => {
    console.log(data);
    this.profile = new Profile();
    this.gotoList();
  }, error => console.log(error));
}

onSubmit() {
  this.submitted = true;
  this.update();    
}

gotoList() {
  this.router.navigate(['/user']);
  this.router.navigate(['/profile']);
}
>>>>>>> c111cb5740873ba2770dfcd6a0b9831970a8c2e0
}