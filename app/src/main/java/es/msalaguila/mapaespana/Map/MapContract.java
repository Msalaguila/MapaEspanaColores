package es.msalaguila.mapaespana.Map;

import java.lang.ref.WeakReference;

import es.msalaguila.mapaespana.Data.ComunidadAutonoma;

interface MapContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MapViewModel viewModel);

    void displayCity(MapViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void touchCoordinates(int x, int y);
  }

  interface Model {
    String fetchData();

    ComunidadAutonoma getCityCoordinates(int x, int y);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MapState state);

    MapState getDataFromPreviousScreen();
  }
}
