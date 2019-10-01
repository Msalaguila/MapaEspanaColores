package es.msalaguila.mapaespana.Map;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import es.msalaguila.mapaespana.R;

public class MapActivity
        extends AppCompatActivity implements MapContract.View {

  public static String TAG = MapActivity.class.getSimpleName();

  private MapContract.Presenter presenter;
  private ImageView fondoPantalla;
  private MediaPlayer mediaPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);

    // do the setup
    MapScreen.configure(this);

    fondoPantalla = findViewById(R.id.fondo);
    fondoPantalla.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){

          int x = (int) event.getX();
          int y = (int) event.getY();

          String text = "X: " + String.valueOf(event.getX()) + " Y: " + String.valueOf(event.getY());
          Log.d("Coordinates", text);
          presenter.touchCoordinates(x,y);
        }
        return true;
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(MapContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MapViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  @Override
  public void displayCity(MapViewModel viewModel) {

    String nombreComunidad = viewModel.comunidadAutonoma.getNombreComunidad();
    int himnoURI = viewModel.comunidadAutonoma.getHimnoURI();
    Log.d("Himno URI", String.valueOf(himnoURI));

    if (!nombreComunidad.equals("")) {
      Toast.makeText(getApplicationContext(), nombreComunidad, Toast.LENGTH_SHORT).show();
    }

    if (himnoURI != 0) {
      if (mediaPlayer == null) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), himnoURI);
        mediaPlayer.start();
      } else {
        mediaPlayer.release();
        mediaPlayer = null;
        mediaPlayer = MediaPlayer.create(getApplicationContext(), himnoURI);
        mediaPlayer.start();
      }
    } else {
      mediaPlayer.release();
      mediaPlayer = null;
    }

  }
}
