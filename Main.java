import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criar gêneros musicais
        Genero rock = new Genero("Rock");
        Genero pop = new Genero("Pop");
        Genero jazz = new Genero("Jazz");
        
        // Criar um vinil
        Vinil vinil1 = new Vinil(1, "The Beatles - Abbey Road", 
                                new Date(69, 8, 26), // 26 de setembro de 1969
                                "The Beatles", 15.0f, 80.0f, 5);
        
        // Adicionar gêneros ao vinil
        vinil1.adicionarGenero(rock);
        vinil1.adicionarGenero(pop);
        
        // Criar outro vinil
        Vinil vinil2 = new Vinil(2, "Kind of Blue", 
                                new Date(59, 7, 17), // 17 de agosto de 1959
                                "Miles Davis", 12.0f, 60.0f, 3);
        
        // Adicionar gênero ao segundo vinil
        vinil2.adicionarGenero(jazz);
        
        // Demonstrar o uso
        System.out.println("=== DEMONSTRAÇÃO DE GÊNEROS E VINIS ===");
        System.out.println("Gêneros disponíveis:");
        System.out.println("- " + rock.getGenero());
        System.out.println("- " + pop.getGenero());
        System.out.println("- " + jazz.getGenero());
        
        System.out.println("\nVinil 1:");
        System.out.println(vinil1);
        System.out.println("Gêneros do Vinil 1: " + vinil1.getGeneros());
        
        System.out.println("\nVinil 2:");
        System.out.println(vinil2);
        System.out.println("Gêneros do Vinil 2: " + vinil2.getGeneros());
        
        // Demonstrar cálculo de preço
        System.out.println("\nPreços:");
        System.out.println("Vinil 1 - Preço: R$ " + vinil1.calcular_preco());
        System.out.println("Vinil 2 - Preço: R$ " + vinil2.calcular_preco());
    }
}