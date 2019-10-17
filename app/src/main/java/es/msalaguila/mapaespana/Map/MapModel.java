package es.msalaguila.mapaespana.Map;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.msalaguila.mapaespana.Data.ComunidadAutonoma;
import es.msalaguila.mapaespana.Data.Cuadrado;
import es.msalaguila.mapaespana.R;

public class MapModel implements MapContract.Model {

  public static String TAG = MapModel.class.getSimpleName();
  public ArrayList<ComunidadAutonoma> comunidadAutonomas = new ArrayList<>();

  public MapModel() {
    iniciarComunidades();
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public ComunidadAutonoma getCityColor(int color) {
    ComunidadAutonoma comunidadAutonoma = new ComunidadAutonoma(new ArrayList<Cuadrado>()
            , "", 0);

    for (ComunidadAutonoma comunidad: comunidadAutonomas) {
      int colorComunidad = comunidad.getColor();

      if (colorComunidad == color) {
        return comunidad;
      }

    }
    return comunidadAutonoma;
  }

  private void iniciarComunidades() {
    iniciarCanarias();
    iniciarExtremadura();
    iniciarMurcia();
    iniciarAndalucia();
    iniciarCastillaMancha();
    inicarMadrid();
    inicarGalicia();
    inicarAsturias();
    inicarCantabria();
    inicarPaisVasco();
    inicarLaRioja();
    inicarNavarra();
    inicarCastillaYLeon();
    inicarAragon();
    inicarComunidadValenciana();
    inicarIslasBaleares();
    inicarCataluna();
  }

  private void iniciarCanarias() {
    int color = -65408;
    Cuadrado canarias1 = new Cuadrado(13,366,1016,1161);
    ArrayList<Cuadrado> canariasCuad = new ArrayList<>();
    canariasCuad.add(canarias1);
    ComunidadAutonoma canarias = new ComunidadAutonoma(color, canariasCuad, "Canarias",0);
    comunidadAutonomas.add(canarias);
  }

  private void iniciarExtremadura() {
    int color = -9399618;
    Cuadrado c1 = new Cuadrado(336,488,715,884);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Extremadura",0);
    comunidadAutonomas.add(comunidad);
  }

  private void iniciarMurcia() {
    int color = -12582848;
    Cuadrado c1 = new Cuadrado(663,769,857,941);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Murcia",0);
    comunidadAutonomas.add(comunidad);
  }

  private void iniciarAndalucia(){
    int color = -3620889;
    Cuadrado c1 = new Cuadrado(363,690,892,1055);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Andalucía", R.raw.andalucia);
    comunidadAutonomas.add(comunidad);
  }

  private void iniciarCastillaMancha() {
    int color = -1055568;
    Cuadrado c1 = new Cuadrado(487,714,735,870);
    Cuadrado c2 = new Cuadrado(600,727,645,750);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Castilla La Mancha",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarMadrid(){
    int color = -14066;
    Cuadrado c1 = new Cuadrado(565,600,652,679);
    Cuadrado c2 = new Cuadrado(524,617,684,740);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Madrid"
            ,R.raw.madrid);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarGalicia(){
    int color = -1237980;
    Cuadrado c1 = new Cuadrado(260,387,427,564);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Galicia",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarAsturias(){
    int color = -32985;
    Cuadrado c1 = new Cuadrado(387,521,444,483);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Asturias",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarCantabria(){
    int color = -3584;
    Cuadrado c1 = new Cuadrado(519,573,461,508);
    Cuadrado c2 = new Cuadrado(570,609,459,488);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Cantabria",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarPaisVasco(){
    int color = -14503604;
    Cuadrado c1 = new Cuadrado(612,673,466,515);
    Cuadrado c2 = new Cuadrado(668,700,468,486);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Pais Vasco",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarLaRioja(){
    int color = -20791;
    Cuadrado c1 = new Cuadrado(624,695,527,581);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "La Rioja",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarNavarra(){
    int color = -16735512;
    Cuadrado c1 = new Cuadrado(675,727,505,579);
    Cuadrado c2 = new Cuadrado(688,754,281,517);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Navarra",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarAragon(){
    int color = -6075996;
    Cuadrado c1 = new Cuadrado(697,788,583,733);
    Cuadrado c2 = new Cuadrado(729,827,505,664);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Aragón",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarCastillaYLeon(){
    int color = -4621737;
    Cuadrado c1 = new Cuadrado(397,539,498,711);
    Cuadrado c2 = new Cuadrado(504,617,493,635);
    Cuadrado c3 = new Cuadrado(619,683,574,647);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    cuads.add(c3);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Castilla y León",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarComunidadValenciana(){
    int color = -4856291;
    Cuadrado c1 = new Cuadrado(734,815,742,906);
    Cuadrado c2 = new Cuadrado(790,832,686,728);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Comunidad Valenciana",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarIslasBaleares(){
    int color = -6694422;
    Cuadrado c1 = new Cuadrado(844,1074,708,865);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma
            comunidad = new ComunidadAutonoma(color, cuads, "Islas Baleares",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarCataluna(){
    int color = -3947581;
    Cuadrado c1 = new Cuadrado(837,993,512,756);
    Cuadrado c2 = new Cuadrado(841,937,576,625);
    Cuadrado c3 = new Cuadrado(832,866,635,681);
    Cuadrado c4 = new Cuadrado(839,937,581,625);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    cuads.add(c3);
    cuads.add(c4);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(color, cuads, "Cataluña",0);
    comunidadAutonomas.add(comunidad);
  }

}