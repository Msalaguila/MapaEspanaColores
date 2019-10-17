package es.msalaguila.mapaespana.Map;

import java.lang.ref.WeakReference;

import es.msalaguila.mapaespana.Data.ComunidadAutonoma;

interface MapContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MapViewModel viewModel);

    void displayCityWithColor(MapViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void touchedColor(int color);
  }

  interface Model {
    String fetchData();

    ComunidadAutonoma getCityColor(int color);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MapState state);

    MapState getDataFromPreviousScreen();
  }
}
