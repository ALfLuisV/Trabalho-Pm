import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int controler;
        Scanner ler = new Scanner(System.in);
        ArrayList<Universidade> ArrayUni = new ArrayList<>();
        ArrayList<Empresa> ArrayEmp = new ArrayList<>();
        ArrayList<Professor> ArrayProf = new ArrayList<>();
        ArrayList<Estudante> ArrayEstu = new ArrayList<>();
        while (true) {
            System.out.println("==============================================================");
            System.out.println("Bem vindo ao ConstruTech University Alpha");
            System.out.println("==============================================================");
            System.out.println("\nInsira um valor para executar uma das seguintes ações:");
            System.out.println("1.Cadastrar uma novo Aluno");
            System.out.println("2.Consultar Alunos");
            System.out.println("3.Cadastrar Professor");
            System.out.println("4.Consultar Professor");
            System.out.println("5.Cadastrar Universidade");
            System.out.println("6.Cadastrar Empresa");
            System.out.println("9.Encerrar Programa");
            controler = ler.nextInt();
            switch (controler) {
                case 1:
                    Estudante estudante = new Estudante(); // Cria uma instância da classe Client
                    estudante.cadastrarEstudante(ler);
                    break;
                case 2:
                    Estudante.readEstudanteFile(ArrayEstu);
                    break;
                case 3:
                    Professor professor = new Professor();
                    professor.cadastrarProfessor(ler);
                    break;
                case 4:
                    Professor.readProfessorFile(ArrayProf);
                    break;
                case 5:
                    Universidade uni1 = new Universidade();
                    uni1.cadastrarUni(ArrayUni);
                    uni1.showUni(ArrayUni);
                    break;
                case 6:
                    Empresa emp1 = new Empresa();
                    emp1.cadastrarEmp(ArrayEmp);
                    emp1.showEmp(ArrayEmp);
                    break;
                case 9:
                    System.out.println("Programa Finalizado.");
                    System.exit(0); // Encerre o programa
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
