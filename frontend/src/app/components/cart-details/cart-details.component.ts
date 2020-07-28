import { LoginComponent } from './../../login/login.component';

import { Component, OnInit, Output } from '@angular/core';
import { CartItem } from 'src/app/common/cart-item';
import { CartService } from 'src/app/services/cart.service';
import { Router } from '@angular/router';
import { CardService } from 'src/app/services/card.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  public cartItems: CartItem[] = [];
  public totalPrice: number = 0;
  public totalQuantity: number = 0;
  public status:number;

  constructor(private _service: CardService,
              private cartService: CartService,
            
              private router:Router) { }

  ngOnInit(): void {
    this.listCartDetails();
  }

  listCartDetails() {

    // get a handle to the cart items
    this.cartItems = this.cartService.cartItems;

    // subscribe to the cart totalPrice
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    );

    // subscribe to the cart totalQuantity
    this.cartService.totalQuantity.subscribe( 
      data => this.totalQuantity = data
    );

    // compute cart total price and quantity
    this.cartService.computeCartTotals();
  }

  incrementQuantity(theCartItem: CartItem) {
    this.cartService.addToCart(theCartItem);
  }

  decrementQuantity(theCartItem: CartItem) {
    this.cartService.decrementQuantity(theCartItem);
  }

  remove(theCartItem: CartItem) {
    this.cartService.remove(theCartItem);
  }
  
  checkout(cartItems:CartItem[]){
   
    this._service.OrderDetails(this.cartItems).subscribe(
      data => {
                 console.log("response received");
                 
                //this._route.navigate(['/login'])
              },
      error => {
                   console.log("exception occured")
                   this.status=error.error;
                   
               }
    ); this.router.navigate(['/checkout']);
  }
  
}
