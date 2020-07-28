import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from '../common/order';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  private orderlistUrl = 'http://localhost:8090/api/auth/orders';
  private userorderUrl = 'http://localhost:8090/api/auth';

  public findAll(): Observable<Order[]> {
    return this.http.get<Order[]>(this.orderlistUrl);
  }

  getOrder(username: string): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.userorderUrl}/orderUser/${username}`);
  }
}
