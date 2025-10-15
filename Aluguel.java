<<<<<<< Updated upstream
class AluguelVinil extends Vinil {
    private int tempoAluguel; // em semanas
    private float precoAluguelSemana;
    private Date prazo;

    public AluguelVinil(int id, String nome, Date anoLancamento, String autoria,
                        float precoAluguel, float precoCompra, int quantidadeEstoque,
                        int tempoAluguel, float precoAluguelSemana, Date prazo) {
        super(id, nome, anoLancamento, autoria, precoAluguel, precoCompra, quantidadeEstoque);
        this.tempoAluguel = tempoAluguel;
        this.precoAluguelSemana = precoAluguelSemana;
        this.prazo = prazo;
    }

    @Override
    public float calcularPreco() {
        return tempoAluguel * precoAluguelSemana;
    }
}