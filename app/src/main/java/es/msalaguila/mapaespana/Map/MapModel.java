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
  public ComunidadAutonoma getCityCoordinates(int x, int y) {

    ComunidadAutonoma comunidadAutonoma = new ComunidadAutonoma(new ArrayList<Cuadrado>()
            , "", 0);

    for (ComunidadAutonoma comunidad: comunidadAutonomas) {
      for (Cuadrado cuadrado: comunidad.getCuadrados()) {

        int x1 = cuadrado.getX1();
        int x2 = cuadrado.getX2();
        int y1 = cuadrado.getY1();
        int y2 = cuadrado.getY2();

        if ((x1 <= x && x <= x2) && (y1 <= y && y <= y2)) {

          String nombreComunidad = comunidad.getNombreComunidad();
          int himnoUri = comunidad.getHimnoURI();

          comunidadAutonoma.setHimnoURI(himnoUri);
          comunidadAutonoma.setNombreComunidad(nombreComunidad);

          return comunidadAutonoma;
        }
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
    Cuadrado canarias1 = new Cuadrado(13,366,1016,1161);
    ArrayList<Cuadrado> canariasCuad = new ArrayList<>();
    canariasCuad.add(canarias1);
    ComunidadAutonoma canarias = new ComunidadAutonoma(canariasCuad, "Canarias",0);
    comunidadAutonomas.add(canarias);
  }

  private void iniciarExtremadura() {
    Cuadrado c1 = new Cuadrado(336,488,715,884);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Extremadura",0);
    comunidadAutonomas.add(comunidad);
  }

  private void iniciarMurcia() {
    Cuadrado c1 = new Cuadrado(663,769,857,941);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Murcia",0);
    comunidadAutonomas.add(comunidad);
  }

  private void iniciarAndalucia(){
    Cuadrado c1 = new Cuadrado(363,690,892,1055);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Andalucía", R.raw.himno_de_andalucia_letra);
    comunidadAutonomas.add(comunidad);
  }

  private void iniciarCastillaMancha() {
    Cuadrado c1 = new Cuadrado(487,714,735,870);
    Cuadrado c2 = new Cuadrado(600,727,645,750);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Castilla La Mancha",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarMadrid(){
    Cuadrado c1 = new Cuadrado(565,600,652,679);
    Cuadrado c2 = new Cuadrado(524,617,684,740);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Madrid"
            ,R.raw.himno_de_la_comunidad_de_madrid_letra_himno_regional_espanol);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarGalicia(){
    Cuadrado c1 = new Cuadrado(260,387,427,564);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Galicia",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarAsturias(){
    Cuadrado c1 = new Cuadrado(387,521,444,483);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Asturias",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarCantabria(){
    Cuadrado c1 = new Cuadrado(519,573,461,508);
    Cuadrado c2 = new Cuadrado(570,609,459,488);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Cantabria",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarPaisVasco(){
    Cuadrado c1 = new Cuadrado(612,673,466,515);
    Cuadrado c2 = new Cuadrado(668,700,468,486);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Pais Vasco",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarLaRioja(){
    Cuadrado c1 = new Cuadrado(624,695,527,581);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "La Rioja",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarNavarra(){
    Cuadrado c1 = new Cuadrado(675,727,505,579);
    Cuadrado c2 = new Cuadrado(688,754,281,517);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Navarra",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarAragon(){
    Cuadrado c1 = new Cuadrado(697,788,583,733);
    Cuadrado c2 = new Cuadrado(729,827,505,664);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Aragón",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarCastillaYLeon(){
    Cuadrado c1 = new Cuadrado(397,539,498,711);
    Cuadrado c2 = new Cuadrado(504,617,493,635);
    Cuadrado c3 = new Cuadrado(619,683,574,647);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    cuads.add(c3);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Castilla y León",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarComunidadValenciana(){
    Cuadrado c1 = new Cuadrado(734,815,742,906);
    Cuadrado c2 = new Cuadrado(790,832,686,728);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Comunidad Valenciana",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarIslasBaleares(){
    Cuadrado c1 = new Cuadrado(844,1074,708,865);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Islas Baleares",0);
    comunidadAutonomas.add(comunidad);
  }

  private void inicarCataluna(){
    Cuadrado c1 = new Cuadrado(837,993,512,756);
    Cuadrado c2 = new Cuadrado(841,937,576,625);
    Cuadrado c3 = new Cuadrado(832,866,635,681);
    Cuadrado c4 = new Cuadrado(839,937,581,625);
    ArrayList<Cuadrado> cuads = new ArrayList<>();
    cuads.add(c1);
    cuads.add(c2);
    cuads.add(c3);
    cuads.add(c4);
    ComunidadAutonoma comunidad = new ComunidadAutonoma(cuads, "Cataluña",0);
    comunidadAutonomas.add(comunidad);
  }

}