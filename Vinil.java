import java.util.*;

public class Vinil {
    protected int id;
    protected String nome;
    protected Date anoLancamento;
    protected String autoria;
    protected float precoAluguel;
    protected float precoCompra;
    protected List<Genero> generos;
    protected int quantidadeEstoque;

    public Vinil(int id, String nome, Date anoLancamento, String autoria,
                 float precoAluguel, float precoCompra, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.autoria = autoria;
        this.precoAluguel = precoAluguel;
        this.precoCompra = precoCompra;
        this.quantidadeEstoque = quantidadeEstoque;
        this.generos = new ArrayList<>();
    }

    public void adicionarGenero(Genero g) {
        generos.add(g);
    }

    public float calcularPreco() {
        return precoCompra;
    }

    @Override
    public String toString() {
        return nome + " - " + autoria + " (" + anoLancamento + ")";
    }
}