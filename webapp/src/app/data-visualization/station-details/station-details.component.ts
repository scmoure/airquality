import { Component, OnInit, Input } from '@angular/core';
import { Station } from '../models/station.model';

@Component({
  selector: 'station-details',
  templateUrl: './station-details.component.html',
  styleUrls: ['./station-details.component.css']
})
export class StationDetailsComponent implements OnInit {

  @Input() station : Station;
  
  constructor() { }

  ngOnInit() {
  }

}
