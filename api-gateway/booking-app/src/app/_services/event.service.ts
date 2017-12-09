import {Injectable} from '@angular/core';
import {EventListEntry} from '../_models/event-list-entry';
import {Observable} from 'rxjs/Observable';
import {Http, Response} from '@angular/http';

@Injectable()
export class EventService {

  constructor(private http: Http) {
  }

  listEvents(): Observable<EventListEntry[]> {
    return this.http.get('/api/ev/events')
      .map(response => {
        const json = response.json();
        return json._embedded.events;
      });
  }

  bookEvent(id: string): Observable<string> {
    return this.http.post( `/api/event/book/${id}`, {}).map((rsp: Response) => rsp.text());
  }

}
