package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Ingredientai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientaiRepository extends JpaRepository<Ingredientai, Integer> {
    Ingredientai findById(int id);

    Ingredientai findByPavadinimas(String pavadinimas);
}