package estruturas.naolineares.dinamicas.arvoregeral;

import estruturas.naolineares.dinamicas.arvore.ArvoreAbstrata;

public class ArvoreGeral<T> extends ArvoreAbstrata<T, NoArvoreGeral<T>> implements estruturas.naolineares.dinamicas.arvore.IArvore<T, NoArvoreGeral<T>>, estruturas.naolineares.dinamicas.arvore.IPercursoPreOrdem<T>, estruturas.naolineares.dinamicas.arvore.IPercursoPosOrdem<T>, estruturas.naolineares.dinamicas.arvore.IPercursoEmOrdemDeNivel<T> {

    public ArvoreGeral() {}

    public ArvoreGeral(NoArvoreGeral<T> noRaiz) {
        this.definirNoRaiz(noRaiz);
    }

    @Override
    protected Iterable<NoArvoreGeral<T>> filhosDe(NoArvoreGeral<T> no) {
        return no.obterFilhos();
    }

}