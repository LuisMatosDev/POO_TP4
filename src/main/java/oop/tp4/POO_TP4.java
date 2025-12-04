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
        System.out.println("=== SISTEMA DE INIMIGOS DO JOGO - DEMONSTRAÇÃO COMPLETA ===\n");
        
        // =====================================================================
        // PARTE 1: TESTES ORIGINAIS (SEM USO DE INTERFACES)
        // =====================================================================

        System.out.println("=== PARTE 1: TESTES DA ESTRUTURA ORIGINAL ===");
        
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
        System.out.println("\n=== ESTADO FINAL DOS PERSONAGENS (PARTE 1) ===");
        for (Humanoide inimigo : jogo.getListaInimigo())
        {
            inimigo.print();
            System.out.println("-------------------------");
        }
        
        System.out.println("\nTotal final de Humanóides (Parte 1): " + Humanoide.getTotalHumanoides());
        
        // =====================================================================
        // PARTE 2: TESTES DAS INTERFACES
        // =====================================================================
        
        System.out.println("\n\n=== PARTE 2: TESTES DAS INTERFACES ===");
        
        // Demonstrando interfaces
        jogo.demonstraConstantesInterfaces();
        
        // Adicionando criaturas via interface
        jogo.adicionaCriatura(humano).adicionaCriatura(orc);
        
        // Demonstrando polimorfismo com interfaces
        jogo.demonstraPolimorfismoInterface();
        
        // Testes de implementações específicas
        System.out.println("\n=== TESTE DE IMPLEMENTAÇÕES ESPECÍFICAS ===");
        
        // Humano implementa ICriatura e ITransformavel
        System.out.println("\n--- Teste de Humano (ICriatura + ITransformável) ---");
        humano.sonoriza();
        System.out.println("Humano está ativo? " + humano.estaAtivo());
        humano.iniciaTransformacao();
        humano.mostrarLimiteTransformação();
        
        // Orc implementa IInimigo
        System.out.println("\n--- Teste de Orc (IInimigo) ---");
        orc.sonoriza();
        System.out.println("Orc está ativo? " + orc.estaAtivo());
        System.out.println("Recompensa por derrotar Orc: " + orc.calculaRecompensa());
        orc.acaoEspecial();
        orc.mostraConstantesInterfaces();
        
        // Lobisomem não implementa interfaces
        System.out.println("\n--- Teste de Lobisomem (sem interfaces) ---");
        lobisomem.falar();
        lobisomem.atacar();
        
        // Demonstração de polimorfismo com array misto
        System.out.println("\n=== ARRAY MISTO DE OBJECTOS ===");
        Object[] entidadesJogo = {humano, orc, lobisomem, "Game Master", 100};
        
        for (Object entidade : entidadesJogo)
        {
            System.out.println("\nTipo: " + entidade.getClass().getSimpleName());
            
            if (entidade instanceof ICriatura)
            {
                ICriatura criatura = (ICriatura) entidade;
                criatura.sonoriza();
            }
            
            if (entidade instanceof ITransformavel)
            {
                ITransformavel transformavel = (ITransformavel) entidade;
                transformavel.iniciaTransformacao();
            }
            
            if (entidade instanceof IInimigo)
            {
                IInimigo inimigo = (IInimigo) entidade;
                System.out.println("É um inimigo com recompensa: " + inimigo.calculaRecompensa());
            }
        }
        
        // Teste adicional: demonstração de herança de interfaces
        System.out.println("\n=== HERANÇA DE INTERFACES ===");
        System.out.println("Orc é uma ICriatura? " + (orc instanceof ICriatura));
        System.out.println("Orc é um IInimigo? " + (orc instanceof IInimigo));
        System.out.println("Humano é uma ICriatura? " + (humano instanceof ICriatura));
        System.out.println("Humano é um ITransformavel?" + (humano instanceof ITransformavel));
        System.out.println("Humano é um IInimigo? " + (humano instanceof IInimigo));
        System.out.println("Lobisomem é uma ICriatura? " + (lobisomem instanceof ICriatura));
        
        // Demonstração de acesso a constantes de interface
        System.out.println("\n=== CONSTANTES DAS INTERFACES ===");
        System.out.println("Constante ICriatura.TIPO_CRIATURA_DEFEITO: "
                + ICriatura.TIPO_CRIATURA_DEFEITO);
        System.out.println("Constante IInimigo.VALOR_AMEACA_DEFEITO: "
                + IInimigo.VALOR_AMEACA_DEFEITO);
        System.out.println("Constante ITransformavel.TRANSFORMACOES_MAX: "
                + ITransformavel.TRANSFORMACOES_MAX);
        System.out.println("Constante redefinida Humano.TRANSFORMACOES_MAX: "
                + Humano.TRANSFORMACOES_MAX);
        
        // Teste final com a nova funcionalidade da classe Jogo para interfaces
        System.out.println("\n=== TESTE FINAL COM JOGO E INTERFACES ===");
        
        // Criação de um novo jogo para demonstrar as interfaces
        Jogo jogoInterface = new Jogo(humano);
        
        // Adição de criaturas
        jogoInterface.adicionaCriatura(humano).adicionaCriatura(orc);
        
        // Demonstração de processamento via interface
        System.out.println("\nProcessando criaturas via Jogo");
        
        // =====
        // TODO Implementação futura de métodos específicos na classe Jogo
        // =====
        // Nota: para demonstração completa serão necessários métodos na classe Jogo
        // para permitir o processamento de listaCriatura e listaInimigoInterface.
        
        System.out.println("\n=== FIM DA DEMONSTRAÇÃO COMPLETA ===");
        System.out.println("Total final de Humanóides: " + Humanoide.getTotalHumanoides());
    }
}
