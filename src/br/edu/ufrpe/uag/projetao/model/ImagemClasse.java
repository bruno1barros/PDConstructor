package br.edu.ufrpe.uag.projetao.model;
// Generated 26/04/2016 23:17:23 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ufrpe.uag.projetao.annotations.Coluna;
import br.edu.ufrpe.uag.projetao.annotations.Tabela;
import br.edu.ufrpe.uag.projetao.interfaces.InterfaceEntity;

/**
 * ImagemClasse generated by hbm2java
 */
@Tabela
@Entity
@Table(name = "imagem_classe", schema = "public")
public class ImagemClasse implements java.io.Serializable, InterfaceEntity {

    @Coluna(colunaNome = "ID", colunaPosicao = 0)
    private int id;
    @Coluna(colunaNome = "Usuário", colunaPosicao = 1)
    private Usuario usuario;
    private byte[] objeto;
    private Set<AlocacaoImagemClasse> alocacaoImagemClasses = new HashSet<>(0);

    public ImagemClasse() {
    }

    public ImagemClasse(int id, Usuario usuario, byte[] objeto) {
	this.id = id;
	this.usuario = usuario;
	this.objeto = objeto;
    }

    public ImagemClasse(int id, Usuario usuario, byte[] objeto, Set<AlocacaoImagemClasse> alocacaoImagemClasses) {
	this.id = id;
	this.usuario = usuario;
	this.objeto = objeto;
	this.alocacaoImagemClasses = alocacaoImagemClasses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor", nullable = false)
    public Usuario getUsuario() {
	return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    @Column(name = "objeto", nullable = false)
    public byte[] getObjeto() {
	return this.objeto;
    }

    public void setObjeto(byte[] objeto) {
	this.objeto = objeto;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "imagemClasse")
    public Set<AlocacaoImagemClasse> getAlocacaoImagemClasses() {
	return this.alocacaoImagemClasses;
    }

    public void setAlocacaoImagemClasses(Set<AlocacaoImagemClasse> alocacaoImagemClasses) {
	this.alocacaoImagemClasses = alocacaoImagemClasses;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 79 * hash + this.id;
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final ImagemClasse other = (ImagemClasse) obj;
	return this.id == other.id;
    }

    @Override
    public String toString() {
	return "ImagemClasse{" + "id=" + id + ", usuario=" + usuario + '}';
    }

}
