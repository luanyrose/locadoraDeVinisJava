import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private Date dataCompra;
    private double valorTotal;
    private Cliente cliente;
    private List<ItemCompra> itens;

    public Compra(Date dataCompra, Cliente cliente) {
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public void adicionarItem(Vinil vinil, int quantidade) {
        ItemCompra item = new ItemCompra(vinil, quantidade);
        itens.add(item);
        valorTotal += item.getValorItem();
        vinil.setDisponivel(false);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void exibirResumo() {
        System.out.println("Compra em: " + dataCompra);
        for (ItemCompra item : itens) {
            System.out.println(" - " + item.getVinil() + " | Qtd: " + item.getQuantidade());
        }
        System.out.println("Valor total: R$" + valorTotal);
    }
}
