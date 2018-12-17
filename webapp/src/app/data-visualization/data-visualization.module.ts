import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { StationSelectorComponent } from './station-selector/station-selector.component';
import { StationDetailsComponent } from './station-details/station-details.component';
import { StationPanelComponent } from './station-panel/station-panel.component';

@NgModule({
  declarations: [StationSelectorComponent, StationDetailsComponent, StationPanelComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports : [StationPanelComponent]
})
export class DataVisualizationModule { }
