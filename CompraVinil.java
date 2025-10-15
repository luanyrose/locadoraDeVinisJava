<<<<<<< Updated upstream
class CompraVinil extends Vinil {
    public CompraVinil(int id, String nome, Date anoLancamento, String autoria,
                       float precoAluguel, float precoCompra, int quantidadeEstoque) {
        super(id, nome, anoLancamento, autoria, precoAluguel, precoCompra, quantidadeEstoque);
    }

    @Override
    public float calcularPreco() {
        return precoCompra;
    }
=======
public class Compra {
    
>>>>>>> Stashed changes
}
