import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Estudante {
    int matricula;
    //trabalho[] nota;
    boolean aprovado;
    float notaFinal;
    Pessoa pessoa;

    public Estudante(){
        this.pessoa = new Pessoa("", "");
        this.matricula = 0;
        this.aprovado = false;
        this.notaFinal = 0;
    }

    public Estudante(Pessoa pessoa, int matricula, boolean aprovado, float notaFinal){
        this.pessoa = pessoa;
        this.matricula = matricula;
        this.aprovado = aprovado;
        this.notaFinal = notaFinal;
    }

    public void cadastrarEstudante(Scanner sc){
        this.pessoa = Pessoa.cadastrarPessoa(sc);
        System.out.printf("Digite a matricula, no formato XXXXXXXX: ");
        this.matricula = getMatricula(sc);
        this.aprovado = false;
        this.notaFinal = 0;
        showEstudante();
        fileEstudante();
    }

    private int getMatricula(Scanner sc){
        matricula = sc.nextInt();
        if (matricula > 99999999) {
            System.out.printf("\nA matricula digitada é invalida, digite outra");
            getMatricula(sc);
        }  
        return matricula;
    }

    private void showEstudante(){
        System.out.printf("-----------------------------------\n");
        System.out.printf("Aluno Cadastrado:\n");
        System.out.printf("Nome: %s\n", this.pessoa.nome);
        System.out.printf("CPF: %s\n", this.pessoa.cpf);
        System.out.printf("Matricula: %d\n", this.matricula);
        System.out.printf("Nota Final: %.2f\n", this.notaFinal);
        System.out.printf("Está Aprovado: %s\n", this.aprovado);
    }
    public boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
    private void fileEstudante(){
                try {
            String fileName = "lib/Estudante.csv";
            boolean fileExists = fileExists(fileName);

            FileWriter writer = new FileWriter(fileName, true);
            String estudanteData = String.format("%s, %s, %d, %.2f, %B \n", this.pessoa.nome, this.pessoa.cpf, this.matricula, this.notaFinal, this.aprovado);

            writer.write(estudanteData);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao adicionar estudante ao arquivo.");
            e.printStackTrace();
        }
    }
    public static void readEstudanteFile() throws IOException {
        
        System.out.println("--------------------------------");
        System.out.println("Estudantes Cadastrados:");
        System.out.println("--------------------------------");

        try {
            String fileName = "lib/Estudante.csv";
            int idEstudante = 1;
            FileReader arquivoReader = new FileReader(fileName);
            BufferedReader bufferedLeitura = new BufferedReader(arquivoReader);

            String linha;

            while ((linha = bufferedLeitura.readLine()) != null) {
                String[] dados = linha.split(",");
                String estudante = dados[0];
                String matricula = dados[2];
                String notaFinal = dados[3];
                System.out.println("Estudante " + idEstudante + ": " + estudante +"\nMatricula: " + matricula + "\nNota Total: " + notaFinal + "\n--------------------------------");
                idEstudante++;
            }

            bufferedLeitura.close();
            arquivoReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
