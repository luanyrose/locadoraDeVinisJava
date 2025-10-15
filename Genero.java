public class Genero {
    private String nome_genero;
    
    public Genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }
    
    public String getGenero() {
        return nome_genero;
    }
    
    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }
    
    @Override
    public String toString() {
        return nome_genero;
    }
}

