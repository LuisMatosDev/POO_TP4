package oop.tp4;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que gere o jogo e contém uma referência para um Humanóide.
 * Esta classe demonstra o uso de composição e polimorfismo.
 * 
 * @author Luis Matos
 */
public class Jogo
{
   // Atributo privado que é uma referência para a superclasse Humanoide
   private Humanoide inimigoAtual;
   private String estadoJogo;
   
   // Lista para demonstração de coleções
   private List<Humanoide> listaInimigo;
   
   /**
    * Construtor da classe Jogo.
    * 
    * @param inimigoInicial Inimigo inicial do jogo
    */
   public Jogo(Humanoide inimigoInicial)
   {
       this.inimigoAtual = inimigoInicial;
       this.estadoJogo = "A CORRER!";
       this.listaInimigo = new ArrayList<>(); // Inicializa a lista
   }
   
   /**
    * Método para atacar o inimigo atual.
    * Demonstra o polimorfismo - o método atacar() será chamado
    * dependendo do tipo real do objecto.
    */
   public void atacarInimigo()
   {
       if (this.inimigoAtual != null && this.inimigoAtual.getPontosVida() > 0)
       {
           System.out.println("\n--- Ataque ao Inimigo ---");
           this.inimigoAtual.atacar(); // Seleção dinâmica de método
       }
       else
       {
           System.out.println("Nenhum inimigo válido para atacar.");
       }
   }
   
   /**
    * Método para fazer o inimigo atual falar.
    * Demonstra o polimorfismo - o método falar() será chamado
    * dependendo do tipo real do objecto.
    */
   public void inimigoFala()
   {
       if (this.inimigoAtual != null)
       {
           System.out.println("\n--- Inimigo Fala ---");
           this.inimigoAtual.falar();
       }
   }
   
   /**
    * Método para causar dano ao inimigo atual.
    * 
    * @param dano Quantidade de dano a causar
    */
   public void causarDanoInimigo(double dano)
   {
       if (this.inimigoAtual != null && this.inimigoAtual.getPontosVida() > 0)
       {
           this.inimigoAtual.tomaDano(dano);
           System.out.printf("Inimigo sofreu %.1f de dano! Vida restante: %.1f\n",
                   dano, this.inimigoAtual.getPontosVida());
           if (this.inimigoAtual.getPontosVida() <= 0)
           {
               System.out.println("Inimigo derrotado.");
           }
       }
   }
   
   /**
    * Método para adicionar inimigos à lista.
    * Demonstra o uso de coleções com polimorfismo.
    * 
    * @param inimigo Inimigo a adicionar
    * @return A própria instância para encadeamento
    */
   public Jogo adicionaInimigo(Humanoide inimigo)
   {
       this.listaInimigo.add(inimigo);
       return this; // Retorna this para encadeamento
   }
   
   /**
    * Método que demonstra a seleção dinâmica através do uso de um array.
    * Executa ações em todos os inimigos do array.
    * @param inimigos Array que contém os inimigos
    */
   public void processaArrayInimigos(Humanoide[] inimigos)
   {
       System.out.println("\n=== PROCESSAMENTO DE ARRAY DE INIMIGOS ===");
       for (int i = 0; i < inimigos.length; i++)
       {
           System.out.println("\n--- Processando inimigo " + (i + 1) + " ---");
           inimigos[i].print(); // Seleção dinâmica do método print()
           inimigos[i].falar(); // Seleção dinâmica do método falar()
       }
   }
   
   /**
    * Método que demonstra a seleção dinâmica através de uma coleção.
    * Executa ações em todos os inimigos da lista.
    */
   public void processaColecaoInimigo()
   {
       System.out.println("\n=== PROCESSAMENTO DE COLEÇÃO DE INIMIGOS ===");
       for (Humanoide inimigo : this.listaInimigo)
       {
           System.out.println("\n--- Processando inimigo da lista ---");
           inimigo.print(); // Seleção dinâmica do método print()
           inimigo.atacar(); // Seleção dinâmica do método atacar()
       
           // Demonstração do uso de instanceof e casting
           if (inimigo instanceof Humano)
           {
                Humano humano = (Humano) inimigo;
                humano.usarPocao();
           }
           else if (inimigo instanceof Orc)
           {
                Orc orc = (Orc) inimigo;
                orc.enraivecer();
           }
           else if (inimigo instanceof Lobisomem)
           {
                Lobisomem lobisomem = (Lobisomem) inimigo;
                lobisomem.transformar();
           }
       }
   }
   
   /**
    * Método para demonstrar o uso de clone() na coleção.
    */
   public void demonstraClonagem()
   {
       System.out.println("\n=== DEMONSTRAÇÃO DE CLONAGEM ===");
       if (!this.listaInimigo.isEmpty())
       {
           try
           {
               Humanoide original = this.listaInimigo.get(0);
               Humanoide clone = original.clone();
               
               System.out.println("Original: " + original);
               System.out.println("Clone: " + clone);
               System.out.println("São o mesmo objecto? " + (original == clone));
               System.out.println("São iguais? " + original.equals(clone));
           }
           catch (CloneNotSupportedException e)
           {
               System.out.println("Clonagem não suportada: " + e.getMessage());
           }
       }
   }
   
   /**
    * Método para demonstar o uso de equals().
    */
   public void demonstraEquals()
   {
       System.out.println("\n=== DEMONSTRAÇÃO DE EQUALS ===");
       if (this.listaInimigo.size() >= 2)
       {
           Humanoide inimigo1 = this.listaInimigo.get(0);
           Humanoide inimigo2 = this.listaInimigo.get(1);
           
           System.out.println("Inimigo #1: " + inimigo1);
           System.out.println("Inimigo #2: " + inimigo2);
           System.out.println("São iguais? " + inimigo1.equals(inimigo2));
       }
   }
   
   public Humanoide getInimigoAtual()
   {
        return this.inimigoAtual;
   }
   
   public void setInimigoAtual(Humanoide novoInimigo)
   {
       this.inimigoAtual = novoInimigo;
       System.out.println("Novo inimigo definido: " + novoInimigo.getClass().getSimpleName());
   }

   public String getEstadoJogo()
   {
       return this.estadoJogo;
   }

   public void setEstadoJogo(String estadoJogo)
   {
       this.estadoJogo = estadoJogo;
   }
   
   public List<Humanoide> getListaInimigo()
   {
       return this.listaInimigo;
   }
   /**
    * Método para exibir as informações do inimigo atual.
    */
   public void mostraInfoInimigo()
   {
       if (this.inimigoAtual != null)
       {
           System.out.println("\n--- Informações do Inimigo ---");
           this.inimigoAtual.print(); // Chama método print() polimórfico
       }
       else
       {
           System.out.println("Nenhum inimigo definido.");
       }
   }
   
   /**
    * Método que retorna this para encadeamento.
    * 
    * @param estadoJogo Novo estado de jogo
    * @return A própria instância
    */
   public Jogo setEstadoJogoComThis(String estadoJogo)
   {
       this.estadoJogo = estadoJogo;
       return this;
   }
}
