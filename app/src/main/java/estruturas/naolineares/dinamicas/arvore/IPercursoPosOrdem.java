package estruturas.naolineares.dinamicas.arvore;

import java.util.function.Consumer;

public interface IPercursoPosOrdem<T> {

    //Percorre a árvore em pós-ordem
    //@param acao é uma função para processar o elemento de cada nó (Ex.: impressão)
    public void percorrerPosOrdem(Consumer<T> acao);

}