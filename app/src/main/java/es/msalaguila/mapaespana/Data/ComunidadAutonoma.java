package es.msalaguila.mapaespana.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ComunidadAutonoma {

  private ArrayList<Cuadrado> cuadrados;
  private String nombreComunidad;
  private int himnoURI;

  public ComunidadAutonoma(ArrayList<Cuadrado> cuadrados, String nombreComunidad, int himnoURI) {
    this.cuadrados = cuadrados;
    this.nombreComunidad = nombreComunidad;
    this.himnoURI = himnoURI;
  }

  public void setCuadrados(ArrayList<Cuadrado> cuadrados) {
    this.cuadrados = cuadrados;
  }

  public void setNombreComunidad(String nombreComunidad) {
    this.nombreComunidad = nombreComunidad;
  }

  public void setHimnoURI(int himnoURI) {
    this.himnoURI = himnoURI;
  }

  public int getHimnoURI() {
    return himnoURI;
  }

  public ArrayList<Cuadrado> getCuadrados() {
    return cuadrados;
  }

  public String getNombreComunidad() {
    return nombreComunidad;
  }


}
