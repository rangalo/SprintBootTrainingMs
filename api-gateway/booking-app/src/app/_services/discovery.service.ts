import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {MicroService} from "../_models/micro-service";
import {timer} from "rxjs/observable/timer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DiscoveryService {

  private servicesSubject: BehaviorSubject<MicroService[]> = new BehaviorSubject([]);

  constructor(private http: HttpClient) {
    const tim = timer(1000, 30000);
    tim.subscribe(() => {
      this._discover();
    });
  }

  get services(): Observable<MicroService[]> {
    return this.servicesSubject.asObservable();
  }

  private _discover(){
    this.http.get<MicroService[]>('api/discovery/list').subscribe(ms => {
      console.log('loaded ms', ms);
      this.servicesSubject.next(ms);
    });
  }


}
