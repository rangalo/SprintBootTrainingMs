import { Component, OnInit } from '@angular/core';
import {EventService} from '../_services/event.service';
import {EventListEntry} from '../_models/event-list-entry';

@Component({
  selector: 'ba-event-list',
  styleUrls: ['./event-list.component.css'],
  template: `
    <div class="row">
      <div class=" col-md-offset-2 list-group col-md-8">
        <ba-event-list-entry (click)="toggleEntrySelect(ev)" *ngFor="let ev of events" [entry]="ev"></ba-event-list-entry>
      </div>
    </div>
    <div class="row">
      <div class=" col-md-offset-8" >
        <button type="button" *ngIf="selectedEventExists()" (click)="bookSelected()" class="btn btn-primary">book</button>
      </div>
    </div>
    <div *ngIf="bookingNumber" class="row">
      <div class=" col-md-offset-2 col-md-8 alert alert-success">Booking succeeded, your Booking-No.: {{bookingNumber}}</div>
    </div>
  `
})
export class EventListComponent implements OnInit {

  events: EventListEntry[];
  bookingNumber: string;

  constructor(private eventService: EventService) {
  }

  ngOnInit() {
    this._loadEvents();
  }

  private _loadEvents(): void {
    this.eventService.listEvents()
      .subscribe(events => this.events = events);
  }

  toggleEntrySelect(entry: EventListEntry) {
    if (entry.selected) {
      entry.selected = false;
    } else {
      this.events.filter(ev => ev.selected).forEach(ev => ev.selected = false);
      entry.selected = !entry.selected;
    }
  }

  selectedEventExists(): boolean {
    return this.events && this.events.filter(ev => ev.selected).length > 0;
  }

  bookSelected() {
    const selected = this.events.find(ev => ev.selected);
    if (!selected) {
      return;
    }
    this.eventService.bookEvent(selected.id).subscribe(rsp => {
      this.bookingNumber = rsp;
      this._loadEvents();
    });
  }
}
