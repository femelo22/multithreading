package exemplo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

    private String arquivo;
    private String nome;

    public TarefaBuscaTextual(String arquivo, String nome) {
        this.arquivo = arquivo;
        this.nome = nome;
    }

    @Override
    public void run() {
        int numeroLinha = 1;

        try {
            Scanner scanner = new Scanner(new File(arquivo));

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                if(linha.toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println(arquivo + " - " + numeroLinha + " - " + linha);
                }

                numeroLinha++;

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
