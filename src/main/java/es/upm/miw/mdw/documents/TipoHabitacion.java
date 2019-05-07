package es.upm.miw.mdw.documents;

public enum TipoHabitacion {

    CASA, DUPLEX, APARTAMENTO, CHALET;

    public String tipo() {
        return this.toString();
    }

}
