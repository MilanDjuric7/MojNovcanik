import java.util.ArrayList;
import java.util.List;

public class Korisnik {
    private String korisnickoIme;
    private String sifra;
    private List<Racun> racuni = new ArrayList<>();

    public Korisnik(String korisnickoIme, String sifra){
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void dodajRacun(int brojRacuna, double inicijalnoStanjeRacuna) {
        Racun racun = new Racun(brojRacuna, inicijalnoStanjeRacuna);

        racuni.add(racun);

        System.out.println("Racun je uspesno kreiran.");
    }

    public void ukiniRacun(int brojRacuna) {
        Racun racun = null;

       for (Racun r : racuni) {
            if (r.getBrojRacuna() == brojRacuna) {
                racun = r;
            }
        }

        if (racun != null) {
            racuni.remove(racun);
            System.out.println("Racun je uspesno ukinut.");
        }
        else {
            System.out.println("Nepostojeci racun.");
        }
    }

    public void dodajNovacNaRacun(int brojRacuna, double dodajNovac) {
        Racun racun = null;

        for (Racun r : racuni) {
            if (r.getBrojRacuna() == brojRacuna) {
                racun = r;
            }
        }

        if (racun != null) {
            racun.dodaj(dodajNovac);
            System.out.println("Novac je uspesno dodat na izabrani racun.");
        }
        else {
            System.out.println("Nepostojeci racun.");
        }
    }

    public void preuzmiNovac(int brojRacuna, double preuzmiNovac) {
        Racun racun = null;

        for (Racun r : racuni) {
            if (r.getBrojRacuna() == brojRacuna) {
                racun = r;
            }
        }

        if (racun != null && preuzmiNovac < racun.getStanjeNaRacunu()) {
            racun.preuzmi(preuzmiNovac);
            System.out.println("Novac je uspesno preuzet sa izabranog racuna.");
        }
        else {
            System.out.println("Nepostojeci racun.");
        }
    }
}
