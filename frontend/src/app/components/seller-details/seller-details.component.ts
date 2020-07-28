import { SellerService } from './../../services/seller.service';
import { Component, OnInit } from '@angular/core';
import { Seller } from 'src/app/common/seller';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-seller-details',
  templateUrl: './seller-details.component.html',
  styleUrls: ['./seller-details.component.css']
})
export class SellerDetailsComponent implements OnInit {

  id: number;
  seller: Seller;

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

  list(){
    this.router.navigate(['seller']);
  }
}
