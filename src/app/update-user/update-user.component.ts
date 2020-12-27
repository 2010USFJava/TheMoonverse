import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  user:User;
  constructor() { }

  ngOnInit(): void {
  }

}
