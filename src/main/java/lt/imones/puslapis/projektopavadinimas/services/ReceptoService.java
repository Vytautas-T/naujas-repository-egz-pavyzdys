package lt.imones.puslapis.projektopavadinimas.services;

import lt.imones.puslapis.projektopavadinimas.model.dto.IngredientaiDto;
import lt.imones.puslapis.projektopavadinimas.model.entity.Ingredientai;
import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import lt.imones.puslapis.projektopavadinimas.model.repository.IngredientaiRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReceptoService {
    @Autowired
    ReceptasRepository receptasRepository;
    @Autowired
    IngredientaiRepository ingredientaiRepository;

   public String ingredientuSetuConvertatorius(Set<Ingredientai> ingredientai){
       StringBuilder ingrePavadinimas = new StringBuilder();
       for (Ingredientai ingredientas : ingredientai) {
           ingrePavadinimas.append(ingredientas.getPavadinimas());
           ingrePavadinimas.append(",");
       }
       return ingrePavadinimas.toString();
   }

    public Set<Ingredientai> ingreStringConvertavimasISet(String ingredientai) {
       String[] visiIngre;
        visiIngre = ingredientai.split(",");
        Set<Ingredientai> ingreSet = new HashSet<>();
        for (String s : visiIngre) {
            ingreSet.add(ingredientaiRepository.findByPavadinimas(s));
        }
        return ingreSet;
    }
}
