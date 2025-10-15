class Caixa {
    private int idCliente;
    private float caixaRegistradora;
    private float maquininha;
    private String emissaoNota;
    private List<Vinil> vinis;
    private Funcionario funcionario;
    private List<FormaDePagamento> formasPagamento;

    public Caixa(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.vinis = new ArrayList<>();
        this.formasPagamento = new ArrayList<>();
    }

    public void registrarVenda(Vinil v) {
        vinis.add(v);
        System.out.println("Venda registrada: " + v);
    }
}