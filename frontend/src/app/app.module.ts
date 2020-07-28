import { CheckoutComponent } from './components/checkout/checkout.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgxPayPalModule } from 'ngx-paypal';
import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';

import { Routes, RouterModule} from '@angular/router';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';

import {MatButtonModule} from '@angular/material/button';
import { MatCheckboxModule} from '@angular/material/checkbox';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule} from '@angular/material/input';
import { MatRadioModule} from '@angular/material/radio';
import { MatSelectModule} from '@angular/material/select';
import { MatSlideToggleModule} from '@angular/material/slide-toggle';
import { MatSliderModule } from '@angular/material/slider';

import{FormsModule} from '@angular/forms';
import { FooterlineComponent } from './components/footerline/footerline.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { ContactusComponent } from './components/contactus/contactus.component';
import { HelpComponent } from './components/help/help.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';

import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { CreateSellerComponent } from './components/create-seller/create-seller.component';
import { SellerDetailsComponent } from './components/seller-details/seller-details.component';
import { SellerListComponent } from './components/seller-list/seller-list.component';
import { SellerUpdateComponent } from './components/seller-update/seller-update.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { AdminProductListComponent } from './components/admin-product-list/admin-product-list.component';
import { AddImageComponent } from './components/add-image/add-image.component';
import { DeleteImageComponent } from './components/delete-image/delete-image.component';
import { PaymentComponent } from './components/payment/payment.component';
import { OrderListComponent } from './components/order-list/order-list.component';



const routes: Routes = [
  {path: 'category', component: ProductListComponent},
  {path: 'home', component:HomeComponent},
  {path: 'user', component: UserComponent},
  
  {path: 'admin',component: AdminComponent},

  {path: 'payment', component:PaymentComponent },

  {path: 'sellers', component:SellerListComponent },
  {path: 'add', component: CreateSellerComponent },
  {path: 'update/:id', component: SellerUpdateComponent },
  {path: 'details/:id', component: SellerDetailsComponent },
  {path:'userlist',component:UserListComponent},
  {path:'adminproductlist',component:AdminProductListComponent},
  {path:'addproduct',component:AddImageComponent},

  {path:'aboutus',component:AboutusComponent},
  {path:'contactus',component: ContactusComponent},
  {path:'help',component:HelpComponent},
  {path:'checkout',component:CheckoutComponent},
  {path:'orderlist',component:OrderListComponent},
 

  {path: 'cart-details', component: CartDetailsComponent},
  {path: 'products/:id', component: ProductDetailsComponent},
  {path: 'search/:keyword', component: ProductListComponent},
  {path: 'category/:id', component: ProductListComponent},
  
  {path: 'auth/login',component: LoginComponent},
  {path: 'signup',component: RegisterComponent},
  {path: 'products', component: ProductListComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCategoryMenuComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    FooterlineComponent,
    AboutusComponent,
    ContactusComponent,
    HelpComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
   
    LoginComponent,
    AdminComponent,
    CreateSellerComponent,
    SellerDetailsComponent,
    SellerListComponent,
    SellerUpdateComponent,
    UserListComponent,
    AdminProductListComponent,
    AddImageComponent,
    DeleteImageComponent,
    PaymentComponent,
    OrderListComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,

    MatButtonModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,

    NgxPayPalModule 


  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
