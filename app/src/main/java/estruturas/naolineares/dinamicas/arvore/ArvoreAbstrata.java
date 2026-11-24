package estruturas.naolineares.dinamicas.arvore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ArvoreAbstrata<T, N extends INoArvore<T>>
        implements IArvore<T, N>,
        IPercursoPreOrdem<T>,
        IPercursoPosOrdem<T>,
        IPercursoEmOrdemDeNivel<T> {

    private N noRaiz;

    @Override
    public N obterNoRaiz() {
        return this.noRaiz;
    }

    @Override
    public void definirNoRaiz(N noRaiz) {
        this.noRaiz = noRaiz;
    }

    protected abstract Iterable<N> filhosDe(N no);

    @Override
    public int tamanho() {
        return tamanho(this.noRaiz);
    }

    private int tamanho(N no) {
        if (no == null) return 0;
        int tamanho = 1;
        for (N filho : this.filhosDe(no)) {
            tamanho += this.tamanho(filho);
        }
        return tamanho;
    }

    @Override
    public int altura() {
        return altura(this.noRaiz);
    }

    private int altura(N no) {
        if (no == null) return -1;
        int maiorAlturaFilhos = -1;
        for (N filho : this.filhosDe(no)) {
            maiorAlturaFilhos = Math.max(maiorAlturaFilhos, this.altura(filho));
        }
        return 1 + maiorAlturaFilhos;
    }

    @Override
    public int grau() {
        if (this.estaVazia()) return -1;
        return grau(this.noRaiz);
    }

    private int grau(N no) {
        if (no == null) return -1;
        int grau = no.grau();
        for (N filho : this.filhosDe(no)) {
            grau = Math.max(grau, this.grau(filho));
        }
        return grau;
    }

    @Override
    public int arestas() {
        return this.estaVazia() ? -1 : this.tamanho() - 1;
    }

    @Override
    public int nivelNo(T elemento) {
        return nivelNo(this.noRaiz, elemento, 0);
    }

    private int nivelNo(N no, T elemento, int nivelAtual) {
        if (no == null) return -1;
        if (Objects.equals(no.obterElemento(), elemento)) {
            return nivelAtual;
        }
        for (N filho : this.filhosDe(no)) {
            int nivel = this.nivelNo(filho, elemento, nivelAtual + 1);
            if (nivel != -1) return nivel;
        }
        return -1;
    }

    @Override
    public Iterable<N> recuperarIrmaosDe(T elemento) {
        List<N> irmaos = new ArrayList<>();
        if (this.estaVazia()) {return irmaos;}
        if (Objects.equals(this.obterNoRaiz().obterElemento(), elemento)) {
            return irmaos;
        }
        List<N> resultado = this.recuperarIrmaosDe(this.obterNoRaiz(), elemento);
        return resultado != null ? resultado : irmaos;
    }

    private List<N> recuperarIrmaosDe(N noAtual, T elemento) {
        if (noAtual == null) {
            return null;
        }
        for (N filho : this.filhosDe(noAtual)) {
            // Encontrou o nó cujo elemento foi passado por parâmetro
            if (Objects.equals(filho.obterElemento(), elemento)) {
                List<N> irmaos = new ArrayList<>();
                for (N candidatoIrmao : this.filhosDe(noAtual)) {
                    if (candidatoIrmao != filho) {
                        irmaos.add(candidatoIrmao);
                    }
                }
                return irmaos;
            }
            List<N> resultado = this.recuperarIrmaosDe(filho, elemento);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    @Override
    public void percorrerPreOrdem(java.util.function.Consumer<T> acao) {
        this.percorrerPreOrdem(this.noRaiz, acao);
    }

    private void percorrerPreOrdem(N no, java.util.function.Consumer<T> acao) {
        if (no == null) return;
        acao.accept(no.obterElemento());
        for (N filho : this.filhosDe(no)) this.percorrerPreOrdem(filho, acao);
    }

    @Override
    public void percorrerPosOrdem(java.util.function.Consumer<T> acao) {
        this.percorrerPosOrdem(this.noRaiz, acao);
    }

    private void percorrerPosOrdem(N no, java.util.function.Consumer<T> acao) {
        if (no == null) return;
        for (N filho : this.filhosDe(no)) this.percorrerPosOrdem(filho, acao);
        acao.accept(no.obterElemento());
    }

    @Override
    public void percorrerEmOrdemDeNivel(java.util.function.Consumer<T> acao) {
        if (this.noRaiz == null) return;
        java.util.Queue<N> fila = new java.util.LinkedList<>();
        fila.add(this.noRaiz);

        while (!fila.isEmpty()) {
            N atual = fila.poll();
            acao.accept(atual.obterElemento());
            for (N filho : this.filhosDe(atual)) {
                fila.add(filho);
            }
        }
    }

}