package estruturas.naolineares.dinamicas.arvorebinaria;

import estruturas.naolineares.dinamicas.arvore.INoArvore;

public interface INoArvoreBinaria<T, N extends INoArvoreBinaria<T, N>> extends INoArvore<T> {

    //Retorna o filho esquerdo do nó
    public N obterNoEsquerdo();

    //Define o filho esquerdo do nó
    public void definirNoEsquerdo(N noEsquerdo);

    //Retorna o filho direito do nó
    public N obterNoDireito();

    //Define o filho direito do nó
    public void definirNoDireito(N noDireito);
}