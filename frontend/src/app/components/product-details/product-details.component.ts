import { TokenStorageService } from './../../auth/token-storage.service';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { ActivatedRoute } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { CartItem } from 'src/app/common/cart-item';
import { User } from 'src/app/common/user';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  info :any;
  product: Product = new Product();
  user:User=new User();
  constructor(private productService: ProductService,
              private cartService: CartService,
              private route: ActivatedRoute,
              private token:TokenStorageService) { }

  ngOnInit(): void {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      userid:this.token.getUserid(),
      authorities: this.token.getAuthorities()
    };

    this.route.paramMap.subscribe(() => {
      this.handleProductDetails();
    })

  }

  handleProductDetails() {

    // get the "id" param string. convert string to a number using the "+" symbol
    const theProductId: number = +this.route.snapshot.paramMap.get('id');

    this.productService.getProduct(theProductId).subscribe(
      data => {
        this.product = data;
      }
    )
  }

  addToCart() {

    console.log(`Adding to cart: ${this.product.name}, ${this.product.unitPrice}`);
    const theCartItem = new CartItem(this.product,this.info.username);
    this.cartService.addToCart(theCartItem);
    
  }

}
