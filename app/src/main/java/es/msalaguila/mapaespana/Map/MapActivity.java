package es.msalaguila.mapaespana.Map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
      public boolean onTouch(View view, MotionEvent event) {
        Drawable imgDrawable = ((ImageView) view).getDrawable();
        //imgDrawable will not be null if you had set src to ImageView, in case of background drawable it will be null
        Bitmap bitmap = ((BitmapDrawable) imgDrawable).getBitmap();

        Matrix inverse = new Matrix();
        ((ImageView) view).getImageMatrix().invert(inverse);
        float[] touchPoint = new float[]{event.getX(), event.getY()};
        inverse.mapPoints(touchPoint);
        int xCoord = (int) touchPoint[0];
        int yCoord = (int) touchPoint[1];

        if ((yCoord >= 0) && (yCoord < bitmap.getHeight())) {
          int touchedRGB = bitmap.getPixel(xCoord, yCoord);

          //then do what you want with the pixel data, e.g
          int redValue = Color.red(touchedRGB);
          int greenValue = Color.green(touchedRGB);
          int blueValue = Color.blue(touchedRGB);
          int alphaValue = Color.alpha(touchedRGB);

          int colorValue = Color.argb(alphaValue, redValue, greenValue, blueValue);
          Log.i("TouchedColor", "ColorValue ARGB: " + colorValue);

          presenter.touchedColor(colorValue);
        }
        return false;
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
  public void displayCityWithColor(MapViewModel viewModel) {
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
      if (mediaPlayer != null) {
        mediaPlayer.release();
        mediaPlayer = null;
      }
    }
  }
}
