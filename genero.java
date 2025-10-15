class Genero {
    private String nomeGenero;

    public Genero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public String getGenero() {
        return nomeGenero;
    }

    @Override
    public String toString() {
        return nomeGenero;
    }
}
