package br.edu.ufrpe.uag.projetao.model;
// Generated 26/04/2016 23:17:23 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ufrpe.uag.projetao.annotations.Coluna;
import br.edu.ufrpe.uag.projetao.annotations.Tabela;
import br.edu.ufrpe.uag.projetao.interfaces.InterfaceEntity;

/**
 * LiberacaoBaseImagemClasse generated by hbm2java
 */
@Tabela
@Entity
@Table(name = "liberacao_base_imagem_classe", schema = "public")
public class LiberacaoBaseImagemClasse implements java.io.Serializable, InterfaceEntity {

    @Coluna(colunaNome = "Base de Imagem", colunaPosicao = 0)
    private BaseImagemClasse baseImagemClasse;
    @Coluna(colunaNome = "Escravo", colunaPosicao = 1)
    private Usuario usuarioByEscravo;
    @Coluna(colunaNome = "Supervisor", colunaPosicao = 2)
    private Usuario usuarioBySupervisor;
    private char status;

    public LiberacaoBaseImagemClasse() {
    }

    public LiberacaoBaseImagemClasse(BaseImagemClasse baseImagemClasse, Usuario usuarioByEscravo,
	    Usuario usuarioBySupervisor, char status) {
	this.baseImagemClasse = baseImagemClasse;
	this.usuarioByEscravo = usuarioByEscravo;
	this.usuarioBySupervisor = usuarioBySupervisor;
	this.status = status;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_imagem", nullable = false, insertable = false, updatable = false)
    public BaseImagemClasse getBaseImagemClasse() {
	return this.baseImagemClasse;
    }

    public void setBaseImagemClasse(BaseImagemClasse baseImagemClasse) {
	this.baseImagemClasse = baseImagemClasse;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escravo", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByEscravo() {
	return this.usuarioByEscravo;
    }

    public void setUsuarioByEscravo(Usuario usuarioByEscravo) {
	this.usuarioByEscravo = usuarioByEscravo;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioBySupervisor() {
	return this.usuarioBySupervisor;
    }

    public void setUsuarioBySupervisor(Usuario usuarioBySupervisor) {
	this.usuarioBySupervisor = usuarioBySupervisor;
    }

    @Column(name = "status", nullable = false, length = 1)
    public char getStatus() {
	return this.status;
    }

    public void setStatus(char status) {
	this.status = status;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((baseImagemClasse == null) ? 0 : baseImagemClasse.hashCode());
	result = prime * result + status;
	result = prime * result + ((usuarioByEscravo == null) ? 0 : usuarioByEscravo.hashCode());
	result = prime * result + ((usuarioBySupervisor == null) ? 0 : usuarioBySupervisor.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	LiberacaoBaseImagemClasse other = (LiberacaoBaseImagemClasse) obj;
	if (baseImagemClasse == null) {
	    if (other.baseImagemClasse != null)
		return false;
	} else if (!baseImagemClasse.equals(other.baseImagemClasse))
	    return false;
	if (status != other.status)
	    return false;
	if (usuarioByEscravo == null) {
	    if (other.usuarioByEscravo != null)
		return false;
	} else if (!usuarioByEscravo.equals(other.usuarioByEscravo))
	    return false;
	if (usuarioBySupervisor == null) {
	    if (other.usuarioBySupervisor != null)
		return false;
	} else if (!usuarioBySupervisor.equals(other.usuarioBySupervisor))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "LiberacaoBaseImagemClasse{" + "baseImagemClasse=" + baseImagemClasse + ", usuarioByEscravo="
		+ usuarioByEscravo + ", usuarioBySupervisor=" + usuarioBySupervisor + ", status=" + status + '}';
    }

}
