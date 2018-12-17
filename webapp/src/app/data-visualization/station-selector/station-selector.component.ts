import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { StationService } from '../station-service/station.service';
import { Observable } from 'rxjs';
import { Station } from '../models/station.model';

@Component({
  selector: 'station-selector',
  templateUrl: './station-selector.component.html',
  styleUrls: ['./station-selector.component.css']
})
export class StationSelectorComponent implements OnInit {

  @Input() stations : Array<Station>;
  @Output() select: EventEmitter<Station> = new EventEmitter();

  private selectedStation : Station;

  constructor() { }

  ngOnInit() {
  }

  public onChange(event) {
    this.select.emit(this.selectedStation);
  }

}
