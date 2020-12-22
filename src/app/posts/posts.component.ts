import { Component, OnInit } from '@angular/core';
//import { threadId } from 'worker_threads';
// import {FeedService } from '../feed.service';
import { Posts } from '../posts';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  //creates variables of type Posts and type Posts Array
  thisPost: Posts;
  posts: Posts[];
  
  //whenever this component is constructed a variable to receive
  // a feed observable is created

  ngOnInit(): void {}
    
  

  
}
