package Classes;
public class Piloto extends Pessoa{
private String breve;
private Aeronave aero;

    public String getBreve() {
    return breve;
}
public void setBreve(String breve) {
    this.breve = breve;
}

public Aeronave getAero() {
    return aero;
}
public void setAero(Aeronave aero) {
    this.aero = aero;
}


    @Override
    public String toString() {
        String dados="";
        dados+="Nome do Piloto: "+nome;
        dados+="  CPF: "+CPF;
        dados+="  Breve: "+breve;
        if(aero!=null){
            dados+="  Aeronave:"+aero;
        }
        return dados;
    }
    
}
