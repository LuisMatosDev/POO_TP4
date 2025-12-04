package oop.tp4;

/**
 * Interface para criaturas do jogo.
 * Define comportamentos básicos para todas as criaturas.
 * @author Luis Matos
 */
public interface ICriatura
{
    // Constante para tipo de criatura
    String TIPO_CRIATURA_DEFEITO = "Desconhecido";
    
    /**
     * Método para a criatura emitir um som característico
     */
    void sonoriza();
    
    /**
     * Método para verificar se a criatura está ativa.
     * @return true se a criatura está ativa, false caso contrário
     */
    boolean estaAtivo();
}
