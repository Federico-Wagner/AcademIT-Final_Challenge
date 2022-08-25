import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import { Router } from '@angular/router';
import {HttpClient} from "@angular/common/http";
import {NewVendorDTO} from "./NewVendorDTO";

@Component({
  selector: 'app-new-vendor',
  templateUrl: './new-vendor.component.html',
  styleUrls: ['./new-vendor.component.css']
})
export class NewVendorComponent implements OnInit {

  newVendorForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(60)]],
      salary: ['', [Validators.required]]
    },
  );
  msg : string = ""
  vendorDTO : NewVendorDTO = new NewVendorDTO()

  constructor(private fb: FormBuilder, private router:Router, private http: HttpClient) { }
  ngOnInit(): void {
  }

  onSubmit() {
    // @ts-ignore
    this.vendorDTO.name = this.newVendorForm.value.name
    // @ts-ignore
    this.vendorDTO.salary = this.newVendorForm.value.salary
    this.http.post('http://localhost:9080/api/v1/vendor', this.vendorDTO)
      .subscribe(res => {
        let response = res as Response
        if (response.id != null){
          this.router.navigate(["/"])
        }else {
          this.msg = "Could not Create new Vendor"
        }
      })
  }
}

class Response{
  "commissions": number
  "id" : number
  "name" : string
  "slary" : number
}
