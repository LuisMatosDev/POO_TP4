package oop.tp4;

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
   
   /**
    * Construtor da classe Jogo.
    * 
    * @param inimigoInicial Inimigo inicial do jogo
    */
   public Jogo(Humanoide inimigoInicial)
   {
       this.inimigoAtual = inimigoInicial;
       this.estadoJogo = "A CORRER!";
   }
   
   /**
    * Método para atacar o inimigo atual.
    * Demonstra o polimorfismo - o método atacar() será chamado
    * dependendo do tipo real do objecto.
    */
   public void atacarInimigo()
   {
       if (inimigoAtual != null && inimigoAtual.getPontosVida() > 0)
       {
           System.out.println("\n--- Ataque ao Inimigo ---");
           inimigoAtual.atacar();
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
       if (inimigoAtual != null)
       {
           System.out.println("\n--- Inimigo Fala ---");
           inimigoAtual.falar();
       }
   }
   
   /**
    * Método para causar dano ao inimigo atual.
    * 
    * @param dano Quantidade de dano a causar
    */
   public void causarDanoInimigo(double dano)
   {
       if (inimigoAtual != null && inimigoAtual.getPontosVida() > 0)
       {
           inimigoAtual.tomaDano(dano);
           System.out.printf("Inimigo sofreu %.1f de dano! Vida restante: %.1f\n",
                   dano, inimigoAtual.getPontosVida());
           if (inimigoAtual.getPontosVida() <= 0)
           {
               System.out.println("Inimigo derrotado.");
           }
       }
   }
   
   /**
    * Método para definir um novo inimigo.
    * 
    * @param novoInimigo Novo inimigo a ser definido
    */
   public void defineInimigoAtual(Humanoide novoInimigo)
   {
       this.inimigoAtual = novoInimigo;
       System.out.println("Novo inimigo definido: " + novoInimigo.getClass().getSimpleName());
   }

   public Humanoide getInimigoAtual()
   {
        return inimigoAtual;
   }

   public void setInimigoAtual(Humanoide inimigoAtual)
   {
      this.inimigoAtual = inimigoAtual;
   }
   
   public String getEstadoJogo()
   {
       return estadoJogo;
   }

   public void setEstadoJogo(String estadoJogo)
   {
       this.estadoJogo = estadoJogo;
   }
   
   /**
    * Método para exibir as informações do inimigo atual.
    */
   public void mostraInfoInimigo()
   {
       if (inimigoAtual != null)
       {
           System.out.println("\n--- Informações do Inimigo ---");
           System.out.println(inimigoAtual.toString());
       }
       else
       {
           System.out.println("Nenhum inimigo definido.");
       }
   }
}
