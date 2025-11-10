package oop.tp4;

/**
 * Classe que representa um humano no jogo.
 * Estende a classe Humanoide e adiciona características específicas de humanos.
 * @author Luis Matos
 */
public class Humano extends Humanoide
{
    // Atributo privado específico da classe Humano
    private int inteligencia;
    private boolean temArmadura;
    
    /**
     * Construtor para a classe Humano.
     * 
     * @param faccao Facção a qual o humano pertence
     * @param pontosVida Vida inicial
     * @param inteligencia Nível de inteligência (0-100)
     * @param temArmadura Indica se o humano possui armadura
     */
    public Humano(String faccao, double pontosVida, int inteligencia, boolean temArmadura)
    {
        super(faccao, pontosVida);
        this.inteligencia = inteligencia;
        this.temArmadura = temArmadura;
    }
    
    /**
     * Implementação do método de ataque específico para humanos.
     * Humanos podem usar ataques baseados em inteligência.
     */
    @Override
    public void atacar()
    {
        double danoBase = 10 + (inteligencia * 0.1);
        System.out.printf("Humano ataca com espada! Dano: %.1f\n", danoBase);
    }
    
    /**
     * Implementação do método de fala específico para humanos.
     */
    @Override
    public void falar()
    {
        System.out.println("Humano diz: Pela honra e pela glória!");
    }
    
    /**
     * Método específico da classe Humano para usar poções.
     * Demonstra o uso do método protegido estaVivo() da superclasse.
     */
    public void usarPocao()
    {
        if (estaVivo())
        {
            cura(25);
            System.out.println("Humano usa poção de cura! +25 pontos de vida.");
        }
        else
        {
            System.out.println("Humano não pode usar poção pois está morto.");
        }
    }

    public int getInteligencia()
    {
        return inteligencia;
    }

    public boolean isTemArmadura()
    {
        return temArmadura;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setTemArmadura(boolean temArmadura) {
        this.temArmadura = temArmadura;
    }
    
    @Override
    public String toString()
    {
        return String.format("Humano[ID: %s, Facção: %s, Vida: %.1f, Inteligência: %d, Armadura: %s]",
                getId(), faccao, getPontosVida(), inteligencia, temArmadura ? "SIM" : "NÃO");
    }
}
