import { Component, OnInit } from '@angular/core';
import {FormBuilder, NgForm, Validators} from "@angular/forms";
import {NewProductDTO} from "../new-product/NewProductDTO";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {ProductDTO} from "../product-list/ProductDTO";
import {VendorDTO} from "../vendors-list/VendorDTO";

@Component({
  selector: 'app-new-sale',
  templateUrl: './new-sale.component.html',
  styleUrls: ['./new-sale.component.css']
})
export class NewSaleComponent implements OnInit {

  newProductForm = this.fb.group({
    vendor_id: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(60)]],
      price: ['', [Validators.required]],
      category: ['', [Validators.required]]
    },
  );
  productList : Array<ProductDTO> = new Array<ProductDTO>()
  vendorList : Array<VendorDTO> = new Array<VendorDTO>()

  constructor(private fb: FormBuilder, private router:Router, private http: HttpClient) { }
  ngOnInit(): void {
    this.http.get('http://localhost:9080/api/v1/product')
      .subscribe(res =>{
        console.log(res)
        this.productList = res as Array<ProductDTO>
      })
    this.http.get('http://localhost:9080/api/v1/vendor')
      .subscribe(res =>{
        console.log(res)
        this.vendorList = res as Array<VendorDTO>
      })

  }

  onSubmit(newSaleForm : NgForm) {
    console.log(newSaleForm.value)
    // // @ts-ignore
    // this.productDTO.name = this.newProductForm.value.name
    // // @ts-ignore
    // this.productDTO.price = this.newProductForm.value.price
    // // @ts-ignore
    // this.productDTO.category = this.newProductForm.value.category
    // console.log(this.productDTO)
    // this.http.post('http://localhost:9080/api/v1/product', this.productDTO)
    //   .subscribe(res => {
    //     console.log(res)
    //   })
  }
}
