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
        this.showProfessor();
        this.fileProfessor();
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
        return currentId + 1;
    }

    private void showProfessor(){
        System.out.printf("-----------------------------------\n");
        System.out.printf("Aluno Cadastrado:\n");
        System.out.printf("Nome: %s\n", this.pessoa.nome);
        System.out.printf("CPF: %s\n", this.pessoa.cpf);
        System.out.printf("id: %d\n", this.id);
        System.out.printf("Salario: %.2f\n", this.salary);
    }

    public boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
    private void fileProfessor(){
                try {
            String fileName = "lib/Professor.csv";
            boolean fileExists = fileExists(fileName);

            FileWriter writer = new FileWriter(fileName, true);
            String professorData = String.format("%s, %s, %d, %.2f \n", this.pessoa.nome, this.pessoa.cpf, this.id, this.salary);

            writer.write(professorData);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao adicionar professor ao arquivo.");
            e.printStackTrace();
        }
    }
    
    public static void readProfessorFile() throws IOException {
        
        System.out.println("--------------------------------");
        System.out.println("Professsor Cadastrados:");
        System.out.println("--------------------------------");

        try {
            String fileName = "lib/Professor.csv";
            FileReader arquivoReader = new FileReader(fileName);
            BufferedReader bufferedLeitura = new BufferedReader(arquivoReader);

            String linha;

            while ((linha = bufferedLeitura.readLine()) != null) {
                String[] dados = linha.split(",");
                String professor = dados[0];
                String salary = dados[3];
                String idProfessor = dados[2];
                System.out.println("Proessor" + idProfessor + ": \nNome:" + professor +"\nMatricula:" + salary + "\n--------------------------------");

            }

            bufferedLeitura.close();
            arquivoReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}