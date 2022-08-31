package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptasRepository  extends JpaRepository<Receptai, Long> {

    Receptai findByPavadinimas(String pavadinimas);

    Receptai findById(long id);

    Receptai findByKaina(double kaina);



    List<Receptai> findByKainaBetween(double pradineKaina, double galutineKaina);
}
