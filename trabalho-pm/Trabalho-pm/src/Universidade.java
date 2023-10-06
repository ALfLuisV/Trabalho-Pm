import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Universidade extends Instituicao {
    int numProf;
    int numAlunos;

    public Universidade(String cnpj, String nome, int profs, int alunos) {
        super(cnpj, nome);
        this.numProf = profs;
        this.numAlunos = alunos;
    }

    public Universidade(){
        super("","");
        this.numProf = 0;
        this.numAlunos = 0;
    }



public void cadastrarUni(ArrayList<Universidade> arrayUni){
    
Scanner ler = new Scanner(System.in);
String cnpj, nome;
int alunos, profs;

System.out.printf("Insira o cnpj da Universidade:");
cnpj = ler.nextLine();
System.out.printf("Insira o nome da Universidade:");
nome = ler.nextLine();
System.out.printf("Insira o numero de professores participantes da Universidade:");
profs = ler.nextInt();
System.out.printf("Insira o numero de alunos participantes da Universidade:");
alunos = ler.nextInt();
Universidade uni1 = new Universidade(cnpj, nome, profs, alunos);
arrayUni.add(uni1);
}



public void showUni(ArrayList<Universidade> arrayUni){
if(arrayUni.size() == 0){
System.out.printf("Nenhuma universidade cadastrada");
}else{
    System.out.println("\n\n-------------Universidades Cadastradas:------------------");
    for (Universidade uni : arrayUni) {
        System.out.println("\n\n-------------------------------");
        System.out.println("CNPJ: " + uni.cnpjInst);
        System.out.println("Nome: " + uni.nomeInst);
        System.out.println("Numero de professores: " + uni.numProf);
        System.out.println("Numero de alunos: " + uni.numAlunos);
        System.out.println("-------------------------------");
}
}
}

//  public boolean fileExists(String fileName) {
//         File file = new File(fileName);
//         return file.exists();
// }

// public void fileUni(){
//                 try {
//             String fileName = "Universidade.csv";
//             boolean fileExists = fileExists(fileName);

//             FileWriter writer = new FileWriter(fileName, true);
//             String uniData = String.format("%s, %s, %d, %d\n", this.cnpjInst, this.nomeInst, this.numProf, this.numAlunos);

//             writer.write(uniData);
//             writer.close();

//         } catch (IOException e) {
//             System.err.println("Erro ao adicionar universidade ao arquivo.");
//             e.printStackTrace();
//         }
// }
























   
    // GETTERS/SETTERS
    public void setAlunos(int alunos) {
        this.numAlunos = alunos;
    }

    public int getAlunos() {
        return this.numAlunos;
    }

    public void setProfs(int Profs) {
        this.numProf = Profs;
    }

    public int getProfs() {
        return this.numProf;
    }

}
