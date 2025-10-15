class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private int telefone;
    private String identidade;
    private String cargaHoraria;
    private String funcao;
    private int idClt;

    public Funcionario(int id, String nome, String cpf, int telefone,
                       String identidade, String cargaHoraria, String funcao, int idClt) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.identidade = identidade;
        this.cargaHoraria = cargaHoraria;
        this.funcao = funcao;
        this.idClt = idClt;
    }

    @Override
    public String toString() {
        return nome + " - " + funcao;
    }
}