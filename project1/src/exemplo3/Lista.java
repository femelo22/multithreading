package exemplo3;

public class Lista {
    private String[] elementos = new String[100];
    private int indice = 0;

    public void adicionaElementos(String elemento) {
        this.elementos[indice] = elemento;
        this.indice++;
    }

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }
}
