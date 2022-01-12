public class Menjacnica {

    private static double evro = 0.0085;
    private static double svajcarskiFranak = 0.0089;
    private static double americkiDolar = 0.010;
    private static double britanskaFunta = 0.0071;
    private static double japanskiJen = 1.1157;
    private static double norveskaKruna = 0.0847;
    private static double ruskaRublja = 0.7191;

    public void setEvro(double evro) {
        this.evro = evro;
    }

    public void setSvajcarskiFranak(double svajcarskiFranak) {
        this.svajcarskiFranak = svajcarskiFranak;
    }

    public void setAmerickiDolar(double americkiDolar) {
        this.americkiDolar = americkiDolar;
    }

    public void setBritanskaFunta(double britanskaFunta) {
        this.britanskaFunta = britanskaFunta;
    }

    public void setJapanskiJen(double japanskiJen) {
        this.japanskiJen = japanskiJen;
    }

    public void setNorveskaKruna(double norveskaKruna) {
        this.norveskaKruna = norveskaKruna;
    }

    public void setRuskaRublja(double ruskaRublja) {
        this.ruskaRublja = ruskaRublja;
    }

    public static double konvertujIzDinaraUDruguValutu(double dinari, String valuta) {

        if (valuta.equalsIgnoreCase("evro")) {
            return dinari * evro;
        }
        else if (valuta.equalsIgnoreCase("franak")) {
            return dinari * svajcarskiFranak;
        }
        else if (valuta.equalsIgnoreCase("rublja")) {
            return dinari * ruskaRublja;
        }
        else if (valuta.equalsIgnoreCase("funta")) {
            return dinari * britanskaFunta;
        }
        else if (valuta.equalsIgnoreCase("jen")) {
            return dinari * japanskiJen;
        }
        else if (valuta.equalsIgnoreCase("kruna")) {
            return dinari * norveskaKruna;
        }
        else {
            return dinari * americkiDolar;
        }
    }
}
