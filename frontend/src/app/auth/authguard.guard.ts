import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot ,Router} from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router,private token: TokenStorageService,private userdata:UserService) {
   
  }
  ngOnInit() {
    token: this.token.getToken();
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if ( this.token.isLoggedIn() ){

        if (next.data.roles && next.data.roles.indexOf(this.token.getAuthorities().length) === -1) {
          // role not authorised so redirect to home page
          this.router.navigate(['/home']);
          return false;
      }
        // Token from the LogIn is avaiable, so the user can pass to the route
        return true;
      } else  {
        // Token from the LogIn is not avaible because something went wrong or the user wants to go over the url to the site
        // Hands the user to the LogIn page 
        alert("You are currently not logged in, please provide Login!")
        this.router.navigate( ['/auth/login'] );
        return false;

      }
  }
}