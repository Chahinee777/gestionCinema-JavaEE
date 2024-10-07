package src.model;

public class Salle {
    private int id;
    private String nom;
    private int capacite;
    private String localisation;

    public Salle() {
    }

    public Salle(int id, String nom, int capacite, String localisation) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.localisation = localisation;
    }

    public Salle(String nom, int capacite, String localisation) {
        this.nom = nom;
        this.capacite = capacite;
        this.localisation = localisation;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public String getLocalisation() {
        return this.localisation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;

}}
