import {Component, Input, OnInit} from '@angular/core';
import {EventListEntry} from '../../_models/event-list-entry';

@Component({
  selector: 'ba-event-list-entry',
  template: `
    <a href="#" [class.active]="entry.selected" class="list-group-item">
       {{entry.name}} has {{entry.ticketCount - entry.ticketsBooked}} tickets left.
      <ul *ngIf="entry.selected">
        {{entry.description}}
      </ul>
    </a>
  `,
  styles: []
})
export class EventListEntryComponent implements OnInit {

  @Input() entry: EventListEntry;

  constructor() {

  }

  ngOnInit() {
  }

}
