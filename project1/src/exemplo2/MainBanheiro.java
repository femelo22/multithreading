package exemplo2;

public class MainBanheiro {

    public static void main(String[] args) {

        //Sincronizar as threads, não deixa que 2 requisiçoes executem a mesma thread ao mesmo tempo

        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(new TarefaBanheiroNumero1(banheiro), "Joao");
        Thread convidado2 = new Thread(new TarefaBanheiroNumero2(banheiro), "Pedro");
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
        limpeza.setDaemon(true); //Quando não tem mais theads rodando, essa thread para de executar

        convidado1.start();
        convidado2.start();
        limpeza.start();
    }
}
