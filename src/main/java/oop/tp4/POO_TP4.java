package oop.tp4;

import java.util.Arrays;

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
        System.out.println("=== SISTEMA DE INIMIGOS DO JOGO - DEMONSTRAÇÃO COMPLETA ===\n");
        
        // Demonstração do atributo estático
        System.out.println("Total de Humanóides criados: " + Humanoide.getTotalHumanoides());
        
        // Criação das instâncias das subclasses com uso de this() nos construtores
        Humano humano = new Humano();
        Orc orc = new Orc();
        Lobisomem lobisomem = new Lobisomem();
        
        // Criação de instâncias adicionais com paramêtros específicos
        Humano magoHumano = new Humano("Aliança", 80.0, 95, false);
        Orc orcBerserker = new Orc("Horda", 150.0, 90, true);
        Lobisomem lobisomemAlfa = new Lobisomem("Selvagens", 120.0, 90);
        
        System.out.println("\n--- Após criação das personagens ---");
        System.out.println("Total de Humanóides criados: " + Humanoide.getTotalHumanoides());
        
        // Demonstração de polimorfismo
        System.out.println("\n=== DEMONSTRAÇÃO DE POLIMORFISMO COM ARRAY ===");
        
        // Array de Humanoide contendo diferentes tipos
        Humanoide[] arrayInimigos = {humano, orc, lobisomem, magoHumano, orcBerserker, lobisomemAlfa};
        
        Jogo jogo = new Jogo(humano);
        
        // Processa o array através da seleção dinâmica
        jogo.processaArrayInimigos(arrayInimigos);
        
        // Adiciona inimigos à coleção do jogo através do uso do encadeamento com this
        jogo.adicionaInimigo(humano)
            .adicionaInimigo(orc)
            .adicionaInimigo(lobisomem)
            .adicionaInimigo(magoHumano)
            .adicionaInimigo(orcBerserker)
            .adicionaInimigo(lobisomemAlfa);
        
        // Processao a coleção através da seleção dinâmica
        jogo.processaColecaoInimigo();
        
        // Demonstração dos métodos equals() e clone()
        jogo.demonstraEquals();
        jogo.demonstraClonagem();
        
        // Demonstração do uso de this em métodos de encadeamento
        System.out.println("\n=== DEMONSTRAÇÃO DE ENCADEAMENTO COM THIS ===");
        
        humano.setInteligenciaComThis(100).setTemArmadura(true);
        orc.setRaivaComThis(85).setTemSarrafo(false);
        lobisomem.setPoderDaLuaComThis(95);
        
        // Demonstração do método getEstaInstancia()
        System.out.println("\n=== DEMONSTRAÇÃO DE getEstaInstancia() ===");
        Humanoide autoReferencia = humano.getEstaInstancia();
        System.out.println("Referência própria: " + (humano == autoReferencia));
        
        // Demonstração do método temMaisVidaQue() com this
        System.out.println("\n=== COMPARAÇÃO DE VIDA ENTRE HUMANÓIDES ===");
        System.out.println("Humano tem mais vida do que Orc? " + humano.temMaisVidaQue(orc));
        System.out.println("Orc tem mais vida do que Lobisomem? " + orc.temMaisVidaQue(lobisomem));
        
        // Teste interativo com o jogo
        System.out.println("\n=== TESTE INTERATIVO DO JOGO ===");
        
        jogo.setEstadoJogoComThis("COMBATE").setInimigoAtual(orcBerserker);

        jogo.mostraInfoInimigo();
        jogo.inimigoFala();
        jogo.atacarInimigo();
        jogo.causarDanoInimigo(30);
        
        // Mudança de inimigo
        jogo.setInimigoAtual(lobisomemAlfa);
        jogo.mostraInfoInimigo();
        jogo.inimigoFala();
        
        // Transformação do lobisomem
        lobisomemAlfa.transformar();
        lobisomemAlfa.atacar();
        
        // Demonstração final
        System.out.println("\n=== ESTADO FINAL DOS PERSONAGENS ===");
        for (Humanoide inimigo : jogo.getListaInimigo())
        {
            inimigo.print();
            System.out.println("-------------------------");
        }
        
        System.out.println("\nTotal final de Humanóides: " + Humanoide.getTotalHumanoides());
        System.out.println("\n=== FIM DA DEMONSTRAÇÃO COMPLETA ===");
    }
}
