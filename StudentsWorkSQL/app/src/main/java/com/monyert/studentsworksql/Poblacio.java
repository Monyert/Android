package com.monyert.studentsworksql;

public class Poblacio {

    String Codi;
    String Poblacio;
    double Lat;
    double Lon;

    public Poblacio(String Codi, String Poblacio, double Lat, double Lon) {
        this.Codi = Codi;
        this.Poblacio = Poblacio;
        this.Lat = Lat;
        this.Lon = Lon;
    }

    public Poblacio() {

    }


    public String getCodi() {
        return Codi;
    }

    public void setCodi(String codi) {
        Codi = codi;
    }

    public String getPoblacio() {
        return Poblacio;
    }

    public void setPoblacio(String poblacio) {
        Poblacio = poblacio;
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
}
