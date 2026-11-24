package estruturas.naolineares.dinamicas.arvorebinaria;

import estruturas.naolineares.dinamicas.arvore.IArvore;
import estruturas.naolineares.dinamicas.arvore.IPercursoEmOrdemDeNivel;
import estruturas.naolineares.dinamicas.arvore.IPercursoPosOrdem;
import estruturas.naolineares.dinamicas.arvore.IPercursoPreOrdem;

public interface IArvoreBinaria<T, N extends INoArvoreBinaria<T, N>>
        extends IArvore<T, N>,
        IPercursoPreOrdem<T>,
        IPercursoEmOrdem<T>,
        IPercursoPosOrdem<T>,
        IPercursoEmOrdemDeNivel<T> {

    //Verifica se ambas são isomórficas, ou seja, se a árvore passada por parâmetro possui exatamente a mesma forma estrutural, independentemente dos elementos armazenados.
    public boolean verificarIsomorfiaCom(IArvoreBinaria<T, ? extends INoArvoreBinaria<T, ?>> outraArvore);

}