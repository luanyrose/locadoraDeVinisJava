class FormaDePagamento {
    private List<CartaoDebito> cartoesDebito = new ArrayList<>();
    private List<CartaoCredito> cartoesCredito = new ArrayList<>();
    private float pix;
    private float dinheiro;
    private float saldo;

    public FormaDePagamento(float pix, float dinheiro, float saldo) {
        this.pix = pix;
        this.dinheiro = dinheiro;
        this.saldo = saldo;
    }

    public void adicionarCartaoDebito(CartaoDebito c) {
        cartoesDebito.add(c);
    }

    public void adicionarCartaoCredito(CartaoCredito c) {
        cartoesCredito.add(c);
    }
}