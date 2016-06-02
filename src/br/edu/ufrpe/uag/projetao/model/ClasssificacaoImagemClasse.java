package br.edu.ufrpe.uag.projetao.model;
// Generated 26/04/2016 23:17:23 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ufrpe.uag.projetao.annotations.Coluna;
import br.edu.ufrpe.uag.projetao.annotations.Tabela;
import br.edu.ufrpe.uag.projetao.interfaces.InterfaceEntity;

/**
 * ClasssificacaoImagemClasse generated by hbm2java
 */
@Tabela
@Entity
@Table(name = "classsificacao_imagem_classe", schema = "public")
public class ClasssificacaoImagemClasse implements java.io.Serializable, InterfaceEntity {

    @Coluna(colunaNome = "Alocação de Imagem", colunaPosicao = 0)
    private AlocacaoImagemClasse alocacaoImagemClasse;
    @Coluna(colunaNome = "Classe", colunaPosicao = 1)
    private EscolhaImagemClasse escolhaImagemClasse;
    @Coluna(colunaNome = "Escravo", colunaPosicao = 2)
    private Usuario usuario;
    private int id;

    public ClasssificacaoImagemClasse() {
    }

    public ClasssificacaoImagemClasse(AlocacaoImagemClasse alocacaoImagemClasse,
	    EscolhaImagemClasse escolhaImagemClasse, Usuario usuario) {

	this.alocacaoImagemClasse = alocacaoImagemClasse;
	this.escolhaImagemClasse = escolhaImagemClasse;
	this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alocacao_imagem_classe")
    public AlocacaoImagemClasse getAlocacaoImagemClasse() {
	return this.alocacaoImagemClasse;
    }

    public void setAlocacaoImagemClasse(AlocacaoImagemClasse alocacaoImagemClasse) {
	this.alocacaoImagemClasse = alocacaoImagemClasse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escolha_imagem_classe")
    public EscolhaImagemClasse getEscolhaImagemClasse() {
	return this.escolhaImagemClasse;
    }

    public void setEscolhaImagemClasse(EscolhaImagemClasse escolhaImagemClasse) {
	this.escolhaImagemClasse = escolhaImagemClasse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escravo")
    public Usuario getUsuario() {
	return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((alocacaoImagemClasse == null) ? 0 : alocacaoImagemClasse.hashCode());
	result = prime * result + ((escolhaImagemClasse == null) ? 0 : escolhaImagemClasse.hashCode());
	result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof ClasssificacaoImagemClasse)) {
	    return false;
	}
	ClasssificacaoImagemClasse other = (ClasssificacaoImagemClasse) obj;
	if (alocacaoImagemClasse == null) {
	    if (other.alocacaoImagemClasse != null) {
		return false;
	    }
	} else if (alocacaoImagemClasse.getId() != other.alocacaoImagemClasse.getId()) {
	    return false;
	}
	if (escolhaImagemClasse == null) {
	    if (other.escolhaImagemClasse != null) {
		return false;
	    }
	} else if (!escolhaImagemClasse.getDescricao().equals(other.escolhaImagemClasse.getDescricao())) {
	    return false;
	}
	if (usuario == null) {
	    if (other.usuario != null) {
		return false;
	    }
	} else if (usuario.getId() != other.usuario.getId()) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return alocacaoImagemClasse.getId() + "." + escolhaImagemClasse.getId() + "." + usuario.getId();
    }

}
