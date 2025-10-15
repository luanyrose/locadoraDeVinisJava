public class ItemCompra {
    private Vinil vinil;
    private int quantidade;
    private double valorItem;

    public ItemCompra(Vinil vinil, int quantidade) {
        this.vinil = vinil;
        this.quantidade = quantidade;
        this.valorItem = vinil.getPrecoVenda() * quantidade;
    }

    public Vinil getVinil() {
        return vinil;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorItem() {
        return valorItem;
    }
}
