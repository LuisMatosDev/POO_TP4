package oop.tp4;

/**
 * Interface que herda de ICriatura.
 * Define comportamentos específicos para inimigos.
 * @author Luis Matos
 */
public interface IInimigo extends ICriatura
{
    // Constante para valor de ameaça por defeito.
    int VALOR_AMEACA_DEFEITO = 5;
    
    /**
     * Método para calcular recompensa a atribuir pela derrota deste inimigo.
     * @return valor da recompensa
     */
    int calculaRecompensa();
    
    /**
     * Método para o inimgo realizar uma ação especial.
     */
    void acaoEspecial();
}
