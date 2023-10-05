
import java.util.Scanner;

public class Pessoa {
        String nome, cpf;

        public Pessoa(String nome, String cpf){
            this.nome = nome;
            this.cpf = cpf;
        }

        public static Pessoa cadastrarPessoa(Scanner sc) {
        String buxa = sc.nextLine();
        System.out.printf("Digite o nome da pessoa: ");
        String nome = sc.nextLine();
        System.out.printf("Digite o cpf da pessoa: ");
        String cpf = sc.nextLine();   
        return new Pessoa(nome, cpf);
    }

}
