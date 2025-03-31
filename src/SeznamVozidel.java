import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

class SeznamVozidel {
    private ArrayList<Vozidlo> vozidla = new ArrayList<>();

    public void pridatVozidlo(Vozidlo v) {
        vozidla.add(v);
        Collections.sort(vozidla, Comparator.comparing(Vozidlo::getSpz));
    }

    public boolean odebratVozidlo(String spz) {
        return vozidla.removeIf(v -> v.getSpz().equals(spz));
    }

    public Vozidlo najitVozidlo(String spz) {
        for (Vozidlo v : vozidla) {
            if (v.getSpz().equals(spz)) {
                return v;
            }
        }
        return null;
    }

    public void zobrazVozidla() {
        StringBuilder sb = new StringBuilder("Seznam vozidel:\n");
        for (Vozidlo v : vozidla) {
            sb.append("<html><font color='green'>").append(v).append("</font></html>\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Seznam vozidel", JOptionPane.INFORMATION_MESSAGE);
    }

    public void rangeScanRokVyroby(int zacatek, int konec) {
        StringBuilder sb = new StringBuilder("Vozidla vyrobená mezi roky " + zacatek + " a " + konec + ":\n");
        boolean nalezeno = false;

        for (Vozidlo v : vozidla) {
            int rok = Integer.parseInt(v.getRokVyroby());
            if (rok >= zacatek && rok <= konec) {
                sb.append("<html><font color='green'>").append(v).append("</font></html>\n");
                nalezeno = true;
            }
        }

        if (!nalezeno) {
            JOptionPane.showMessageDialog(null, "Žádná vozidla v rozsahu nenalezena.", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Filtr: Rok výroby", JOptionPane.INFORMATION_MESSAGE);
    }

    public void chyba(String chyba) {
        JOptionPane.showMessageDialog(null, chyba, "Chyba", JOptionPane.ERROR_MESSAGE);
    }
}