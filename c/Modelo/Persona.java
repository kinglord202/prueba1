package Modelo;

public class Persona {
    int id;
    String DNI;
    String nom;

    public Persona() {
    }

    public Persona(int id, String DNI, String nom) {
        this.id = id;
        this.DNI = DNI;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
