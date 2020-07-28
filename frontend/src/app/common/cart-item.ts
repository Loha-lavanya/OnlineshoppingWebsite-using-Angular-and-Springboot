
import { ProductService } from './../services/product.service';
import { User } from 'src/app/common/user';
import { Product } from './product';

export class CartItem {

    id: string;
    name: string;
    imageUrl: string;
    unitPrice: number;
    quantity: number;
    productid:string;
    username:string;

    constructor(product: Product,userName:string) {
        this.username=userName;
        this.productid=product.id;
        this.id = product.id;
        this.name = product.name;
        this.imageUrl = product.imageUrl;
        this.unitPrice = product.unitPrice;
        this.quantity = 1;
     
    }
}
