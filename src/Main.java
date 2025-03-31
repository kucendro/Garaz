import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SeznamVozidel seznam = new SeznamVozidel();
        ImageIcon hlavni = new ImageIcon(Main.class.getResource("car.png"));
        ImageIcon spzikon = new ImageIcon(Main.class.getResource("spz.png"));
        ImageIcon vinicon = new ImageIcon(Main.class.getResource("vin.png"));
        ImageIcon motoricon = new ImageIcon(Main.class.getResource("motor.png"));
        String typyVozidel[] = {"Osobní", "Nákladní", "Dodávka", "Motorka", "Scooter"};

        while (true) {
            String moznosti[] = {"Přidat vozidlo", "Odebrat vozidlo", "Upravit vozidlo", "Zobrazit všechna vozidla", "Rok výroby",  "Konec"};
            int volba = JOptionPane.showOptionDialog(null, "Vítej ve své garáži vozidel. \nVyber akci:", "Garáž",
                    0, 3, hlavni, moznosti, moznosti[5]);

            if (volba == -1) {
                System.exit(0);
                return;
            }

            switch (volba) {
                case 0:
                    Object inputspz = JOptionPane.showInputDialog(null, "Zadejte SPZ:", "Vstup SPZ", JOptionPane.PLAIN_MESSAGE, spzikon, null, "2E39731");
                    String spz = (inputspz != null) ? inputspz.toString() : null;
                    if (spz == null || spz.isEmpty() || spz.length() != 7) {
                        seznam.chyba("Chybný formát SPZ.");
                        break;
                    }

                    Object inputvin = JOptionPane.showInputDialog(null, "Zadejte VIN:", "Vstup VIN",JOptionPane.PLAIN_MESSAGE, vinicon, null, "1HGBH41JXMN109186");
                    String vin = (inputvin != null) ? inputvin.toString() : null;
                    if (vin == null || vin.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Zadejte VIN.");
                        break;
                    }

                    int vybertyp = JOptionPane.showOptionDialog(null, "Vyberte typ", "garáž", 0, 3, hlavni, typyVozidel, typyVozidel[4]);
                    String typ = typyVozidel[vybertyp];

                    Object inputmodel = JOptionPane.showInputDialog(null, "Zadejte model:", "Vstup modelu", JOptionPane.PLAIN_MESSAGE, hlavni, null, "Škoda Octavia");
                    String model = (inputmodel != null) ? inputmodel.toString() : null;
                    if (model == null || model.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Zadejte model.");
                        break;
                    }

                    Object inputbarva = JOptionPane.showInputDialog(null, "Zadejte barvu:", "Vstup barvy", JOptionPane.PLAIN_MESSAGE, hlavni, null, "černá");
                    String barva = (inputbarva != null) ? inputbarva.toString() : null;
                    if (barva == null || barva.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Zadejte barvu.");
                        break;
                    }

                    Object inputmotorizace = JOptionPane.showInputDialog(null, "Zadejte motorizaci:", "Vstup motorizace", JOptionPane.PLAIN_MESSAGE, motoricon, null, "1.9 TDI");
                    String motorizace = (inputmotorizace != null) ? inputmotorizace.toString() : null;
                    if (motorizace == null || motorizace.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Zadejte motorizaci.");
                        break;
                    }

                    Object inputrokVyroby = JOptionPane.showInputDialog(null, "Zadejte rok výroby:", "Vstup rok výroby", JOptionPane.PLAIN_MESSAGE, hlavni, null, "2009");
                    String rokVyroby = (inputrokVyroby != null) ? inputrokVyroby.toString() : null;
                    if (rokVyroby.length() != 4) {
                        JOptionPane.showConfirmDialog(null, "Neplatný rok výroby");
                        break;
                    }

                    seznam.pridatVozidlo(new Vozidlo(spz, model, barva, motorizace, vin, rokVyroby, typ));
                    JOptionPane.showMessageDialog(null, "Vozidlo přidáno.", "OK", JOptionPane.PLAIN_MESSAGE, hlavni);
                    seznam.zobrazVozidla();
                    break;

                case 1:
                    String spzOdebrat = JOptionPane.showInputDialog("Zadejte SPZ:", "2E39731");
                    if (spzOdebrat == null || spzOdebrat.isEmpty() || spzOdebrat.length() != 7) {
                        seznam.chyba("Chybný formát SPZ.");
                        break;
                    }
                    if (seznam.odebratVozidlo(spzOdebrat)) {
                        JOptionPane.showMessageDialog(null, "Vozidlo odstraněno.");
                    } else {
                        seznam.chyba("Vozidlo nenalezeno.");
                    }
                    break;

                case 2:
                    String spzUpravit = JOptionPane.showInputDialog("Zadejte SPZ:", "2E39731");
                    if (spzUpravit == null || spzUpravit.isEmpty() || spzUpravit.length() != 7) {
                        seznam.chyba("Chybný formát SPZ.");
                        break;
                    }
                    Vozidlo upravovane = seznam.najitVozidlo(spzUpravit);
                    if (upravovane != null) {

                        int zmentyp = JOptionPane.showOptionDialog(null, "Vyberte typ", "" + upravovane, 0, 3, hlavni, typyVozidel, typyVozidel[4]);
                        String novyTyp = typyVozidel[zmentyp];

                        Object uprvaitmodel = JOptionPane.showInputDialog(null, "Zadejte model:", "" + upravovane, JOptionPane.PLAIN_MESSAGE, hlavni, null, "Škoda Octavia");
                        String novyModel = (uprvaitmodel != null) ? uprvaitmodel.toString() : null;
                        if (novyModel == null || novyModel.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Zadejte model.");
                            break;
                        }

                        Object zmenbarva = JOptionPane.showInputDialog(null, "Zadejte barvu:", "" + upravovane, JOptionPane.PLAIN_MESSAGE, hlavni, null, "černá");
                        String novaBarva = (zmenbarva != null) ? zmenbarva.toString() : null;
                        if (novaBarva == null || novaBarva.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Zadejte barvu.");
                            break;
                        }

                        Object zmenmotorizace = JOptionPane.showInputDialog(null, "Zadejte motorizaci:", "Vstup motorizace", JOptionPane.PLAIN_MESSAGE, motoricon, null, "1.9 TDI");
                        String novamotorizace = (zmenmotorizace != null) ? zmenmotorizace.toString() : null;
                        if (novamotorizace == null || novamotorizace.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Zadejte motorizaci.");
                            break;
                        }

                        Object zmenrokVyroby = JOptionPane.showInputDialog(null, "Zadejte rok výroby:", "" + upravovane, JOptionPane.PLAIN_MESSAGE, hlavni, null, "2009");
                        String novyrok = (zmenrokVyroby != null) ? zmenrokVyroby.toString() : null;
                        if (novyrok.length() != 4) {
                            JOptionPane.showConfirmDialog(null, "Neplatný rok výroby");
                            break;
                        }

                        upravovane.setModel(novyModel);
                        upravovane.setBarva(novaBarva);
                        upravovane.setTyp(novyTyp);
                        upravovane.setMotorizace(novamotorizace);
                        upravovane.setRokVyroby(novyrok);

                        JOptionPane.showMessageDialog(null, "Vozidlo upraveno.", "OK", JOptionPane.PLAIN_MESSAGE, hlavni);

                    } else {
                        seznam.chyba("Vozidlo nenalezeno");
                    }
                    break;

                case 3:
                    seznam.zobrazVozidla();
                    break;

                case 4:
                    String minrok = JOptionPane.showInputDialog("Od:" );
                    String maxrok = JOptionPane.showInputDialog("Do:");

                    if (minrok != null && maxrok != null && !minrok.isEmpty() && !maxrok.isEmpty() && minrok.length() == 4 && maxrok.length() == 4) {
                        seznam.rangeScanRokVyroby(Integer.parseInt(minrok), Integer.parseInt(maxrok));
                    } else {
                        seznam.chyba("Zadejte platný rok.");
                    }
                    break;

                case 5:
                    System.out.println("Konec programu.");
                    System.exit(0);
                    return;

                default:
                    System.out.println("Well what the fuck! Co jsi udělal, že to nefunguje? Jaká skibidi sigma jsi?.");
            }
        }
    }
}