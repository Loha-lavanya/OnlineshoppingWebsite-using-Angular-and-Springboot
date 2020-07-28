import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  board: string;
  errorMessage: string;
 
  constructor(private userService: UserService,
              private _route:Router) { }
 
  ngOnInit() {
    this.userService.getAdminBoard().subscribe(
      data => {
        this.board = data;
        this._route.navigate(['admin'])
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }
}