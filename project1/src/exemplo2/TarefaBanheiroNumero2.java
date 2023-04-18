package exemplo2;

public class TarefaBanheiroNumero2 implements Runnable {

    private Banheiro banheiro;

    public TarefaBanheiroNumero2(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.fazNumero2();
    }
}
