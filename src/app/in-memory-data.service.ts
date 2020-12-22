import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
//import { Posts } from './posts';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const posts = [
      { postId: 1, userId: 1, countLikes: 700, postText: 'So excited to be on TheMoonverse!', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 2, userId: 1, countLikes: 50, postText: 'Moonverse iS the best!', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 3, userId: 1, countLikes: 10, postText: 'Im over the moon about moonverse!', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 4, userId: 1, countLikes: 9, postText: 'Thanks for the invite guys!', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 5, userId: 1, countLikes: 8, postText: 'So, what is this app all about? What"s the move?', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com'},
      { postId: 6, userId: 1, countLikes: 7, postText: 'YEEEEEER', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 7, userId: 1, countLikes: 30, postText: 'Wassup lunar people', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 8, userId: 1, countLikes: 20, postText: 'Hyeh hyeh hyeh, I made it', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 9, userId: 1, countLikes: 10, postText: 'AY YO', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com' },
      { postId: 11, userId: 1, countLikes: 5, postText: 'So excited to be on TheMoonvere!', postDate:'12/19/20', postMediaUrl:'www.s3bucket.com'}
    ];
    return {posts};
  }
}