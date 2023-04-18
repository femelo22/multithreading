package exemplo2;

public class Banheiro {

    private boolean ehSujo = true;
    public void fazNumero1() {

        String nome = Thread.currentThread().getName();

        System.out.println(nome + "Batendo na porta");

        synchronized (this) {

            System.out.println(nome + " Entrando no banheiro");

            while(ehSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " Entrando no banheiro");
            System.out.println(nome + " Fazendo o numero 1");

            esperaUmPouco(5000);

            this.ehSujo = true;

            System.out.println(nome + " Dando descarga");
            System.out.println(nome + " Lavando a mão");
            System.out.println(nome + " Saindo do banheiro");
        }

    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + "Batendo na porta");

        synchronized (this) {
            System.out.println(nome + " Entrando no banheiro");

            while(ehSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " Fazendo o numero 2");

            esperaUmPouco(10000);

            this.ehSujo = true;

            System.out.println(nome + " Dando descarga");
            System.out.println(nome + " Lavando a mão");
            System.out.println(nome + " Saindo do banheiro");
        }

    }

    public void limpa() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Batendo na porta");

        synchronized (this) {

            System.out.println(nome + " Entrando no banheiro");

            if(!ehSujo) {
                System.out.println(nome + ", não está sujo, vou sair.");
                return;
            }
            esperaUmPouco(7000);

            System.out.println(nome + " Limpando banheiro");
            this.ehSujo = false;

            this.notifyAll();

            System.out.println(nome + " Saindo do banheiro");
        }

    }

    public void esperaUmPouco(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public void esperaLaFora(String nome) {
        System.out.println(nome + ", opaa, banheiro tá sujo!");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
