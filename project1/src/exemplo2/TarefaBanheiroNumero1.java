package exemplo2;

public class TarefaBanheiroNumero1 implements Runnable {

    private Banheiro banheiro;

    public TarefaBanheiroNumero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.fazNumero1();
    }
}
