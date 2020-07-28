import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../common/user';
const USERNAME_KEY = 'AuthUsername';
@Injectable({
  providedIn: 'root'
})
export class UserService {
 
  private userUrl = 'http://localhost:8090/api/getUsers';

  private adminUrl = 'http://localhost:8090/api/test/admin';
 
  constructor(private http: HttpClient) { 

  }
 
  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }
  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }
 
  
 
  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }

  public getUsername(): any {
    return sessionStorage.getItem(USERNAME_KEY);
  }
}