package oop.tp4;

/**
 * Superclasse abstrata que representa um humanóide no jogo.
 * Esta classe demonstra diferentes tipos de modificadores de acesso:
 * - public: acessível por qualquer classe
 * - private: acessível apenas dentro desta classe
 * - protected: acessível por esta classe e as suas subclasses
 * - static: atributo de classe (compartilhado por todas as suas instâncias)
 * Implementa os métodos equals(), clone() e print().
 * 
 * @author Luis Matos
 */
public abstract class Humanoide implements Cloneable
{
    
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
     * Construtor vazio que utiliza o método this() para chamar outro construtor.
     * Demonstração da utilização do método this() para reutilização de código.
     */
    public Humanoide()
    {
        this(FACCAO_DEFEITO, 100.0); // Utilização do método this() para chamar o construtor principal
    }
    
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
        System.out.println("Humanóide criado com o ID: " + this.id);
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
        return this.id;
    }

    public double getPontosVida() {
        return this.pontosVida;
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
        return this.pontosVida > 0;
    }
    
    /**
     * Implementação do método equals() para comparar dois Humanoides.
     * Dois Humanoides são considerados iguais se possuírem o mesmo ID.
     * 
     * @param obj Objecto a ser comparado
     * @return true se os objectos forem iguais, false em caso contrário
     */
    @Override
    public boolean equals(Object obj)
    {
        // Utilização do this para comparar com outro objecto
        if (this == obj)
        {
            return true; // Retorna a mesma referência
        }
        if (obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }
        
        Humanoide outro = (Humanoide) obj;
        return this.id == outro.id; // Compara IDs
    }
    
    /**
     * Implementação do método clone() para criar uma cópia do objecto.
     * 
     * @return Uma cópia do Humanoide atual
     * @throws CloneNotSupportedException Se a clonagem não for suportada
     */
    @Override
    public Humanoide clone() throws CloneNotSupportedException
    {
        try
        {
            Humanoide clonado = (Humanoide) super.clone();
            // Nota: O ID não é clonado pois é único para cada instância
            // Para atribuir um novo id utilizaríamos por exemplo: -> clonado.id = ++totalHumanoides;
            return clonado;
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(); // Nunca deve de acontecer
        }
    }
    
    /**
     * Método print() para imprimir todos os atributos da superclasse.
     * Este método deve ser sobrescrito nas subclasses.
     */
    public void print()
    {
        System.out.println("=== ATRIBUTOS DA SUPERCLASSE HUMANOIDE ===");
        System.out.println("ID: " + this.id);
        System.out.println("Facção: " + this.faccao);
        System.out.println("Vida: " + this.pontosVida);
        System.out.println("Total de Humanóides: " + totalHumanoides);
    }
    
    /**
     * Método que demonstra o uso de this para passar a instância atual como parâmetro.
     * 
     * @return A própria instância (this) 
     */
    public Humanoide getEstaInstancia()
    {
        return this; // Retorna a referência para a instância atual
    }
    
    @Override
    public String toString()
    {
        return String.format("Humanóide[ID: %d, Facção: %s, Vida: %.1f]",
                this.id, this.faccao, this.pontosVida);
    }
    
    /**
     * Método para demonstrar o uso de this em contexto de comparação
     * 
     * @param outro Humanoide com o qual vamos comparar
     * @return true se este Humanoide tiver mais vida do que o outro
     */
    public boolean temMaisVidaQue(Humanoide outro)
    {
        return this.pontosVida > outro.pontosVida; // Uso do this para comparação
    }
}
