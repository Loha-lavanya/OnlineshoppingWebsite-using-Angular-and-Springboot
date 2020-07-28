import { Order } from './../../common/order';
import { OrderService } from './../../services/order.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders:Order[];
  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
    this.orderService.findAll().subscribe(data =>{
      this.orders=data;
    });
  }
  
}
