package es.msalaguila.mapaespana.Data;

import android.app.Application;

import es.msalaguila.mapaespana.Map.MapState;

public class AppMediator extends Application {

  private MapState mapState = new MapState();

  public MapState getMapState() {
    return mapState;
  }

  public void setMapState(MapState state) {
    this.mapState = state;
  }
}
