import { Component, OnInit } from '@angular/core';
import { FeedService } from '../feed.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Posts } from '../posts';
import { CookieService } from 'ngx-cookie-service';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  //creates variables of type Posts and type Posts Array
  post: Posts = new Posts();
  posts: Posts[];
  dateMessage: String;
  submitted = false;




  constructor(
    private route: ActivatedRoute,
    private feed: FeedService,
    private router: Router,
    private cookie: CookieService,
    private userService: UserService
  ){
    
  }
  ngOnInit(): void {
    let currentDate = new Date()
    this.dateMessage = currentDate.toDateString();
  }

  onSubmit(){
   this.post.postId = 0;
   this.post.userId = this.userService.getUser(Number(this.cookie.get('userId'))); //get cookie user here
   this.post.countLikes=0;
   this.post.postDate = this.dateMessage.trim();
   this.post.postMediaUrl = '';

   this.feed.makePost(this.post)
   .subscribe(post => {
     console.log(post)
     this.post = new Posts();
   });
  }
  goBack(): void {
    this.router.navigate(['/feed']);
  } 

  
}
