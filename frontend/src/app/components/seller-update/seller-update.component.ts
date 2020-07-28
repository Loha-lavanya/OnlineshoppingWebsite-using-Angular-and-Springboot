import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SellerService } from 'src/app/services/seller.service';
import { Seller } from 'src/app/common/seller';

@Component({
  selector: 'app-seller-update',
  templateUrl: './seller-update.component.html',
  styleUrls: ['./seller-update.component.css']
})
export class SellerUpdateComponent implements OnInit {

  id: number;
 seller:Seller;

  constructor(private route: ActivatedRoute,private router: Router,
    private sellerService: SellerService) { }

  ngOnInit() {
    this.seller = new Seller();

    this.id = this.route.snapshot.params['id'];
    
    this.sellerService.getSeller(this.id)
      .subscribe(data => {
        console.log(data)
        this.seller = data;
      }, error => console.log(error));
  }

  updateSeller() {
    this.sellerService.updateSeller(this.id, this.seller)
      .subscribe(data => console.log(data), error => console.log(error));
    this.seller = new Seller();
    this.gotoList();
  }

  onSubmit() {
    this.updateSeller();    
  }

  gotoList() {
    this.router.navigate(['/sellers']);
  }
}
