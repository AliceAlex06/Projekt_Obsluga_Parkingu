package Parking.Config;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Samochody {
    @Id
    @GeneratedValue
    @Column(name = "idSamochodu")
    private int idSamochodu;
    @Column(name = "markaSamochodu")
    private String markaSamochodu;
    @Column(name = "pojemnoscSilnika")
    private double pojemnoscSilnika;
    @Column(name = "numerRejestracyjny")
    private String numerRejestracyjny;
    @Column(name = "nazwiskoWlasciciela")
    private String nazwiskoWlasciciela;

    public Samochody() {
    }

    public Samochody(int idSamochodu, String markaPojazdu, double pojemnoscSilnika, String numerRejestracyjny, String nazwiskoWlasciciela) {
        this.idSamochodu = idSamochodu;
        this.markaSamochodu = markaPojazdu;
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.numerRejestracyjny = numerRejestracyjny;
        this.nazwiskoWlasciciela = nazwiskoWlasciciela;
    }

    public int getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(int idSamochodu) {
        this.idSamochodu = idSamochodu;
    }

    public String getMarkaSamochodu() {
        return markaSamochodu;
    }

    public void setMarkaSamochodu(String markaPojazdu) {
        this.markaSamochodu = markaPojazdu;
    }

    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public void setPojemnoscSilnika(double pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public String getNazwiskoWlasciciela() {
        return nazwiskoWlasciciela;
    }

    public void setNazwiskoWlasciciela(String nazwiskoWlasciciela) {
        this.nazwiskoWlasciciela = nazwiskoWlasciciela;
    }
}
