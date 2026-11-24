package estruturas.naolineares.dinamicas.arvore;

import java.util.function.Consumer;

public interface IPercursoEmOrdemDeNivel<T> {

    //Percorre a árvore em ordem de nível
    //@param acao é uma função para processar o elemento de cada nó (Ex.: impressão)
    public void percorrerEmOrdemDeNivel(Consumer<T> acao);

}