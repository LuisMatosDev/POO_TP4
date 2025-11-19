package oop.tp4;

/**
 * Classe que representa um lobisomem no jogo.
 * Estende a classe Humanoide e adiciona características específicas de lobisomens.
 * 
 * @author Luis Matos
 */
public class Lobisomem extends Humanoide
{
    // Atributo privado específico da classe Lobisomem
    private boolean estaTransformado;
    private int poderDaLua;
    
    /**
     * Construtor que utiliza o método this() para chamar outro construtor da mesma classe.
     */
    public Lobisomem()
    {
        this("Selvagens", 90.0, 75); // Uso de this() para chamar o construtor principal.
    }
    
    /**
     * Construtor para a classe Lobisomem.
     * 
     * @param faccao Facção do lobisomem
     * @param pontosVida Vida inicial
     * @param poderDaLua Poder da lua (0-100)
     */
    public Lobisomem(String faccao, double pontosVida, int poderDaLua)
    {
        super(faccao, pontosVida);
        this.poderDaLua = poderDaLua;
        this.estaTransformado = false;
    }
    
    /**
     * Implementação do método de ataque específico para lobisomens.
     * O ataque varia dependendo se está transformado ou não.
     */
    @Override
    public void atacar()
    {
        if (this.estaTransformado)
        {
            double dano = 20 + (this.poderDaLua * 0.3);
            System.out.printf("Lobisomem ataca com garras! Dano: %.1f\n", dano);
        }
        else
        {
            System.out.println("Lobisomem ataca de forma humana! Dano: 8");
        }
    }
    
    /**
     * Implementação do método de fala específico para lobisomens.
     * A fala varia dependendo se está transformado ou não.
     */
    @Override
    public void falar()
    {
        if (this.estaTransformado)
        {
            System.out.println("Lobisomem uiva: Auuuuuu! *A lua chama por mim*");
        }
        else
        {
            System.out.println("Lobisomem diz: Gosto de passear na floresta durante a lua cheia...");
        }
    }
    
    /**
     * Override do método print() para incluir atributos específicos da classe Lobisomem.
     */
    @Override
    public void print()
    {
        super.print();
        System.out.println("=== ATRIBUTOS ESPECÍFICOS DA CLASSE LOBISOMEM ===");
        System.out.println("Poder da Lua: " + this.poderDaLua);
        System.out.println("Transformado: " + this.estaTransformado);
    }
    
    /**
     * Override do método clone() para Lobisomem.
     * 
     * @return Uma cópia do Lobisomem atual
     * @throws CloneNotSupportedException Se a clonagem não for suportada
     */
    @Override
    public Lobisomem clone() throws CloneNotSupportedException
    {
        Lobisomem clonado = (Lobisomem) super.clone();
        return clonado;
    }
    
    /**
     * Override do método equals() para Lobisomem.
     * 
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
        
        if (obj instanceof Lobisomem)
        {
            Lobisomem outro = (Lobisomem) obj;
            return this.poderDaLua == outro.poderDaLua &&
                    this.estaTransformado == outro.estaTransformado;
        }
        return false;
    }
    
    /**
     * Método específico para a transformação em lobisomem.
     * A transformação depende do poder da lua.
     */
    public void transformar()
    {
        if (this.poderDaLua >= 50 && !this.estaTransformado)
        {
            this.estaTransformado = true;
            this.cura(15); // Cura ao transformar-se
            System.out.println("Lobisomem transforma-se! +15 de vida.");
        }
        else if (this.estaTransformado)
        {
            this.estaTransformado = false;
            System.out.println("Lobisomem volta à forma humana.");
        }
        else
        {
            System.out.println("Poder da lua insuficiente para transformação.");
        }
    }
    
    /**
     * Método para demonstrar encadeamento através do uso de this.
     * 
     * @param poderDaLua Novo poder da lua
     * @return A própria instância para permitir encadeamento de métodos
     */
    public Lobisomem setPoderDaLuaComThis(int poderDaLua)
    {
        this.poderDaLua = poderDaLua;
        return this; // Retorna this para encadeamento
    }
    
    // Getters e Setters
    public boolean isEstaTransformado() {
        return this.estaTransformado;
    }

    public void setEstaTransformado(boolean estaTransformado) {
        this.estaTransformado = estaTransformado;
    }

    public int getPoderDaLua() {
        return this.poderDaLua;
    }

    public void setPoderDaLua(int poderDaLua) {
        this.poderDaLua = poderDaLua;
    }
    
    @Override
    public String toString()
    {
        return String.format("Lobisomem[ID: %d, Facção: %s, Vida: %.1f, Poder da Lua: %d, Transformado: %s]",
                this.getId(), this.faccao, this.getPontosVida(),
                this.poderDaLua, this.estaTransformado ? "SIM" : "NÃO");
    }
}
