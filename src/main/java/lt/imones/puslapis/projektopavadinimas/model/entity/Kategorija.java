package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;

    @JsonIgnore
    @OneToMany(mappedBy = "receptoKategorija")
    Set<Receptai> kategorijosReceptai;

    public Kategorija() {
    }

    public Kategorija(long id, String pavadinimas, Set<Receptai> kategorijosReceptai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kategorijosReceptai = kategorijosReceptai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Set<Receptai> getKategorijosReceptai() {
        return kategorijosReceptai;
    }

    public void setKategorijosReceptai(Set<Receptai> kategorijosReceptai) {
        this.kategorijosReceptai = kategorijosReceptai;
    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kategorijosReceptai=" + kategorijosReceptai +
                '}';
    }
}
