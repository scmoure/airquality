import { Component, OnInit } from '@angular/core';
import { StationService } from '../station-service/station.service';
import { Observable } from 'rxjs';
import { Station } from '../models/station.model';

@Component({
  selector: 'station-panel',
  templateUrl: './station-panel.component.html',
  styleUrls: ['./station-panel.component.css']
})
export class StationPanelComponent implements OnInit {

  stations : Observable<Array<Station>>;
  selectedStation : Station;

  constructor(private satationService : StationService) { }

  ngOnInit() {
    this.stations = this.satationService.getStations();
    this.selectedStation = new Station();
  }

  showStation(station) {  
    this.selectedStation = station;
  }

}
