import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Korisnik> korisnici = new ArrayList<>();
        Korisnik ulogovanKorisnik = null;

        System.out.println("\nDobrodosli u aplikaciju Moj Novcanik\n");

        while (true){

            System.out.println("Izaberite opciju: \n");


            if (ulogovanKorisnik == null) {
                System.out.println("1. Registracija - Sign up");
                System.out.println("2. Login");
            }
            else {
                System.out.println("3. Stampaj korisnike");
                System.out.println("4. Novi racun");
                System.out.println("5. Ukini racun");
                System.out.println("6. Dodaj novac na racun");
                System.out.println("7. Preuzmi novac sa racuna");
                System.out.println("8. Zameni novac");
                System.out.println("9. Kupi");
                System.out.println("10. Stampaj racune");
            }

            System.out.println("0. Exit\n");


            System.out.print("Opcija: ");

            String opcija = sc.nextLine();
            System.out.println();

            if (opcija.equalsIgnoreCase("1")) {

                System.out.print("Unesite korisnicko ime (Username): ");
                String korisnickoIme = sc.nextLine();

                System.out.print("Unesite sifru (Password): ");
                String sifra = sc.nextLine();

                Korisnik korisnik = new Korisnik(korisnickoIme, sifra);

                korisnici.add(korisnik);

                System.out.println("Korisnik je registrovan.");
            }

            else if (opcija.equalsIgnoreCase("2")) {

                for (int i = 0; i < 3; i++) {
                    System.out.print("Unesite korisnicko ime: ");
                    String korisnickoIme = sc.nextLine();

                    System.out.print("Unesite sifru: ");
                    String sifra = sc.nextLine();

                    for (Korisnik k : korisnici) {
                        if (k.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
                                k.getSifra().equals(sifra)) {
                            ulogovanKorisnik = k;
                        }
                    }

                    if (ulogovanKorisnik != null) {
                        System.out.println("Korisnik je uspesno ulogovan.");
                        break;
                    }
                    else {
                        System.out.println("Pogresno Ste uneli korisnicko ime ili sifru.");
                    }
                }
                if (ulogovanKorisnik == null) {
                    System.out.println("Vise od tri puta ste uneli pogresne podatke." +
                            "Vas nalog je blokiran.");       // Nedostaje kod za blokiranje korisnika
                }
            }

            else if (opcija.equalsIgnoreCase("3")) {

                System.out.println("Korisnici: ");
                for (Korisnik k : korisnici) {
                    System.out.println(k.getKorisnickoIme());
                }
            }

            else if (opcija.equalsIgnoreCase("4")) {

                System.out.print("Unesite broj racuna: ");
                int brojRacuna = sc.nextInt();

                System.out.print("Unesite stanje na racunu: ");
                double inicijalnoStanjeRacuna = sc.nextDouble();

                sc.nextLine();                      // pokupio Enter viska (dva puta se vracao na meni)

                ulogovanKorisnik.dodajRacun(brojRacuna,inicijalnoStanjeRacuna);
            }

            else if (opcija.equalsIgnoreCase("5")) {

                System.out.print("Unesite broj racuna koji Zelite da ukinete: ");
                int brojRacuna = sc.nextInt();

                sc.nextLine();

                ulogovanKorisnik.ukiniRacun(brojRacuna);
            }

            else if (opcija.equalsIgnoreCase("6")) {

                System.out.print("Unesite broj racuna na koji Zelite da dodate novac: ");
                int brojRacuna = sc.nextInt();

                System.out.print("Unesite koliko novca Zelite da dodate na racun: ");
                double dodajNovac = sc.nextDouble();

                sc.nextLine();

                ulogovanKorisnik.dodajNovacNaRacun(brojRacuna, dodajNovac);
            }

            else if (opcija.equalsIgnoreCase("7")) {

                System.out.print("Unesite broj racuna sa kojeg Zelite da preuzmete novac: ");
                int brojRacuna = sc.nextInt();

                System.out.print("Unesite koliko novca Zelite da preuzmete sa racuna: ");
                double preuzmiNovac = sc.nextDouble();

                sc.nextLine();

                ulogovanKorisnik.preuzmiNovac(brojRacuna, preuzmiNovac);
            }

            else if (opcija.equalsIgnoreCase("8")) {

                System.out.print("\nUnesite iznos u dinarima: ");
                double iznos = sc.nextDouble();

                System.out.print("Unesete valutu u koju Zelite da konvertujete dinare: ");
                String valuta = sc.next();

                sc.nextLine();

                double iznosUDrugojValuti = Menjacnica.konvertujIzDinaraUDruguValutu(iznos, valuta);

                System.out.println();
                System.out.println(iznos + " dinara, kada se prebaci u " + valuta + "/e, iznosi "
                    + iznosUDrugojValuti + " u toj valuti.");
            }

            // nedostaje opcija "9. Kupi". Nisam stigao zbog niza obaveza da je dovoljno istrazim i uradim.

            else if (opcija.equalsIgnoreCase("10")) {

                System.out.println("Racuni: ");
                for (Racun r : ulogovanKorisnik.getRacuni()) {
                    System.out.println("Br. racuna: " + r.getBrojRacuna() + " - stanje na racunu: "
                            + r.getStanjeNaRacunu() + " dinara");
                }
            }

            else if (opcija.equalsIgnoreCase("0")) {
                System.out.println("*** Kraj programa ***\n");
                break;
            }
            else {
                System.out.println("Nepoznata akcija.");
            }

            System.out.println();
        }
    }
}
