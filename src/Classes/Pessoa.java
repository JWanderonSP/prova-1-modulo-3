package Classes;
public class Pessoa {
    protected String nome;
    protected String CPF;
    private Aeronave aero;
    public Aeronave getAero() {
        return aero;
    }
    public void setAero(Aeronave aero) {
        this.aero = aero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }

    
}
