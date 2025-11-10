package oop.tp4;

/**
 * Superclasse abstrata que representa um humanóide no jogo.
 * Esta classe demonstra diferentes tipos de modificadores de acesso:
 * - public: acessível por qualquer classe
 * - private: acessível apenas dentro desta classe
 * - protected: acessível por esta classe e as suas subclasses
 * - static: atributo de classe (compartilhado por todas as suas instâncias)
 * 
 * 
 * @author Luis Matos
 */
public abstract class Humanoide {
    
    // Atributo público - acessível por qualquer classe
    public String faccao;
    
    // Atributo privado - acessível apenas dentro desta classe
    private int id;
    
    // Atributo protegido - acessível por esta classe e as suas subclasses
    protected double pontosVida;
    
    // Atributo de classe (static) - compartilhado por todas as instâncias
    private static int totalHumanoides = 0;
    
    // Constante pública
    public static final String FACCAO_DEFEITO = "Neutral";
    
    /**
     * Construtor da classe Humanoide.
     * Incrementa o contador total de humanóides criados.
     * 
     * @param faccao Facção à qual o humanóide pertence
     * @param pontosVida Vida inicial do humanóide
     */
    public Humanoide(String faccao, double pontosVida)
    {
        this.faccao = faccao;
        this.pontosVida = pontosVida;
        this.id = ++totalHumanoides; // Atribui ID único e incrementa o contador
    }
    
    // Métodos públicos
    public void tomaDano(double dano)
    {
        this.pontosVida -= dano;
        if (this.pontosVida < 0 )
        {
            this.pontosVida = 0;
        }
    }
    
    public void cura(double quantidade)
    {
        this.pontosVida += quantidade;
    }
    
    // Métodos abstratos - a implementar nas subclasses
    public abstract void atacar();
    public abstract void falar();
    
    //Getters e setters

    public int getId() {
        return id;
    }

    public double getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(double pontosVida) {
        this.pontosVida = pontosVida;
    }
    
    /**
     * Método estático para obter o número total de humanóides criados.
     * 
     * @return Número total de humanóides instanciados
     */
    public static int getTotalHumanoides()
    {
        return totalHumanoides;
    }
    
    /**
     * Método protegido - acessível apenas por esta classes e as suas subclasses.
     * Verifica se o humanóide está vivo.
     * 
     * @return true se a vida for maior do que 0, false em caso contrário
     */
    protected boolean estaVivo()
    {
        return pontosVida > 0;
    }
    
    @Override
    public String toString()
    {
        return String.format("Humanóide[ID: %d, Facção: %s, Vida: %.1f]",
                id, faccao, pontosVida);
    }
    
}
