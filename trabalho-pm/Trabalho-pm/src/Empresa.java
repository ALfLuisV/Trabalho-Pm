import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Empresa extends Instituicao {
    String ramo;
    int numProfissionais;

    public Empresa(String cnpj, String nome, String ramo, int prof) {
        super(cnpj, nome);
        this.ramo = ramo;
        this.numProfissionais = prof;
    }

    public Empresa(){
        super("","");
        this.ramo = "";
        this.numProfissionais = 0;
    }



public void cadastrarEmp(ArrayList<Empresa> empre1){

Scanner ler = new Scanner(System.in);
String cnpj, nome, ramo;
int profs;

System.out.println("Insira o cnpj da Empresa:");
cnpj = ler.nextLine();
System.out.println("Insira o nome da Empresa:");
nome = ler.nextLine();
System.out.println("Insira o ramo da Empresa:");
ramo = ler.nextLine();
System.out.println("Insira o numero de profissionais participantes da Empresa:");
profs = ler.nextInt();
Empresa emp1 = new Empresa(cnpj, nome, ramo, profs);
empre1.add(emp1);
// ler.close();
}


public void showEmp(ArrayList<Empresa> empre1){
    System.out.println("\n\n-------------Empresas Cadastradas:------------------");
    for (Empresa emp : empre1) {
        System.out.println("\n\n-------------------------------");
        System.out.println("CNPJ: " + emp.cnpjInst);
        System.out.println("Nome: " + emp.nomeInst);
        System.out.println("Ramo da empresa: " + emp.ramo);
        System.out.println("Numero de profissionais: " + emp.numProfissionais);
        System.out.println("-------------------------------");
}
}




























//  public boolean fileExists(String fileName) {
//         File file = new File(fileName);
//         return file.exists();
// }

// public void fileEmpresa(){
//                 try {
//             String fileName = "Empresas.csv";
//             boolean fileExists = fileExists(fileName);

//             FileWriter writer = new FileWriter(fileName, true);
//             String empData = String.format("%s, %s, %s, %d\n", this.cnpjInst, this.nomeInst, this.ramo, this.numProfissionais);

//             writer.write(empData);
//             writer.close();

//         } catch (IOException e) {
//             System.err.println("Erro ao adicionar empresa ao arquivo.");
//             e.printStackTrace();
//         }
// }


















    // GETTERS/SETTERS
    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getRamo() {
        return this.ramo;
    }

    public void setProfissionais(int prof) {
        this.numProfissionais = prof;
    }

    public int getProfissionais() {
        return this.numProfissionais;
    }







}
