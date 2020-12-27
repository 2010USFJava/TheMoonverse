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
 
  user: User = new User();

  //submitted = false;
  
 
  public resetInvalid: boolean;



  constructor(private userService: UserService, private _route: ActivatedRoute, private _router: Router) { }

  ngOnInit(): void {    
  }

  onSubmit() {
    this.resetInvalid = false;
    try{
    this.userService.updateUser(this.user, this.user.userId).subscribe(
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
}
