package oop.tp4;

/**
 * Interface para entidades que se podem transformar.
 * Define os comportamentos da transformação.
 * @author Luis Matos
 */
public interface ITransformavel
{
    // Constante para o valor máximo de transformações.
    int TRANSFORMACOES_MAX = 3;
    
    /**
     * Método para iniciar a transformação.
     */
    void iniciaTransformacao();
    
    /**
     * Método para reverter a transformação.
     */
    void reverteTransformacao();
}
