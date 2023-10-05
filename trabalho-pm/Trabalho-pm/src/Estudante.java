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
    }

    private int getMatricula(Scanner sc){
        matricula = sc.nextInt();
        if (matricula > 99999999) {
            System.out.printf("A matricula digitada é invalida, digite outra");
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
        System.out.printf("Nota Final: %s\n", this.notaFinal);
        System.out.printf("Está Aprovado: %s\n", this.aprovado);
    }
}
