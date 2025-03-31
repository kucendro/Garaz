class Vozidlo {
    private String spz;
    private String model;
    private String barva;
    private String motorizace;
    private String vin;
    private String rokVyroby;
    private String typ;

    public Vozidlo(String spz, String model, String barva, String motorizace, String vin, String rokVyroby, String typ) {
        this.spz = spz;
        this.model = model;
        this.barva = barva;
        this.motorizace = motorizace;
        this.vin = vin;
        this.rokVyroby = rokVyroby;
        this.typ = typ;
    }

    public String getSpz() {
        return spz;
    }

    public String getRokVyroby() {
        return rokVyroby;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public void setMotorizace(String motorizace) {
        this.motorizace = motorizace;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setRokVyroby(String rokVyroby) {
        this.rokVyroby = rokVyroby;
    }

    @Override
    public String toString() {
        return "SPZ: " + spz + ", VIN: " + vin +  ", Model: " + model + ", Typ: " + typ +  ", Motorizace: " + motorizace + ", Barva: " + barva + ", Rok výroby: " + rokVyroby;
    }
}