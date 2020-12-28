import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from '../profile';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})


  export class ProfileComponent implements OnInit 
  {
    userId = '';
    firstName = '';
    lastName = '';
        constructor() { 
          
      }

      ngOnInit(): void {
      }

  }
