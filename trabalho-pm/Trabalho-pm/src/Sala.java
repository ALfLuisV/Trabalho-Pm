// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
import java.util.Scanner;

public class Sala {
   int codigo;
   int idPredio;
   int numSala;
   boolean minicurso; 
   boolean sessaoTecnica;

   public Sala(int codigo, int idpredio, int numsala, boolean minicurso, boolean sessaotecnica) {
this.codigo = codigo;
this.idPredio = idpredio;
this.numSala = numsala;
this.minicurso = minicurso;
this.sessaoTecnica = sessaotecnica;
}


public Sala(){
this.codigo = 0;
this.idPredio = 0;
this.numSala = 0;
this.minicurso = false;
this.sessaoTecnica = false;
}


public Sala cadastrarSala(){
Scanner ler = new Scanner(System.in);
int codigo, idpredio, numsala, x;
boolean minicurso = false, sessaoTecnica = false;

System.out.println("Insira o codigo da sala:");
codigo = ler.nextInt();
System.out.println("Insira o codigo do predio da sala:");
idpredio = ler.nextInt();
System.out.println("Insira o numero da sala:");
numsala = ler.nextInt();
System.out.println("Deseja cadastrar uma Sessão Tecnica ou um Minicurso? (Digite 0 para Sessão Tecnica ou 1 para Minicurso)");
x = ler.nextInt();

if(x == 0){
    sessaoTecnica = true;
    minicurso = false;
} else if(x == 1){
    sessaoTecnica = false;
    minicurso = true;
} else{
   System.out.println("Codigo inválido, reinicie o sistema!!"); 
}
ler.close();

Sala sala1 = new Sala(codigo, idpredio, numsala, minicurso, sessaoTecnica);
return sala1;
}










































//GET/SET
public void setCodigo(int codigo) {
    this.codigo = codigo;
}

public int getCodigo() {
    return this.codigo;
}

public void setPredio(int predio) {
    this.idPredio = predio;
}

public int getPredio() {
    return this.idPredio;
}

public void setSala(int sala) {
    this.numSala = sala;
}

public int getSala() {
    return this.numSala;
}

public void setMinicurso() {
    this.minicurso = true;
    this.sessaoTecnica = false;
}

public boolean getMinicurso() {
    return this.minicurso;
}

public void setSessaotecnica() {
    this.minicurso = false;
    this.sessaoTecnica = true;
}

public boolean getSessaotecnica() {
    return this.sessaoTecnica;
}










}
