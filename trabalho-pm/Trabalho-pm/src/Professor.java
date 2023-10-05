import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Professor{
    int id;
    float salary;
    Pessoa pessoa;

    public Professor(){
        this.pessoa = new Pessoa("", "");
        this.id = 0;
        this.salary = 0;
    }

    public Professor(Pessoa pessoa, int id, float salary){
        this.pessoa = pessoa;
        this.id = id;
        this.salary = salary;
    }
    public void cadastrarProfessor(Scanner sc){
        this.pessoa = Pessoa.cadastrarPessoa(sc);
        System.out.println("Insira o Salário do Professor");
        this.salary = sc.nextFloat();
        this.id = setId();
        System.out.println(id);
    }

    private int setId(){
        int currentId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("lib/Professor.csv"))) {
            String line;

            // Lê cada linha do arquivo
            while ((line = br.readLine()) != null) {
                // A cada quebra de linha, incrementa o ID
                currentId++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentId;
    }
}