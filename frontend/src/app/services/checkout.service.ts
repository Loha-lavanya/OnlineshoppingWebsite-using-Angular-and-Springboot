import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Checkout } from '../common/checkout';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  constructor(private _http:HttpClient) { }
  public CheckoutDetailsRemote(checkout:Checkout):Observable<any>{
    return this._http.post<any>("http://localhost:8090/api/email/sendEmail",checkout)
 
   }
}
