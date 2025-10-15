public class Vinil {
    private int codigo;
    private String titulo;
    private String artista;
    private String genero;
    private double precoVenda;
    private boolean disponivel;

    public Vinil(int codigo, String titulo, String artista, String genero, double precoVenda) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.precoVenda = precoVenda;
        this.disponivel = true;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Vinil: " + titulo + " - " + artista + " (" + genero + ")";
    }
}
