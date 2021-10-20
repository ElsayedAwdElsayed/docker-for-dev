import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { PhoneServiceService } from '../phone-service.service';

@Component({
  selector: 'app-phone-list',
  templateUrl: './phone-list.component.html',
  styleUrls: ['./phone-list.component.css']
})
export class PhoneListComponent implements OnInit {

  customers:String[]

  constructor(private phoneService:PhoneServiceService) { }

  ngOnInit() {
    this.phoneService.findAll().subscribe(data => {
      console.log(data);
      
      this.customers = data;
    });
  }

}
