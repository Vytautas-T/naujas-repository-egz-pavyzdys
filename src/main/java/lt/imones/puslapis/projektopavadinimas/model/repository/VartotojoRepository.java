package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Vartotojai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VartotojoRepository extends JpaRepository<Vartotojai, Integer> {

    Vartotojai findById(int id);
}
