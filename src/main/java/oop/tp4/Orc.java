package oop.tp4;

/**
 * Classe que representa um orc no jogo.
 * Estende a classe Humanoide e adiciona características específicas de orcs.
 * @author Luis Matos
 */
public class Orc extends Humanoide
{
    // Atributo privado específico da classe Orc.
    private int raiva;
    private boolean temSarrafo;
    
    
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
        double danoBase = 15 + (raiva * 0.2);
        if (temSarrafo)
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
     * Método específico da classe Orc para entrar em fúria.
     * Aumenta o nível de fúria mas causa dano ao próprio.
     */
    public void enraivecer()
    {
        if (estaVivo())
        {
            raiva += 30;
            if (raiva > 100)
            {
                raiva = 100;
            }
            tomaDano(5); // Dano por fúria excessiva
            System.out.println("Orc entra em fúria! +30 de raiva, -5 de vida.");
        }
    }

    public int getRaiva() {
        return raiva;
    }

    public void setRaiva(int raiva) {
        this.raiva = raiva;
    }

    public boolean isTemSarrafo() {
        return temSarrafo;
    }

    public void setTemSarrafo(boolean temSarrafo) {
        this.temSarrafo = temSarrafo;
    }
    
    @Override
    public String toString()
    {
        return String.format("Orc[ID: %d, Facção: %s, Vida: %.1f, Rage: %d, Sarrafo: %s",
                getId(), faccao, getPontosVida(), raiva, temSarrafo ? "SIM" : "NÃO");
    }
}
