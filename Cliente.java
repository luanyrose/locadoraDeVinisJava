import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String tipoCliente;
    private List<Compra> historicoCompras;

    public Cliente(String nome, String cpf, String email, String tipoCliente) {
        super(nome, cpf, email);
        this.tipoCliente = tipoCliente;
        this.historicoCompras = new ArrayList<>();
    }

    public void adicionarCompra(Compra compra) {
        historicoCompras.add(compra);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Cliente: " + nome + " | Tipo: " + tipoCliente);
    }
}
