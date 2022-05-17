package com.monyert.studentswork3.Model;

public class Tenda {
    String Codi;
    String Tenda;
    double Lat;
    double Lon;
    String Poblacio;
    int Telefon;
    String Adresa;
    String Foto;

    public Tenda(String codi, String tenda, double lat, double lon, String poblacio, int telefon, String adresa, String foto) {
        Codi = codi;
        Tenda = tenda;
        Lat = lat;
        Lon = lon;
        Poblacio = poblacio;
        Telefon = telefon;
        Adresa = adresa;
        Foto = foto;
    }

    public Tenda() {
    }

    public String getCodi() {
        return Codi;
    }

    public void setCodi(String codi) {
        Codi = codi;
    }

    public String getTenda() {
        return Tenda;
    }

    public void setTenda(String tenda) {
        Tenda = tenda;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLon() {
        return Lon;
    }

    public void setLon(double lon) {
        Lon = lon;
    }

    public String getPoblacio() {
        return Poblacio;
    }

    public void setPoblacio(String poblacio) {
        Poblacio = poblacio;
    }

    public int getTelefon() {
        return Telefon;
    }

    public void setTelefon(int telefon) {
        Telefon = telefon;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }
}
