package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vartotojai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;

    @JsonIgnore
    @OneToMany(mappedBy = "receptoKurejas")
    Set<Receptai> vartotojoReceptai;

    @ManyToMany
    @JoinTable(
            name = "vartotoju_megstami_receptai",
            joinColumns = @JoinColumn(name = "vartotojo_id"),
            inverseJoinColumns = @JoinColumn(name = "receptas_id")
    )
    private Set<Receptai> megstamiReceptai;

    public Vartotojai() {
    }

    public Vartotojai(int id, String username, String password, Set<Receptai> vartotojoReceptai) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.vartotojoReceptai = vartotojoReceptai;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Receptai> getVartotojoReceptai() {
        return vartotojoReceptai;
    }

    public void setVartotojoReceptai(Set<Receptai> vartotojoReceptai) {
        this.vartotojoReceptai = vartotojoReceptai;
    }

    public Set<Receptai> getMegstamiReceptai() {
        return megstamiReceptai;
    }

    public void setMegstamiReceptai(Set<Receptai> megstamiReceptai) {
        this.megstamiReceptai = megstamiReceptai;
    }


    @Override
    public String toString() {
        return "Vartotojai{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vartotojoReceptai=" + vartotojoReceptai +
                '}';
    }
}
