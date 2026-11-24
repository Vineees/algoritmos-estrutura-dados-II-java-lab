package estruturas.naolineares.dinamicas.arvorebinaria;

import estruturas.naolineares.dinamicas.arvore.ArvoreAbstrata;

public abstract class ArvoreBinariaAbstrata <T, N extends INoArvoreBinaria<T, N>>
        extends ArvoreAbstrata<T, N>
        implements IArvoreBinaria<T, N> {

    @Override
    protected Iterable<N> filhosDe(N no) {
        java.util.List<N> filhos = new java.util.ArrayList<>(2);
        if (no.obterNoEsquerdo() != null) filhos.add(no.obterNoEsquerdo());
        if (no.obterNoDireito() != null) filhos.add(no.obterNoDireito());
        return filhos;
    }

    @Override
    public void percorrerEmOrdem(java.util.function.Consumer<T> acao) {
        this.percorrerEmOrdem(this.obterNoRaiz(), acao);
    }

    private void percorrerEmOrdem(N no, java.util.function.Consumer<T> acao) {
        if (no == null) return;

        percorrerEmOrdem(no.obterNoEsquerdo(), acao);
        acao.accept(no.obterElemento());
        percorrerEmOrdem(no.obterNoDireito(), acao);
    }

    @Override
    public boolean verificarIsomorfiaCom(IArvoreBinaria<T, ? extends INoArvoreBinaria<T, ?>> outraArvore) {
        if (outraArvore == null) return false;
        return this.verificarIsomorfiaCom(this.obterNoRaiz(), outraArvore.obterNoRaiz());
    }

    private boolean verificarIsomorfiaCom(INoArvoreBinaria<T, ?> noRaiz, INoArvoreBinaria<T, ?> noRaizOutraArvore) {
        if (noRaiz == null || noRaizOutraArvore == null) {
            return noRaiz == null && noRaizOutraArvore == null;
        }

        boolean esquerdaIsomorfica = verificarIsomorfiaCom(
                noRaiz.obterNoEsquerdo(),
                noRaizOutraArvore.obterNoEsquerdo());
        if (!esquerdaIsomorfica) return false;

        return verificarIsomorfiaCom(
                noRaiz.obterNoDireito(),
                noRaizOutraArvore.obterNoDireito());
    }

}