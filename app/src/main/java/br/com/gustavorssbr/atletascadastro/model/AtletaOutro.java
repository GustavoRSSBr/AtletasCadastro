package br.com.gustavorssbr.atletascadastro.model;

public class AtletaOutro extends Atleta {
    private String academia;
    private int segundosRecord;

    public AtletaOutro(String nome, String dataNasc, String bairro, String academia, int segundosRecord) {
        super(nome, dataNasc, bairro);
        this.academia = academia;
        this.segundosRecord = segundosRecord;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public int getSegundosRecord() {
        return segundosRecord;
    }

    public void setSegundosRecord(int segundosRecord) {
        this.segundosRecord = segundosRecord;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "academia='" + academia + '\'' +
                        ", segundosRecord=" + segundosRecord +
                        '}';
    }
}
