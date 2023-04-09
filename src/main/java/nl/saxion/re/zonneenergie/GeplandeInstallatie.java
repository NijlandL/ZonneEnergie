package nl.saxion.re.zonneenergie;

import java.time.LocalDate;

public class GeplandeInstallatie {
    private LocalDate datum;
    private String adres;
    private String team;

    public GeplandeInstallatie(LocalDate datum, String team, String adres) {
        this.datum = datum;
        this.adres = adres;
        this.team = team;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getAdres() {
        return adres;
    }

    @Override
    public String toString() {
        return "Geplande installatie op " + datum + " bij " + adres;
    }
}
