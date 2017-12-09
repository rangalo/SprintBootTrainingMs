import { Component, OnInit } from '@angular/core';
import {DiscoveryService} from "../_services/discovery.service";

@Component({
  selector: 'ba-discovery-list',
  styleUrls: ['./discovery-list.component.css'],
  template: `
    <h2>Services</h2>
    <div *ngFor="let service of services | async" class="row">
      <div class="col-md-2">{{service.name}}</div>
      <div *ngFor="let instance of service.instances" f class="col-md-3">
          {{instance.status}}<br/>
          {{instance.url}}
      </div>
    </div>
  `
})
export class DiscoveryListComponent implements OnInit {

  constructor(private discoveryService: DiscoveryService) { }

  ngOnInit() {
  }

  get services() {
    return this.discoveryService.services;
  }

}
