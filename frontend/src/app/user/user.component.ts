import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../common/user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { TokenStorageService } from '../auth/token-storage.service';
import { Order } from '../common/order';
import { OrderService } from '../services/order.service';
 
 
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
/*
export class UserComponent implements OnInit {
  board: string;
  errorMessage: string;
  private usersUrl: string;
 
 constructor(private userService: UserService) {
 
   }
  
  ngOnInit() {
    this.userService.getUserBoard().subscribe(
      data => {
        this.board = data;
      },  
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
*/


export class UserComponent implements OnInit {
  info: any;
  orders:Order[];
  constructor(private token: TokenStorageService,
              private orderService:OrderService) { }
 
  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      userid:this.token.getUserid(),
      authorities: this.token.getAuthorities()
    };

    this.orderService.getOrder(this.info.username).subscribe(data => {
      this.orders = data;
    });
  }
  }
