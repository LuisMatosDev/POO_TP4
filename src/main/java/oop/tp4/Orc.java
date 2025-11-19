package oop.tp4;

/**
 * Classe que representa um orc no jogo.
 * Estende a classe Humanoide e adiciona características específicas de orcs.
 * 
 * @author Luis Matos
 */
public class Orc extends Humanoide
{
    // Atributo privado específico da classe Orc.
    private int raiva;
    private boolean temSarrafo;
    
    /**
     * Construtor a utilizar o método this() para chamar outro construtor.
     */
    public Orc()
    {
        this("Horda", 120.00, 70, true); // Uso de this() para reutilização
    }
    
    /**
     * Construtor para a classe Orc.
     * 
     * @param faccao Facção do orc
     * @param pontosVida Vida inicial
     * @param raiva Nível de fúria (0-100)
     * @param temSarrafo Indica se o orc possui uma arma contundente
     */
    public Orc(String faccao, double pontosVida, int raiva, boolean temSarrafo)
    {   
        super(faccao, pontosVida);
        this.raiva = raiva;
        this.temSarrafo = temSarrafo;
    }
    
    /**
     * Implementação do método de ataque específico para orcs.
     * Orcs têm ataques baseados em fúria/raiva.
     */
    @Override
    public void atacar()
    {
        double danoBase = 15 + (this.raiva * 0.2);
        if (this.temSarrafo)
        {
            danoBase += 5;
        }
        System.out.printf("Orc ataca com fúria! Dano: %.1f\n", danoBase);
    }
    
    /**
     * Implementação do método de fala específico para orcs.
     */
    @Override
    public void falar()
    {
        System.out.println("Orc grunhe: Waaagh! Matar! Destruir!");
    }
    
    /**
     * Override do método print() para incluir os atributos específicos da classe Orc.
     */
    @Override
    public void print()
    {
        super.print(); // Chama o método print() da superclasse.
        System.out.println("=== ATRIBUTOS ESPECÍFICOS DA CLASSE ORC ===");
        System.out.println("" + this.raiva);
        System.out.println("" + this.temSarrafo);
    }
    
    /**
     * Override do método clone() para Orc.
     * 
     * @return Uma cópia do Orc atual
     * @throws CloneNotSupportedException Se a clonagem não for suportada 
     */
    @Override
    public Orc clone() throws CloneNotSupportedException
    {
        Orc clonado = (Orc) super.clone();
        return clonado;
    }
    
    /**
     * Override do método equals() para Orc.
     * @param obj Objecto a ser comparado
     * @return true se os objectos forem iguais, false em caso contrário
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj))
        {
            return false;
        }
        
        if (obj instanceof Orc)
        {
            Orc outro = (Orc) obj;
            return this.raiva == outro.raiva &&
                    this.temSarrafo == outro.temSarrafo;
        }
        return false;
    }
    
    /**
     * Método específico da classe Orc para entrar em fúria.
     * Aumenta o nível de fúria mas causa dano ao próprio.
     */
    public void enraivecer()
    {
        if (this.estaVivo())
        {
            this.raiva += 30;
            if (this.raiva > 100)
            {
                this.raiva = 100;
            }
            this.tomaDano(5); // Uso do this com o método da superclasse
            System.out.println("Orc entra em fúria! +30 de raiva, -5 de vida.");
        }
    }
    
    /**
     * Método para demonstrar encadeamento através do uso de this.
     * 
     * @param raiva Nova raiva
     * @return A própria instância para permitir encadeamento de métodos
     */
    public Orc setRaivaComThis(int raiva)
    {
        this.raiva = raiva;
        return this; //Retorna this para encadeamento
    }
    
    public int getRaiva() {
        return this.raiva;
    }

    public void setRaiva(int raiva) {
        this.raiva = raiva;
    }

    public boolean isTemSarrafo() {
        return this.temSarrafo;
    }

    public void setTemSarrafo(boolean temSarrafo) {
        this.temSarrafo = temSarrafo;
    }
    
    @Override
    public String toString()
    {
        return String.format("Orc[ID: %d, Facção: %s, Vida: %.1f, Rage: %d, Sarrafo: %s]",
                this.getId(), this.faccao, this.getPontosVida(),
                this.raiva, this.temSarrafo ? "SIM" : "NÃO");
    }
}
