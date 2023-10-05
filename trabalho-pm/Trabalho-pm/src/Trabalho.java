import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Trabalho {
    int id, numIntegrantes, notaTotal, notaFinal;
    String  titulo, descrições, participantesNoObject[];
    Professor orientador;
    Estudante[] participante = new Estudante[1000];
    int tControler, eControler;

    public Trabalho(){
        this.id = 0;
        this.numIntegrantes = 0;
        this.notaTotal = 0;
        this.notaFinal = 0;
        this.titulo = "";
        this.descrições = ""; 
        this.orientador = new Professor(new Pessoa("", ""), 0, 0);
        for(int i=0; i < 1000; i++){ this.participante[i] = new Estudante(new Pessoa("", ""), 0, false, 0 );}
    }

    public Trabalho( int id, int numIntegrantes, int notaTotal, int notaFinal, String titulo, String descrições, Professor orientado, Estudante participante){
        this.id = id;
        this.numIntegrantes = numIntegrantes;
        this.notaTotal = notaTotal;
        this.notaFinal = notaFinal;
        this.titulo = titulo;
        this.descrições = descrições; 
        this.orientador = orientador;
        for(int i=0; i < 1000; i++){this.participante[0] = participante;}
    }

    public void novoTrablho(Scanner sc) throws IOException{
        String buxa = sc.nextLine();
        System.out.printf("Digite o nome do trabalho:");
        this.titulo = sc.nextLine();
        System.out.printf("Digite a descrissão do trabalho:");
        this.descrições = sc.nextLine();
        System.out.printf("Digite o valor total do trabalho:");
        this.notaTotal = sc.nextInt();
        System.out.printf("Digite o número correspondente ao professor que será o orientador:");
        readProfessorID();
        tControler = sc.nextInt();
        this.getNomeOrientador(tControler);
        System.out.printf(this.orientador.pessoa.nome);
        System.out.printf("\nDigite o número de integrantes:");
        this.numIntegrantes = sc.nextInt();
        readAlunoID();
        for(int i=0; i < this.numIntegrantes; i++){
            System.out.printf("Digite o número correspondente ao aluno de numero %d que será participante:", i);
            eControler = sc.nextInt();
            getNomeAluno(i, eControler);
        }
        this.showTrabalho();
        this.fileTrabalho();
    }
    public void showTrabalho(){
        System.out.printf("-----------------------------------\n");
        System.out.printf("Novo Traabalho:\n");
        System.out.printf("Titulo: %s\n", this.titulo);
        System.out.printf("Descrição: %s\n", this.descrições);
        System.out.printf("Orientador: %s\n", this.orientador.pessoa.nome);
        System.out.printf("Nota Total: %d\n", this.notaTotal);
        System.out.printf("Numero de Participantes: %d\n", this.numIntegrantes);
        System.out.printf("Participantes: ", this.numIntegrantes);
        for(int i = 0; i < this.numIntegrantes; i++){
          System.out.printf(this.participante[i].pessoa.nome + " ,");
        }
        System.out.printf(".\n");
    }


    /** Tabela csv Estudante
     * 0  ,1     , 2         ,3              , 4        , 5        , 6     , 7     , 8     ,...|
     * Id ,Titulo, Descrição ,NomeOrientador , NotaTotal, NotaFinal, Número, aluno1, aluno2,...|
     */
    public boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
    private void fileTrabalho(){
        try {
            String fileName = "lib/Trabalho.csv";
            boolean fileExists = fileExists(fileName);

            FileWriter writer = new FileWriter(fileName, true);
            String trabalhoData = String.format("%d, %s, %s, %s, %d, %d, %d", this.id, this.titulo, this.descrições, this.orientador.pessoa.nome, this.notaTotal, this.notaFinal, this.numIntegrantes);
            for(int i = 0; i < this.numIntegrantes; i++){
            trabalhoData = String.format(trabalhoData + ", " + this.participante[i].pessoa.nome);}
            trabalhoData = String.format(trabalhoData + "\n ");
            writer.write(trabalhoData);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao adicionar trabalho ao arquivo.");
            e.printStackTrace();
        }
    }
    public void readProfessorID() throws IOException {
        
        System.out.println("\n--------------------------------");
        System.out.println("Professsores Cadastrados:");

        try {
            String fileName = "lib/Professor.csv";
            FileReader arquivoReader = new FileReader(fileName);
            BufferedReader bufferedLeitura = new BufferedReader(arquivoReader);

            String linha;

            while ((linha = bufferedLeitura.readLine()) != null) {
                String[] dados = linha.split(",");
                String professor = dados[0];
                String idProfessor = dados[2];
                System.out.println(idProfessor + ". " + professor);

            }

            bufferedLeitura.close();
            arquivoReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("--------------------------------");
    }

    public String getNomeOrientador(int idOrientador) {
        try {
            FileReader arquivoReader = new FileReader("lib/Professor.csv");
            try (BufferedReader bufferedLeitura = new BufferedReader(arquivoReader)) {
                String linha;
                int idLinha = 1;

                while ((linha = bufferedLeitura.readLine()) != null) {
                    if (idLinha == idOrientador) {
                        // Se o ID da linha corresponder à equipe desejada, retorna o nome da equipe
                        this.orientador.pessoa.nome = linha.split(",")[0];
                        return linha.split(",")[0];
                    }
                    idLinha++;
                }

                bufferedLeitura.close();
            }

            arquivoReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de Prfessores: " + e.getMessage());
        }

        return null; // Retorna null se o ID da equipe não for encontrado
    }
    
    public void readAlunoID() throws IOException {
        int idEstudante = 1;
        System.out.println("\n--------------------------------");
        System.out.println("Estudantes Cadastrados:");

        try {
            String fileName = "lib/Estudante.csv";
            FileReader arquivoReader = new FileReader(fileName);
            BufferedReader bufferedLeitura = new BufferedReader(arquivoReader);

            String linha;

            while ((linha = bufferedLeitura.readLine()) != null) {
                String[] dados = linha.split(",");
                String aluno = dados[0];
                System.out.println(idEstudante + ". " + aluno);
                idEstudante++;
            }

            bufferedLeitura.close();
            arquivoReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("--------------------------------");
    }

    public String getNomeAluno(int i, int idAluno) {
        try {
            FileReader arquivoReader = new FileReader("lib/Estudante.csv");
            try (BufferedReader bufferedLeitura = new BufferedReader(arquivoReader)) {
                String linha;
                int idLinha = 1;

                while ((linha = bufferedLeitura.readLine()) != null) {
                    if (idLinha == idAluno) {
                        // Se o ID da linha corresponder à equipe desejada, retorna o nome da equipe
                        this.participante[i].pessoa.nome = linha.split(",")[0];
                        return linha.split(",")[0];
                    }
                    idLinha++;
                }

                bufferedLeitura.close();
            }

            arquivoReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de Alunos: " + e.getMessage());
        }

        return null; // Retorna null se o ID da equipe não for encontrado
    }
}
