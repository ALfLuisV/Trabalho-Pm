import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int controler;
        Scanner ler = new Scanner(System.in);
        while (true) {
               System.out.println("==============================================================");
               System.out.println("Bem vindo ao ConstruTech University Alpha");
               System.out.println("==============================================================");
               System.out.println("\nInsira um valor para executar uma das seguintes ações:");
               System.out.println("1.Cadastrar uma novo Aluno");
               System.out.println("2.Consultar Alunos");
               System.out.println("3.Cadastrar Professor");
               System.out.println("4.Consultar Professor");
               System.out.println("5.Novo Trabalho");
               System.out.println("9.Encerrar Programa");

               controler = ler.nextInt();
               switch (controler) {
                    case 1:
                        Estudante estudante = new Estudante(); // Cria uma instância da classe Client
                        estudante.cadastrarEstudante(ler);
                        break;
                    case 2:
                        Estudante.readEstudanteFile();
                        break;
                    case 3:
                        Professor professor = new Professor();
                        professor.cadastrarProfessor(ler);
                        break;
                    case 4:
                        Professor.readProfessorFile();;
                        break;
                    case 5:
                        Trabalho trabalho = new Trabalho();
                        trabalho.novoTrablho(ler);
                        break;   
                    case 9:
                         System.out.println("Programa Finalizado.");
                         System.exit(0); // Encerre o programa
                    default:
                         System.out.println("Opção inválida");
            }
        }
    }
}
