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
        if (estaTransformado)
        {
            double dano = 20 + (poderDaLua * 0.3);
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
    public void falar()
    {
        if (estaTransformado)
        {
            System.out.println("Lobisomem uiva: Auuuuuu! *A lua chama por mim*");
        }
        else
        {
            System.out.println("Lobisomem diz: Gosto de passear na floresta durante a lua cheia...");
        }
    }
    
    /**
     * Método específico para a transformação em lobisomem.
     * A transformação depende do poder da lua.
     */
    public void transformar()
    {
        if (poderDaLua >= 50 && !estaTransformado)
        {
            estaTransformado = true;
            cura(15); // Cura ao transformar-se
            System.out.println("Lobisomem transforma-se! +15 de vida.");
        }
        else if (estaTransformado)
        {
            estaTransformado = false;
            System.out.println("Lobisomem volta à forma humana.");
        }
        else
        {
            System.out.println("Poder da lua insuficiente para transformação.");
        }
    }
    
    // Getters e Setters
    public boolean isEstaTransformado() {
        return estaTransformado;
    }

    public void setEstaTransformado(boolean estaTransformado) {
        this.estaTransformado = estaTransformado;
    }

    public int getPoderDaLua() {
        return poderDaLua;
    }

    public void setPoderDaLua(int poderDaLua) {
        this.poderDaLua = poderDaLua;
    }
    
    @Override
    public String toString()
    {
        return String.format("Lobisomem[ID: %d, Facção: %s, Vida: %.1f, Poder da Lua: %d, Transformado: %s]",
                getId(), faccao, getPontosVida(), poderDaLua, estaTransformado ? "SIM" : "NÃO");
    }
}
