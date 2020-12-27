import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { Profile } from '../profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})


  export class ProfileComponent implements OnInit 
  {
   /* name: String;
    aboutMe: String;
    age: number;
    city: String;
    proffesion: String;
    favoritePlanet : String;
    profilePicture: String;*/
    //profile: Profile;
   
    //id: number;
    //user: User;
    tuser: any;
  
  //  constructor(private route: ActivatedRoute,private router: Router,
//private userService: UserService) { 
        constructor() { 
      
      }

      ngOnInit() {
        this.tuser =
        {
          name: 'Petra Maurer',
          aboutMe: 'I love nerds!',
          age: 30,
          city: 'Lawrenceville',
          proffesion: 'Software Developer',
          favoritePlanet : 'Jupiter',
          countLikes: 10

        };
       
      }
  
 /*   ngOnInit() {
      this.user = new User();
  
      this.id = this.route.snapshot.params['id'];
      
      this.userService.getUser(this.id)
        .subscribe(data => {
          console.log(data)
          this.user = data;
        }, error => console.log(error));
    }
  
    list(){
      this.router.navigate(['user']);
    }*/
  }
