import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Station } from '../models/station.model';

@Injectable({
  providedIn: 'root'
})
export class StationService {

  private stations = new BehaviorSubject<Array<Station>>(null);

  private stationsMock = new Array<Station>();

  constructor() { 
    let pzaEspStation = new Station();
    pzaEspStation.id = 1;
    pzaEspStation.name = 'Pza. de España';
    let pzaCibelesStation = new Station();
    pzaCibelesStation.id = 2;
    pzaCibelesStation.name = 'Pza. de Cibeles';
    this.stationsMock.push(pzaEspStation, pzaCibelesStation);
  }

  public getStations(): Observable<Array<Station>> {
    this.sendStations();
    return this.stations;
  }

  private sendStations() {
    setTimeout(() => {
      this.stations.next(this.stationsMock);      
    }, 3000);
  }

  public getStation(id : Number): Observable<Station> {
    let station = new BehaviorSubject<Station>(null);
    setTimeout(() => {
      station.next(this.stationsMock.find(station => station.id === id));      
    }, 3000);

    return station;
  }

}
