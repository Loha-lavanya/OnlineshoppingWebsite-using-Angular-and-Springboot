
import { CartItem } from 'src/app/common/cart-item';
import { Card } from './../common/card';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private _http:HttpClient) { }
  public CardPaymentRemote(card:Card):Observable<any>{
    return this._http.post<any>("http://localhost:8090/api/auth/pay",card)
 
   }
/*
   public OrderDetails(cartItems:CartItem[]):Observable<any>{
    return this._http.post<any>("http://localhost:8090/api/email/sendEmail1",cartItems);
 
   }
*/

public OrderDetails(cartItems:CartItem[]):Observable<any>{
  return this._http.post<any>("http://localhost:8090/api/cart",cartItems);

 }
}