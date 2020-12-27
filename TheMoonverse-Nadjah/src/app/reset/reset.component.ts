import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent implements OnInit {
  user: User = new User();
  submitted = false;

  constructor() { }

  ngOnInit(): void {
  }

}
