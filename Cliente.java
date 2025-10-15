class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String identidade;
    private String endereco;

    public Cliente(int id, String nome, String email, String telefone,
                   String cpf, String identidade, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.identidade = identidade;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome + " (" + cpf + ")";
    }
}