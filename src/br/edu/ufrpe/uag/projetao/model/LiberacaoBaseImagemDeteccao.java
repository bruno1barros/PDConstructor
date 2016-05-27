package br.edu.ufrpe.uag.projetao.model;
// Generated 27/05/2016 19:57:54 by Hibernate Tools 4.3.1

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ufrpe.uag.projetao.interfaces.InterfaceEntity;

/**
 * LiberacaoBaseImagemDeteccao generated by hbm2java
 */
@Entity
@Table(name = "liberacao_base_imagem_deteccao", schema = "public")
public class LiberacaoBaseImagemDeteccao implements InterfaceEntity, Serializable {

    private BaseImagemDeteccao baseImagemDeteccao;
    private Usuario usuarioBySupervisor;
    private Usuario usuarioByEscravo;
    private char status;

    public LiberacaoBaseImagemDeteccao() {
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_imagem_deteccao", nullable = false, insertable = false, updatable = false)
    public BaseImagemDeteccao getBaseImagemDeteccao() {
	return this.baseImagemDeteccao;
    }

    public void setBaseImagemDeteccao(BaseImagemDeteccao baseImagemDeteccao) {
	this.baseImagemDeteccao = baseImagemDeteccao;
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

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escravo", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByEscravo() {
	return this.usuarioByEscravo;
    }

    public void setUsuarioByEscravo(Usuario usuarioByEscravo) {
	this.usuarioByEscravo = usuarioByEscravo;
    }

    @Column(name = "status", nullable = false, length = 1)
    public char getStatus() {
	return this.status;
    }

    public void setStatus(char status) {
	this.status = status;
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
	result = prime * result + ((baseImagemDeteccao == null) ? 0 : baseImagemDeteccao.hashCode());
	result = prime * result + status;
	result = prime * result + ((usuarioByEscravo == null) ? 0 : usuarioByEscravo.hashCode());
	result = prime * result + ((usuarioBySupervisor == null) ? 0 : usuarioBySupervisor.hashCode());
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
	if (!(obj instanceof LiberacaoBaseImagemDeteccao)) {
	    return false;
	}
	LiberacaoBaseImagemDeteccao other = (LiberacaoBaseImagemDeteccao) obj;
	if (baseImagemDeteccao == null) {
	    if (other.baseImagemDeteccao != null) {
		return false;
	    }
	} else if (!baseImagemDeteccao.equals(other.baseImagemDeteccao)) {
	    return false;
	}
	if (status != other.status) {
	    return false;
	}
	if (usuarioByEscravo == null) {
	    if (other.usuarioByEscravo != null) {
		return false;
	    }
	} else if (!usuarioByEscravo.equals(other.usuarioByEscravo)) {
	    return false;
	}
	if (usuarioBySupervisor == null) {
	    if (other.usuarioBySupervisor != null) {
		return false;
	    }
	} else if (!usuarioBySupervisor.equals(other.usuarioBySupervisor)) {
	    return false;
	}
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "LiberacaoBaseImagemDeteccao [baseImagemDeteccao=" + baseImagemDeteccao + ", usuarioBySupervisor="
		+ usuarioBySupervisor + ", usuarioByEscravo=" + usuarioByEscravo + ", status=" + status + "]";
    }

}
