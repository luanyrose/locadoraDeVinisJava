import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Vinil> vinis;

    public Estoque() {
        vinis = new ArrayList<>();
    }

    public void adicionarVinil(Vinil vinil) {
        vinis.add(vinil);
    }

    public int quantidadeDisponivel(Vinil vinil) {
        return vinil.isDisponivel() ? 1 : 0;
    }

    public List<Vinil> getVinis() {
        return vinis;
    }
}
