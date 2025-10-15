import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando cliente e funcionário
        Cliente c1 = new Cliente("Luany", "123.456.789-00", "luany@email.com", "Premium");
        Funcionario f1 = new Funcionario("João", "987.654.321-00", "joao@vinis.com", "Caixa", 2500);

        // Criando vinis
        Vinil v1 = new Vinil(1, "Abbey Road", "The Beatles", "Rock", 120.00);
        Vinil v2 = new Vinil(2, "Back to Black", "Amy Winehouse", "Soul", 90.00);

        // Criando estoque (agregação)
        Estoque estoque = new Estoque();
        estoque.adicionarVinil(v1);
        estoque.adicionarVinil(v2);

        // Criando compra (classe associativa + composição)
        Compra compra = new Compra(new Date(), c1);
        compra.adicionarItem(v1, 1);
        compra.adicionarItem(v2, 2);
        c1.adicionarCompra(compra);

        // Exibindo informações
        c1.exibirInfo();
        compra.exibirResumo();
        f1.exibirInfo();
    }
}
