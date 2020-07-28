import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  private baseUrl = 'http://localhost:8090/api';

  constructor(private http: HttpClient) { }

  getSeller(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/sellers/${id}`);
  }

  createSeller(seller: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/save-sellers`, seller);
  }

  updateSeller(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/sellers/${id}`, value);
  }

  deleteSeller(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/sellers/${id}`, { responseType: 'text' });
  }

  getSellersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getSellers`);
  }
}
