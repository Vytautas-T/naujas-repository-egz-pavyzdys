package lt.imones.puslapis.projektopavadinimas.service;

import lt.imones.puslapis.projektopavadinimas.model.entity.Ingredientai;
import lt.imones.puslapis.projektopavadinimas.model.repository.IngredientaiRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReceptoService {
    @Autowired
    ReceptasRepository receptasRepository;
    @Autowired
    IngredientaiRepository ingredientaiRepository;

    public Set<Ingredientai> KonvertavimasIsStringISet(String ingredientai) {
        System.out.println(ingredientai + "sitas");
        Set<Ingredientai> ingreSet = new HashSet<>();
        for (String ingredientas : ingredientai.split(",")){
            ingreSet.add(ingredientaiRepository.findByPavadinimas(ingredientas));
            System.out.println(ingredientas);
        }
        System.out.println(ingreSet);
        return ingreSet;
    }

    public String konvertavimasIsSetIString(Set<Ingredientai> ingredientai){
        StringBuilder ingreString= new StringBuilder();
        for (Ingredientai ingredientas : ingredientai) {
            ingreString.append(ingredientas.getPavadinimas()).append(",");
        }
        return ingreString.toString();
    }
}
