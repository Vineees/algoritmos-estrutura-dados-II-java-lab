package estruturas.naolineares.dinamicas.arvorebinaria;

public class AppArvoreBinaria {
    public static void main(String[] args) {

        //////////////
        ///Arvore 1///
        //////////////

        //Criando Nós
        NoArvoreBinaria<String> raiz = new NoArvoreBinaria<>("1");
        NoArvoreBinaria<String> no2 = new NoArvoreBinaria<>("2");
        NoArvoreBinaria<String> no3 = new NoArvoreBinaria<>("3");
        NoArvoreBinaria<String> no4 = new NoArvoreBinaria<>("4");
        NoArvoreBinaria<String> no5 = new NoArvoreBinaria<>("5");
        NoArvoreBinaria<String> no6 = new NoArvoreBinaria<>("6");
        NoArvoreBinaria<String> no7 = new NoArvoreBinaria<>("7");
        NoArvoreBinaria<String> no8 = new NoArvoreBinaria<>("8");
        NoArvoreBinaria<String> no9 = new NoArvoreBinaria<>("9");
        NoArvoreBinaria<String> no10 = new NoArvoreBinaria<>("10");


        raiz.definirNoEsquerdo(no2);
        raiz.definirNoDireito(no3);
        no2.definirNoEsquerdo(no5);
        no2.definirNoDireito(no4);
        no3.definirNoDireito(no6);
        no6.definirNoEsquerdo(no7);
        no6.definirNoDireito(no8);
        no8.definirNoEsquerdo(no9);
        no9.definirNoDireito(no10);

        // Cria a Árvore
        ArvoreBinariaSimples<String> arvore = new ArvoreBinariaSimples<>(raiz);

        // Verificando Propriedades
        System.out.println("Tamanho de um nó: " + arvore.tamanho());
        System.out.println("Altura de um nó: " + arvore.altura());
        System.out.println("Grau de um nó: " + arvore.grau());
        System.out.println("Vazia? " + arvore.estaVazia());
        System.out.println("Arestas " + arvore.arestas());
        System.out.println("Nivel do Nó 9 " + arvore.nivelNo("9"));
        System.out.println("Nivel do Nó 6 " + arvore.nivelNo("6"));

        // Percorrer em Pré - Ordém
        arvore.percorrerPreOrdem(System.out::print);  //1,2,5,4,3,6,7,8,9,10
        System.out.println("");
        arvore.percorrerEmOrdem(System.out::print);  //5,2,4,1,3,7,6,9,10,8
        System.out.println("");
        arvore.percorrerPosOrdem(System.out::print);  //5,4,2,7,10,9,8,6,3,1
        System.out.println("");
        arvore.percorrerEmOrdemDeNivel(System.out::print);  //1,2,3,5,4,6,7,8,9,10

        //////////////
        ///Arvore 2///
        //////////////

        //Criando Nós
        NoArvoreBinaria<String> raizA = new NoArvoreBinaria<>("A");
        NoArvoreBinaria<String> noB = new NoArvoreBinaria<>("B");
        NoArvoreBinaria<String> noC = new NoArvoreBinaria<>("C");
        NoArvoreBinaria<String> noD = new NoArvoreBinaria<>("D");
        NoArvoreBinaria<String> noE = new NoArvoreBinaria<>("E");
        NoArvoreBinaria<String> noF = new NoArvoreBinaria<>("F");
        NoArvoreBinaria<String> noG = new NoArvoreBinaria<>("G");
        NoArvoreBinaria<String> noH = new NoArvoreBinaria<>("H");
        NoArvoreBinaria<String> noI = new NoArvoreBinaria<>("I");
        NoArvoreBinaria<String> noJ = new NoArvoreBinaria<>("J");


        raizA.definirNoEsquerdo(noB);
        raizA.definirNoDireito(noC);
        noB.definirNoEsquerdo(noE);
        noB.definirNoDireito(noD);
        noC.definirNoDireito(noF);
        noF.definirNoEsquerdo(noG);
        noF.definirNoDireito(noH);
        noH.definirNoEsquerdo(noI);
        noI.definirNoDireito(noJ);

        // Cria a Árvore
        ArvoreBinariaSimples<String> arvoreA = new ArvoreBinariaSimples<>(raizA);

        // Verificando Propriedades
        System.out.println("");
        System.out.println("Tamanho de um nó: " + arvoreA.tamanho());
        System.out.println("Altura de um nó: " + arvoreA.altura());
        System.out.println("Grau de um nó: " + arvoreA.grau());
        System.out.println("Vazia? " + arvoreA.estaVazia());
        System.out.println("Arestas " + arvoreA.arestas());
        System.out.println("Nivel do Nó C: " + arvoreA.nivelNo("C"));
        System.out.println("Nivel do Nó I: " + arvoreA.nivelNo("I"));

        // Percorrer em Pré - Ordém
        arvoreA.percorrerPreOrdem(System.out::print);  //ABEDCFGHIJ
        System.out.println("");
        arvoreA.percorrerEmOrdem(System.out::print);  //EBDACGFIJH
        System.out.println("");
        arvoreA.percorrerPosOrdem(System.out::print);  //EDBGJIHFCA
        System.out.println("");
        arvoreA.percorrerEmOrdemDeNivel(System.out::print);  //ABCEDFGHIJ

        System.out.println("1 é polimorfica a A: " + arvore.verificarIsomorfiaCom(arvoreA));
        System.out.println("A é polimorfica a 1: " + arvoreA.verificarIsomorfiaCom(arvore));


    }

}