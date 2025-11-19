package oop.tp4;

/**
 * Classe que representa um humano no jogo.
 * Estende a classe Humanoide e adiciona características específicas de humanos.
 * 
 * @author Luis Matos
 */
public class Humano extends Humanoide
{
    // Atributo privado específico da classe Humano
    private int inteligencia;
    private boolean temArmadura;
    
    /**
     * Construtor que utiliza o método this() para chamar outro construtor da mesma classe.
     */
    public Humano()
    {
        this("Aliança", 100.0, 80, true); // Uso de this() para chamar o construtor principal.
    }
    
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
        double danoBase = 10 + (this.inteligencia * 0.1);
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
     * Override do método print() para incluir atributos específicos da classe Humano.
     */
    @Override
    public void print()
    {
        super.print(); // Chamada ao método print() da superclasse.
        System.out.println("=== ATRIBUTOS ESPECÍFICOS DA CLASSE HUMANO ===");
        System.out.println("Inteligência: " + this.inteligencia);
        System.out.println("Tem armadura: " + this.temArmadura);
        System.out.println("Está vivo: " + this.estaVivo()); // Uso do this com o método protegido.
    }
    
    /**
     * Override do método clone() para Humano.
     * 
     * @return Uma cópia do Humano atual
     * @throws CloneNotSupportedException Se a clonagem não for suportada
     */
    @Override
    public Humano clone() throws CloneNotSupportedException
    {
        Humano clonado = (Humano) super.clone(); // Chamada a clone() da superclasse
        // Atributos primitivos são automaticamente copiados
        return clonado;
    }
    
    /**
     * Override do método equals() para Humano.
     * 
     * @param obj Objecto a ser comparado
     * @return true se os objectos forem iguais, false em caso contrário
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj))
        {
            return false; // Chamada ao método equals() da superclasse primeiro.
        }
        
        if (obj instanceof Humano)
        {
            Humano outro = (Humano) obj;
            return this.inteligencia == outro.inteligencia &&
                    this.temArmadura == outro.temArmadura;
        }
        return false;
    }
    
    /**
     * Método específico da classe Humano para usar poções.
     * Demonstra o uso do método protegido estaVivo() da superclasse.
     */
    public void usarPocao()
    {
        if (this.estaVivo())
        {
            this.cura(25);
            System.out.println("Humano usa poção de cura! +25 pontos de vida.");
        }
        else
        {
            System.out.println("Humano não pode usar poção pois está morto.");
        }
    }
    
    /**
     * Método para demonstrar encadeamento através do uso de this.
     * 
     * @param inteligencia Nova inteligência
     * @return A própria instância para permitir encadeamento de métodos.
     */
    public Humano setInteligenciaComThis(int inteligencia)
    {
       this.inteligencia = inteligencia;
       return this; // Retorna this para encadeamento
    }

    public int getInteligencia()
    {
        return this.inteligencia;
    }

    public boolean isTemArmadura()
    {
        return this.temArmadura;
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
                this.getId(), this.faccao, this.getPontosVida(),
                this.inteligencia, this.temArmadura ? "SIM" : "NÃO");
    }
}
