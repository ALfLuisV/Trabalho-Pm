public abstract class Instituicao {
    String cnpjInst;
    String nomeInst;


public Instituicao(String cnpj, String nome){
this.cnpjInst = cnpj;
this.nomeInst = nome;
}


// GETTERS/SETTERS
public void setCnpj(String cnpj) {
    this.cnpjInst = cnpj;
}

public String getCnpj() {
    return this.cnpjInst;
}

public void setNome(String nome) {
    this.nomeInst = nome;
}

public String getNome() {
    return this.nomeInst;
}







}
