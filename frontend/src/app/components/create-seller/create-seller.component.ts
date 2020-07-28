import { SellerService } from './../../services/seller.service';
import { Seller } from './../../common/seller';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-seller',
  templateUrl: './create-seller.component.html',
  styleUrls: ['./create-seller.component.css']
})
export class CreateSellerComponent implements OnInit {

  seller: Seller = new Seller();
  submitted = false;

  constructor(private sellerService: SellerService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.seller = new Seller();
  }

  save() {
    this.sellerService.createSeller(this.seller)
      .subscribe(data => console.log(data), error => console.log(error));
    this.seller = new Seller();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/sellers']);
  }
}
