import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {VendorDTO} from "./VendorDTO";

@Component({
  selector: 'app-vendors-list',
  templateUrl: './vendors-list.component.html',
  styleUrls: ['./vendors-list.component.css']
})
export class VendorsListComponent implements OnInit {

  vendorList : Array<VendorDTO> = new Array<VendorDTO>()

  constructor(private http : HttpClient) { }

  ngOnInit(): void {

    this.http.get('http://localhost:9080/api/v1/vendor')
      .subscribe(res =>{
        console.log(res)
        this.vendorList = res as Array<VendorDTO>
      })
  }
}

