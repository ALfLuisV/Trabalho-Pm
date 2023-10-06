
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class SessaoTecnica {
    String data;
    String horaInicio;
    String horaFim;
    Professor palestrante;
    Pessoa participantes[];
    Sala local;

    public SessaoTecnica(String data, String horaI, String horaF, Professor palestrante, Sala local) {
        this.data = data;
        this.horaInicio = horaI;
        this.horaFim = horaF;
        this.palestrante = palestrante;
        this.local = local;
    }

    public SessaoTecnica(){
        this.data = null;
        this.horaInicio = null;
        this.horaFim = null;
        this.palestrante = null;
        this.participantes = null;
        this.local = null;
    }


    public void CadastrarSessãotecnica(){
        Scanner ler = new Scanner(System.in);
String data;
String horaI, horaF;
Professor palestrante;
Pessoa participantes[];
Sala local;

System.out.println("Insira a data da Sessão Técnica(DD/MM/AAAA):");
data = ler.nextLine();
System.out.println("Insira o horário de inicio da Sessão Técnica(DD/MM/AAAA):");
horaI = ler.nextLine();
System.out.println("Insira o horário de término da Sessão Técnica(DD/MM/AAAA):");
horaF = ler.nextLine();



 }






















public boolean fileExists(String fileName) {
    File file = new File(fileName);
    return file.exists();
}













    public void fileSessao(){
                try {
            String fileName = "S/T_Agendadas.csv";
            boolean fileExists = fileExists(fileName);

            FileWriter writer = new FileWriter(fileName, true);
            String uniData = String.format("%s, %s, %d, %d\n", this.cnpjInst, this.nomeInst, this.numProf, this.numAlunos);

            writer.write(uniData);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao adicionar universidade ao arquivo.");
            e.printStackTrace();
        }
}





}
