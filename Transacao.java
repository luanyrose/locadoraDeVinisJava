class Transacao {
    private int id;
    private Date data;
    private Funcionario atendente;
    private Cliente cliente;
    private List<FormaDePagamento> formasPagamento;
    private Map<Vinil, Integer> itens = new HashMap<>();

    public Transacao(int id, Date data, Funcionario atendente, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.atendente = atendente;
        this.cliente = cliente;
        this.formasPagamento = new ArrayList<>();
    }

    public void adicionarFormaPagamento(FormaDePagamento f) {
        formasPagamento.add(f);
    }

    public void adicionarItem(Vinil v, int quantidade) {
        itens.put(v, quantidade);
    }

    public float calcularValorTotal() {
        float total = 0;
        for (Map.Entry<Vinil, Integer> item : itens.entrySet()) {
            total += item.getKey().calcularPreco() * item.getValue();
        }
        return total;
    }

    public String gerarRecibo() {
        return "Transação #" + id + " - Cliente: " + cliente +
               "\nAtendente: " + atendente +
               "\nValor Total: R$ " + calcularValorTotal();
    }
}