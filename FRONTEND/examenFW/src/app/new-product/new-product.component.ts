import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {NewVendorDTO} from "../new-vendor/NewVendorDTO";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {NewProductDTO} from "./NewProductDTO";

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  newProductForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(60)]],
      price: ['', [Validators.required]],
      category: ['', [Validators.required]]
    },
  );
  msg : string = ""
  productDTO : NewProductDTO = new NewProductDTO()

  constructor(private fb: FormBuilder, private router:Router, private http: HttpClient) { }
  ngOnInit(): void {
  }

  onSubmit() {
    // @ts-ignore
    this.productDTO.name = this.newProductForm.value.name
    // @ts-ignore
    this.productDTO.price = this.newProductForm.value.price
    // @ts-ignore
    this.productDTO.category = this.newProductForm.value.category
    console.log(this.productDTO)
    this.http.post('http://localhost:9080/api/v1/product', this.productDTO)
      .subscribe(res => {
        console.log(res)
        // let response = res as Response
        // if (response.id != null){
        //   this.router.navigate(["/"])
        // }else {
        //   this.msg = "Could not Create new Product"
        // }
      })
  }
}

class Response{
  "commissions": number
  "id" : number
  "name" : string
  "slary" : number
}
