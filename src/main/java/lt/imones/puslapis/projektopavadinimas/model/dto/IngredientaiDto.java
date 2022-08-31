package lt.imones.puslapis.projektopavadinimas.model.dto;

import java.lang.reflect.Field;
import java.util.Arrays;

public class IngredientaiDto {
    String pavadinimai;

    String[] isskaldytiPavadinimai;

    long receptoId;

    public IngredientaiDto() {
    }

    public IngredientaiDto(String pavadinimai) {
        this.pavadinimai = pavadinimai;
    }

    public String getPavadinimai() {
        return pavadinimai;
    }

    public void setPavadinimai(String pavadinimai) {
        this.pavadinimai = pavadinimai;
    }

    public String[] getIsskaldytiPavadinimai() {
        return isskaldytiPavadinimai;
    }

    public void setIsskaldytiPavadinimai(String[] isskaldytiPavadinimai) {
        this.isskaldytiPavadinimai = isskaldytiPavadinimai;
    }

    public long getReceptoId() {
        return receptoId;
    }

    public void setReceptoId(long receptoId) {
        this.receptoId = receptoId;
    }

    @Override
    public String toString() {
        return "IngredientaiDto{" +
                "pavadinimai='" + pavadinimai + '\'' +
                ", isskaldytiPavadinimai=" + Arrays.toString(isskaldytiPavadinimai) +
                ", receptoId=" + receptoId +
                '}';
    }
}
