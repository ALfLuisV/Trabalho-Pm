public class Empresa extends Instituicao {
    String ramo;
    int numProfissionais;

    public Empresa(String cnpj, String nome, String email, String ramo, int prof) {
        super(cnpj, nome, email);
        this.ramo = ramo;
        this.numProfissionais = prof;
        // TODO Auto-generated constructor stub
    }


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
