import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProductDTO} from "./ProductDTO";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList : Array<ProductDTO> = new Array<ProductDTO>()

  constructor(private http : HttpClient) { }


  ngOnInit(): void {

    this.http.get('http://localhost:9080/api/v1/product')
      .subscribe(res =>{
        console.log(res)
        this.productList = res as Array<ProductDTO>
      })
  }

}
// {
//   "id": 1,
//   "name": "Tornillo allen M6x30",
//   "price": 1.3,
//   "category": "Tornillos"
// },
