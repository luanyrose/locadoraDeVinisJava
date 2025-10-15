// Representa um disco de vinil vendido/locado na loja.
public class Vinil {
    // Atributos simples do vinil
    private int codigo;
    private String titulo;
    private String artista;
    private double precoVenda;
    private double precoAluguel;
    private String genero;
    private int qtdDisponivel;

    public Vinil(int codigo, String titulo, String artista,
                 double precoVenda, double precoAluguel, int qtdDisponivel,
                 String genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.artista = artista;
        this.precoVenda = precoVenda;
        this.precoAluguel = precoAluguel;
        this.qtdDisponivel = qtdDisponivel;
        this.genero = genero;
    }

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public double getPrecoVenda() { return precoVenda; }
    public double getPrecoAluguel() { return precoAluguel; }
    public String getGenero() { return genero; }
    public int getQtdDisponivel() { return qtdDisponivel; }

    // Baixa a quantidade do estoque deste vinil (evita negativo)
    public void diminuirEstoque(int quantidade) {
        if (quantidade <= 0) return;
        if (qtdDisponivel >= quantidade) {
            qtdDisponivel -= quantidade;
        }
    }

    @Override
    public String toString() {
        return "Vinil{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", genero='" + genero + '\'' +
                ", precoVenda=" + precoVenda +
                ", qtdDisponivel=" + qtdDisponivel +
                '}';
    }
}