package es.msalaguila.mapaespana.Map;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.msalaguila.mapaespana.Data.ComunidadAutonoma;

public class MapPresenter implements MapContract.Presenter {

  public static String TAG = MapPresenter.class.getSimpleName();

  private WeakReference<MapContract.View> view;
  private MapViewModel viewModel;
  private MapContract.Model model;
  private MapContract.Router router;

  public MapPresenter(MapState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MapContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MapContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MapContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    MapState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void touchCoordinates(int x, int y) {
    ComunidadAutonoma comunidadAutonoma = model.getCityCoordinates(x, y);
    viewModel.comunidadAutonoma = comunidadAutonoma;
    view.get().displayCity(viewModel);
  }


}
