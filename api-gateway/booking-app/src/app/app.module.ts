import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventListComponent } from './event-list/event-list.component';
import {EventService} from './_services/event.service';
import { EventListEntryComponent } from './event-list/event-list-entry/event-list-entry.component';
import {HttpModule} from '@angular/http';
import { DiscoveryListComponent } from './discovery-list/discovery-list.component';
import {DiscoveryService} from "./_services/discovery.service";
import {HttpClientModule} from "@angular/common/http";



@NgModule({
  declarations: [
    AppComponent,
    EventListComponent,
    EventListEntryComponent,
    DiscoveryListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [EventService, DiscoveryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
