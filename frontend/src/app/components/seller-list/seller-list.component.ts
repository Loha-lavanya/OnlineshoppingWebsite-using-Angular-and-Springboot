import { Component, OnInit } from '@angular/core';
import { Seller } from 'src/app/common/seller';
import { Observable } from 'rxjs';
import { SellerService } from 'src/app/services/seller.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seller-list',
  templateUrl: './seller-list.component.html',
  styleUrls: ['./seller-list.component.css']
})
export class SellerListComponent implements OnInit {

  sellers: Observable<Seller[]>;

  constructor(private sellerService: SellerService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.sellers = this.sellerService.getSellersList();
  }

  deleteSeller(id: number) {
    this.sellerService.deleteSeller(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

 sellerDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateSeller(id: number){
    this.router.navigate(['update', id]);
  }
}