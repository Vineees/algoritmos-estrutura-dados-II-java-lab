package estruturas.naolineares.dinamicas.arvorebinaria;

import java.util.function.Consumer;

public interface IPercursoEmOrdem<T> {

    //Percorre a árvore em ordem
    //Obs.: Operação inerente a árvores binárias
    //@param acao é uma função para processar o elemento de cada nó (Ex.: impressão)
    public void percorrerEmOrdem(Consumer<T> acao);

}