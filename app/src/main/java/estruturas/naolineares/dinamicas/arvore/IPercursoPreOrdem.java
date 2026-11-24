package estruturas.naolineares.dinamicas.arvore;

import java.util.function.Consumer;

public interface IPercursoPreOrdem<T> {

    //Percorre a árvore em pré-ordem
    //@param acao é uma função para processar o elemento de cada nó (Ex.: impressão)
    void percorrerPreOrdem(Consumer<T> acao);

}