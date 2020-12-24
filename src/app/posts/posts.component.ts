import { Component, OnInit } from '@angular/core';
import { FeedService } from '../feed.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
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
  post: Posts;
  //posts: Posts[];
  
  //whenever this component is constructed a variable to receive
  // a feed observable is created
  constructor(
    private route: ActivatedRoute,
    private feed: FeedService,
    private location: Location
  ){
    
  }
  ngOnInit(): void {
      this.getPost();
  }
  
  getPost(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.feed.getPost(id)
        .subscribe(post => this.post = post);
  }
  
  goBack(): void {
    this.location.back();
  }
  
}
