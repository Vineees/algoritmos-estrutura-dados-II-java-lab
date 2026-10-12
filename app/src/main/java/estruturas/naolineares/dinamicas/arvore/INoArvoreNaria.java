package estruturas.naolineares.dinamicas.arvore;

public interface INoArvoreNaria<T, N extends INoArvoreNaria<T,N>> extends INoArvore<T>{

    public Iterable<N> obterFilhos();

    public void adicionarFilho(N filho);
}
