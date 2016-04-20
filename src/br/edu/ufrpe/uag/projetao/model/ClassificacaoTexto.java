package br.edu.ufrpe.uag.projetao.model;
// Generated 20/04/2016 11:43:59 by Hibernate Tools 4.3.1

import br.edu.ufrpe.uag.projetao.interfaces.InterfaceEntity;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ClassificacaoTexto generated by hbm2java
 */
@Entity
@Table(name = "classificacao_texto", schema = "public"
)
public class ClassificacaoTexto implements java.io.Serializable, InterfaceEntity {

    private ClassificacaoTextoId id;
    private AlocacaoTexto alocacaoTexto;
    private EscolhaClasseTexto escolhaClasseTexto;
    private Usuario usuario;

    public ClassificacaoTexto() {
    }

    public ClassificacaoTexto(ClassificacaoTextoId id, AlocacaoTexto alocacaoTexto, EscolhaClasseTexto escolhaClasseTexto, Usuario usuario) {
        this.id = id;
        this.alocacaoTexto = alocacaoTexto;
        this.escolhaClasseTexto = escolhaClasseTexto;
        this.usuario = usuario;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "escravo", column = @Column(name = "escravo", nullable = false)),
        @AttributeOverride(name = "alocacaoTexto", column = @Column(name = "alocacao_texto", nullable = false)),
        @AttributeOverride(name = "escolhaTexto", column = @Column(name = "escolha_texto", nullable = false))})
    public ClassificacaoTextoId getId() {
        return this.id;
    }

    public void setId(ClassificacaoTextoId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alocacao_texto", nullable = false, insertable = false, updatable = false)
    public AlocacaoTexto getAlocacaoTexto() {
        return this.alocacaoTexto;
    }

    public void setAlocacaoTexto(AlocacaoTexto alocacaoTexto) {
        this.alocacaoTexto = alocacaoTexto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escolha_texto", nullable = false, insertable = false, updatable = false)
    public EscolhaClasseTexto getEscolhaClasseTexto() {
        return this.escolhaClasseTexto;
    }

    public void setEscolhaClasseTexto(EscolhaClasseTexto escolhaClasseTexto) {
        this.escolhaClasseTexto = escolhaClasseTexto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escravo", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final ClassificacaoTexto other = (ClassificacaoTexto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ClassificacaoTexto{" + "alocacaoTexto=" + alocacaoTexto + ", escolhaClasseTexto=" + escolhaClasseTexto + ", usuario=" + usuario + '}';
    }

}