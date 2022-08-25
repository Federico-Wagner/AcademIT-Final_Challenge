import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewVendorComponent } from './new-vendor/new-vendor.component';
import { NewProductComponent } from './new-product/new-product.component';
import { NewSaleComponent } from './new-sale/new-sale.component';
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from "./home/home.component";
import { VendorsListComponent } from './vendors-list/vendors-list.component';
import { ProductListComponent } from './product-list/product-list.component';


@NgModule({
  declarations: [
    AppComponent,
    NewVendorComponent,
    NewProductComponent,
    NewSaleComponent,
    VendorsListComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'product', component: ProductListComponent},
      {path: 'product/create', component: NewProductComponent},
      {path: 'vendor', component: VendorsListComponent},
      {path: 'vendor/create', component: NewVendorComponent},
      {path: 'sale', component: NewSaleComponent},
      {path: '**', redirectTo: "/"}
    ]),
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
