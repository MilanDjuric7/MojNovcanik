public class Racun {
    private int brojRacuna;
    private double inicijalnoStanjeRacuna;

    public Racun(int brojRacuna, double inicijalnoStanjeRacuna) {
        this.brojRacuna = brojRacuna;
        this.inicijalnoStanjeRacuna = inicijalnoStanjeRacuna;
    }

    public Racun(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public double getStanjeNaRacunu() {
        return inicijalnoStanjeRacuna;
    }

    public void setStanjeNaRacunu(double stanjeNaRacunu) {
        this.inicijalnoStanjeRacuna = stanjeNaRacunu;
    }

    public void dodaj(double vrednost) {
        this.inicijalnoStanjeRacuna += vrednost;
    }

    public void preuzmi(double vrednost) {
        this.inicijalnoStanjeRacuna -= vrednost;
    }
}
