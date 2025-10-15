import java.time.LocalDate;
import java.util.*;

// Coloque tudo dentro de uma única public class para compilar facilmente num único arquivo Main.java
public class Main {

    // =============================
    // CLASSE BASE: VINIL
    // =============================
    static class Vinil {
        protected int id;
        protected String nome;
        protected LocalDate anoLancamento;
        protected String autoria;
        protected float precoAluguel;
        protected float precoCompra;
        protected List<Genero> generos;
        protected int quantidadeEstoque;

        public Vinil(int id, String nome, LocalDate anoLancamento, String autoria,
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

        public String getNome() {
            return nome;
        }

        @Override
        public String toString() {
            return nome + " - " + autoria + " (" + anoLancamento + ")";
        }
    }

    // =============================
    // SUBCLASSE: ALUGUEL DE VINIL
    // =============================
    static class AluguelVinil extends Vinil {
        private int tempoAluguel; // semanas
        private float precoAluguelSemana;
        private LocalDate prazo;

        public AluguelVinil(int id, String nome, LocalDate anoLancamento, String autoria,
                            float precoAluguel, float precoCompra, int quantidadeEstoque,
                            int tempoAluguel, float precoAluguelSemana, LocalDate prazo) {
            super(id, nome, anoLancamento, autoria, precoAluguel, precoCompra, quantidadeEstoque);
            this.tempoAluguel = tempoAluguel;
            this.precoAluguelSemana = precoAluguelSemana;
            this.prazo = prazo;
        }

        @Override
        public float calcularPreco() {
            return tempoAluguel * precoAluguelSemana;
        }

        @Override
        public String toString() {
            return super.toString() + " [ALUGUEL por " + tempoAluguel + " sem]";
        }
    }

    // =============================
    // SUBCLASSE: COMPRA DE VINIL
    // =============================
    static class CompraVinil extends Vinil {
        public CompraVinil(int id, String nome, LocalDate anoLancamento, String autoria,
                           float precoAluguel, float precoCompra, int quantidadeEstoque) {
            super(id, nome, anoLancamento, autoria, precoAluguel, precoCompra, quantidadeEstoque);
        }

        @Override
        public float calcularPreco() {
            return precoCompra;
        }
    }

    // =============================
    // CLASSE: GÊNERO (COMPOSIÇÃO)
    // =============================
    static class Genero {
        private String nomeGenero;

        public Genero(String nomeGenero) {
            this.nomeGenero = nomeGenero;
        }

        @Override
        public String toString() {
            return nomeGenero;
        }
    }

    // =============================
    // CLASSE: CLIENTE
    // =============================
    static class Cliente {
        private int id;
        private String nome;
        private String email;
        private String telefone;
        private String cpf;
        private String endereco;

        public Cliente(int id, String nome, String email, String telefone, String cpf, String endereco) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.cpf = cpf;
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return nome + " (" + cpf + ")";
        }
    }

    // =============================
    // CLASSE: FUNCIONÁRIO
    // =============================
    static class Funcionario {
        private int id;
        private String nome;
        private String cpf;
        private String funcao;
        private String cargaHoraria;

        public Funcionario(int id, String nome, String cpf, String funcao, String cargaHoraria) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.funcao = funcao;
            this.cargaHoraria = cargaHoraria;
        }

        @Override
        public String toString() {
            return nome + " - " + funcao;
        }
    }

    // =============================
    // CLASSE: FORMA DE PAGAMENTO (AGREGAÇÃO)
    // =============================
    static class FormaDePagamento {
        private List<CartaoDebito> cartoesDebito = new ArrayList<>();
        private List<CartaoCredito> cartoesCredito = new ArrayList<>();
        private float saldo;

        public FormaDePagamento(float saldo) {
            this.saldo = saldo;
        }

        public void adicionarCartaoDebito(CartaoDebito c) {
            cartoesDebito.add(c);
        }

        public void adicionarCartaoCredito(CartaoCredito c) {
            cartoesCredito.add(c);
        }

        @Override
        public String toString() {
            return "Saldo: " + saldo + ", debito: " + cartoesDebito.size() + ", credito: " + cartoesCredito.size();
        }
    }

    // =============================
    // CARTÃO DE CRÉDITO
    // =============================
    static class CartaoCredito {
        private String numero;
        private float limite;

        public CartaoCredito(String numero, float limite) {
            this.numero = numero;
            this.limite = limite;
        }
    }

    // =============================
    // CARTÃO DE DÉBITO
    // =============================
    static class CartaoDebito {
        private String numero;
        private float saldo;

        public CartaoDebito(String numero, float saldo) {
            this.numero = numero;
            this.saldo = saldo;
        }
    }

    // =============================
    // CLASSE ASSOCIATIVA: TRANSAÇÃO
    // =============================
    static class Transacao {
        private int id;
        private LocalDate data;
        private Funcionario atendente;
        private Cliente cliente;
        private List<FormaDePagamento> formasPagamento;
        private Map<Vinil, Integer> itens = new LinkedHashMap<>();

        public Transacao(int id, LocalDate data, Funcionario atendente, Cliente cliente) {
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
            StringBuilder sb = new StringBuilder();
            sb.append("Transação #").append(id).append("\nData: ").append(data).append("\nCliente: ").append(cliente)
              .append("\nAtendente: ").append(atendente).append("\nItens:\n");
            for (Map.Entry<Vinil, Integer> e : itens.entrySet()) {
                sb.append("- ").append(e.getKey().getNome()).append(" x").append(e.getValue())
                  .append(" R$").append(e.getKey().calcularPreco()).append("\n");
            }
            sb.append("Valor Total: R$").append(calcularValorTotal()).append("\n");
            sb.append("Formas de Pagamento: ").append(formasPagamento.size()).append("\n");
            return sb.toString();
        }
    }

    // =============================
    // CLASSE: CAIXA
    // =============================
    static class Caixa {
        private float caixaRegistradora;
        private float maquininha;
        private Funcionario funcionario;

        public Caixa(Funcionario funcionario, float caixaRegistradora, float maquininha) {
            this.funcionario = funcionario;
            this.caixaRegistradora = caixaRegistradora;
            this.maquininha = maquininha;
        }
    }

    // =============================
    // MAIN (TESTES)
    // =============================
    public static void main(String[] args) {
        // ==== FUNCIONÁRIOS ====
        Funcionario f1 = new Funcionario(1, "Ana", "111.222.333-44", "Atendente", "40h");
        Funcionario f2 = new Funcionario(2, "Lucas", "555.666.777-88", "Gerente", "44h");
        Funcionario f3 = new Funcionario(3, "Marta", "999.888.777-66", "Caixa", "36h");

        // ==== CLIENTES ====
        Cliente c1 = new Cliente(1, "Vey", "vey@email.com", "819999999", "987.654.321-00", "Rua dos Vinis");
        Cliente c2 = new Cliente(2, "Carlos", "carlos@mail.com", "819888888", "111.222.333-44", "Rua Azul");
        Cliente c3 = new Cliente(3, "Luna", "luna@mail.com", "819777777", "444.555.666-77", "Rua Verde");

        // ==== GÊNEROS ====
        Genero g1 = new Genero("Rock");
        Genero g2 = new Genero("Jazz");
        Genero g3 = new Genero("MPB");

        // ==== VINIS (3 objetos de exemplo) ====
        Vinil v1 = new CompraVinil(1, "Dark Side of the Moon", LocalDate.of(1973, 3, 1), "Pink Floyd", 0f, 150f, 5);
        Vinil v2 = new AluguelVinil(2, "Kind of Blue", LocalDate.of(1959, 8, 17), "Miles Davis", 10f, 120f, 3, 2, 15f, LocalDate.now());
        Vinil v3 = new CompraVinil(3, "Elis & Tom", LocalDate.of(1974, 1, 1), "Elis Regina", 0f, 180f, 2);

        v1.adicionarGenero(g1);
        v2.adicionarGenero(g2);
        v3.adicionarGenero(g3);

        // ==== FORMAS DE PAGAMENTO ====
        FormaDePagamento fp1 = new FormaDePagamento(500f);
        FormaDePagamento fp2 = new FormaDePagamento(1000f);
        FormaDePagamento fp3 = new FormaDePagamento(200f);

        // ==== CARTÕES ====
        CartaoCredito cc1 = new CartaoCredito("1234-5678-9012-3456", 1000f);
        CartaoDebito cd1 = new CartaoDebito("4321-8765-2109-6543", 300f);

        fp1.adicionarCartaoCredito(cc1);
        fp1.adicionarCartaoDebito(cd1);

        // ==== TRANSAÇÕES (3 exemplos) ====
        Transacao t1 = new Transacao(1, LocalDate.now(), f1, c1);
        Transacao t2 = new Transacao(2, LocalDate.now(), f2, c2);
        Transacao t3 = new Transacao(3, LocalDate.now(), f3, c3);

        t1.adicionarItem(v1, 1);
        t1.adicionarItem(v2, 2);
        t2.adicionarItem(v3, 1);
        t3.adicionarItem(v2, 1);

        t1.adicionarFormaPagamento(fp1);
        t2.adicionarFormaPagamento(fp2);
        t3.adicionarFormaPagamento(fp3);

        // ==== CAIXAS ====
        Caixa caixa1 = new Caixa(f3, 1000f, 300f);
        Caixa caixa2 = new Caixa(f1, 800f, 200f);
        Caixa caixa3 = new Caixa(f2, 1200f, 400f);

        // ==== EXIBIR RECIBOS ====
        System.out.println(t1.gerarRecibo());
        System.out.println(t2.gerarRecibo());
        System.out.println(t3.gerarRecibo());
    }
}