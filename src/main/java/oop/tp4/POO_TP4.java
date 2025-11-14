package oop.tp4;

/**
 * Classe principal com método main para testar toda a estrutura.
 * Demonstra a criação de instâncias e o uso de polimorfismo.
 * 
 * @author Luis Matos
 */
public class POO_TP4
{
    /**
     * Método principal que executa os testes da estrutura de inimigos.
     * 
     * @param args Argumentos da linha de comandos (não utilizados) 
     */
    public static void main(String[] args)
    {
        System.out.println("=== SISTEMA DE INIMIGOS DO JOGO ===\n");
        
        // Demonstração do atributo estático
        System.out.println("Total de Humanóides criados: " + Humanoide.getTotalHumanoides());
        
        // Criação das instâncias das subclasses
        Humano humano = new Humano("Alliança", 100, 85, true);
        Orc orc = new Orc("Horda", 120, 70, true);
        Lobisomem lobisomem = new Lobisomem("Selvagens", 90, 75);
        
        System.out.println("\n--- Após criação das personagens ---");
        System.out.println("Total de Humanóides criados: " + Humanoide.getTotalHumanoides());
        
        // Demonstração de polimorfismo
        System.out.println("\n=== DEMONSTRAÇÃO DE POLIMORFISMO ===");
        
        // Array de Humanoide contendo diferentes tipos
        Humanoide[] inimigos = {humano, orc, lobisomem};
        
        for (Humanoide inimigo : inimigos)
        {
            System.out.println("\n--- " + inimigo.getClass().getSimpleName() + " ---");
            inimigo.falar();
            inimigo.atacar();
            System.out.println(inimigo.toString());
        }
        
        // Teste da classe Jogo
        System.out.println("\n=== TESTE DA CLASSE JOGO ===");
        
        Jogo jogo = new Jogo(humano);
        
        // Interacção com o inimigo atual (Humano)
        jogo.mostraInfoInimigo();
        jogo.inimigoFala();
        jogo.atacarInimigo();
        jogo.causarDanoInimigo(30);
        
        // Mudança para Orc
        jogo.setInimigoAtual(orc);
        jogo.mostraInfoInimigo();
        jogo.inimigoFala();
        jogo.atacarInimigo();
        
        // Uso de métodos específicos das subclasses
        System.out.println("\n=== MÉTODOS ESPECÍFICOS DAS SUBCLASSES ===");
        
        // Específico a Humano
        humano.usarPocao();
        
        // Específico a Orc
        orc.enraivecer();
        orc.atacar();
        
        // Específico a Lobisomem
        lobisomem.transformar();
        lobisomem.falar();
        lobisomem.atacar();
        
        // Demonstração final
        System.out.println("\n=== ESTADO FINAL DOS PERSONAGENS ===");
        System.out.println(humano.toString());
        System.out.println(orc.toString());
        System.out.println(lobisomem.toString());
        
        System.out.println("\nTotal final de Humanóides: " + Humanoide.getTotalHumanoides());
        System.out.println("\n=== FIM DA DEMONSTRAÇÃO ===");  
    }
}
