package br.edu.ufrpe.uag.projetao.model;
// Generated 26/04/2016 23:17:23 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClasssificacaoImagemClasseId generated by hbm2java
 */
@Embeddable
public class ClasssificacaoImagemClasseId implements java.io.Serializable {

    private int escravo;
    private int alocacaoImagemClasse;
    private int escolhaImagemClasse;

    public ClasssificacaoImagemClasseId() {
    }

    public ClasssificacaoImagemClasseId(int escravo, int alocacaoImagemClasse, int escolhaImagemClasse) {
        this.escravo = escravo;
        this.alocacaoImagemClasse = alocacaoImagemClasse;
        this.escolhaImagemClasse = escolhaImagemClasse;
    }

    @Column(name = "escravo", nullable = false)
    public int getEscravo() {
        return this.escravo;
    }

    public void setEscravo(int escravo) {
        this.escravo = escravo;
    }

    @Column(name = "alocacao_imagem_classe", nullable = false)
    public int getAlocacaoImagemClasse() {
        return this.alocacaoImagemClasse;
    }

    public void setAlocacaoImagemClasse(int alocacaoImagemClasse) {
        this.alocacaoImagemClasse = alocacaoImagemClasse;
    }

    @Column(name = "escolha_imagem_classe", nullable = false)
    public int getEscolhaImagemClasse() {
        return this.escolhaImagemClasse;
    }

    public void setEscolhaImagemClasse(int escolhaImagemClasse) {
        this.escolhaImagemClasse = escolhaImagemClasse;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof ClasssificacaoImagemClasseId)) {
            return false;
        }
        ClasssificacaoImagemClasseId castOther = (ClasssificacaoImagemClasseId) other;

        return (this.getEscravo() == castOther.getEscravo())
                && (this.getAlocacaoImagemClasse() == castOther.getAlocacaoImagemClasse())
                && (this.getEscolhaImagemClasse() == castOther.getEscolhaImagemClasse());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getEscravo();
        result = 37 * result + this.getAlocacaoImagemClasse();
        result = 37 * result + this.getEscolhaImagemClasse();
        return result;
    }

}