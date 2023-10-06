import java.util.Scanner;

public class Minicurso {
    String data;
    String horaInicio;
    String horaFim;
    Profissional ministrante;
    Pessoa participantes[];
    Sala local;

    public Minicurso(String data, String horaI, String horaF, Profissional ministrante, Sala local) {
        this.data = data;
        this.horaInicio = horaI;
        this.horaFim = horaF;
        this.ministrante = ministrante;
        this.local = local;
    }

    public Minicurso(){
        this.data = null;
        this.horaInicio = null;
        this.horaFim = null;
        this.ministrante = null;
        this.participantes = null;
        this.local = null;
    }


    public void CadastrarMinicurso(){
        Scanner ler = new Scanner(System.in);
String data;
String horaI, horaF;
Profissional ministrante;
Pessoa participantes[];
Sala local;

System.out.println("Insira a data da Sessão Técnica(DD/MM/AAAA):");
data = ler.nextLine();
System.out.println("Insira o horário de inicio da Sessão Técnica(DD/MM/AAAA):");
horaI = ler.nextLine();
System.out.println("Insira o horário de término da Sessão Técnica(DD/MM/AAAA):");
horaF = ler.nextLine();
}
}