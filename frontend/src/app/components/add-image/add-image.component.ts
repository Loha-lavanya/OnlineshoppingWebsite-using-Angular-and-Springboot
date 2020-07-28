import { ProductService } from 'src/app/services/product.service';
import { Product } from './../../common/product';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-image',
  templateUrl: './add-image.component.html',
  styleUrls: ['./add-image.component.css']
})
export class AddImageComponent implements OnInit {

  public product=new Product();
  form: any = {};
  isAdded = false;
  isAddedFaild = false;
  errorMessage = '';
  constructor( private productService:ProductService,
               private router: Router) { }

  ngOnInit(): void {
    
  }

  onSubmit() {
    console.log(this.form);
 
    this.productService.addProduct(this.product).subscribe(
      data => {
        console.log(data);
        this. isAddedFaild = false;
        this. isAdded  = true;
        //this.reloadPage();
        this.router.navigate(['/addproduct']);
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this. isAddedFaild= true;
      }
    );
  }

  reloadPage() {
    window.location.reload();
  }
}
