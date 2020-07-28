import { CartService } from 'src/app/services/cart.service';
import { CardService } from './../../services/card.service';
import { Card } from './../../common/card';

import { Luv2ShopFormService } from './../../services/luv2-shop-form.service';
import { Component, OnInit, Input,AfterViewChecked } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { User } from 'src/app/common/user';
import { Router } from '@angular/router';
import { IPayPalConfig, ICreateOrderRequest } from 'ngx-paypal';
//import { resolve } from 'dns';

declare let paypal:any;

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})

export class PaymentComponent implements OnInit {

  public payPalConfig?: IPayPalConfig;
  showSuccess: boolean;
  public totalPrice:number=0;
  constructor(private _service: CardService, private _route :Router,
    private cartService: CartService) { }
    ngOnInit(): void {
      this.initConfig();
      this.listCartDetails();
    }

    listCartDetails() {
      // subscribe to the cart totalPrice
      this.cartService.totalPrice.subscribe(
        data => this.totalPrice= data,
        
      );
      }
   public finalAmount:String=String(this.totalPrice);
    private initConfig(): void {
      this.payPalConfig = {
      currency: 'USD',
      clientId: 'sb',
      createOrderOnClient: (data) => <ICreateOrderRequest>{
        intent: 'CAPTURE',
        purchase_units: [
          {
            amount: {
              currency_code: 'USD',
              value: '9.99',
              breakdown: {
                item_total: {
                  currency_code: 'USD',
                  value: '9.99'
                }
              }
            },
            items: [
              {
                name: 'Enterprise Subscription',
                quantity: '1',
                category: 'DIGITAL_GOODS',
                unit_amount: {
                  currency_code: 'USD',
                  value: '9.99',
                },
              }
            ]
          }
        ]
      },
      advanced: {
        commit: 'true'
      },
      style: {
        label: 'paypal',
        layout: 'vertical'
      },
      onApprove: (data, actions) => {
        console.log('onApprove - transaction was approved, but not authorized', data, actions);
        actions.order.get().then(details => {
          console.log('onApprove - you can get full order details inside onApprove: ', details);
        });
      },
      onClientAuthorization: (data) => {
        console.log('onClientAuthorization - you should probably inform your server about completed transaction at this point', data);
        this.showSuccess = true;
      },
      onCancel: (data, actions) => {
        console.log('OnCancel', data, actions);
      },
      onError: err => {
        console.log('OnError', err);
      },
      onClick: (data, actions) => {
        console.log('onClick', data, actions);
      },
    };
    }
}