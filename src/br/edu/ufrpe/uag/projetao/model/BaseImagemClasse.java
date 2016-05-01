package br.edu.ufrpe.uag.projetao.model;
// Generated 26/04/2016 23:17:23 by Hibernate Tools 4.3.1

import br.edu.ufrpe.uag.projetao.annotations.Coluna;
import br.edu.ufrpe.uag.projetao.annotations.Tabela;
import br.edu.ufrpe.uag.projetao.interfaces.InterfaceEntity;
import java.util.HashSet;
import java.util.Objects;
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

/**
 * BaseImagemClasse generated by hbm2java
 */
@Tabela
@Entity
@Table(name = "base_imagem_classe", schema = "public"
)
public class BaseImagemClasse implements java.io.Serializable, InterfaceEntity {

    private int id;
    private Usuario usuario;
    @Coluna(colunaNome="Título",colunaPosicao=0)
    private String titulo;
    @Coluna(colunaNome="Descrição",colunaPosicao=1)
    private String descricao;
    private Set<LiberacaoBaseImagemClasse> liberacaoBaseImagemClasses = new HashSet<>(0);
    private Set<AlocacaoImagemClasse> alocacaoImagemClasses = new HashSet<>(0);

    public BaseImagemClasse() {
    }

    public BaseImagemClasse(int id, Usuario usuario, String titulo, String descricao) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public BaseImagemClasse(int id, Usuario usuario, String titulo, String descricao, Set<LiberacaoBaseImagemClasse> liberacaoBaseImagemClasses, Set<AlocacaoImagemClasse> alocacaoImagemClasses) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descricao = descricao;
        this.liberacaoBaseImagemClasses = liberacaoBaseImagemClasses;
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

    @Column(name = "titulo", nullable = false)
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "descricao", nullable = false)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "baseImagemClasse")
    public Set<LiberacaoBaseImagemClasse> getLiberacaoBaseImagemClasses() {
        return this.liberacaoBaseImagemClasses;
    }

    public void setLiberacaoBaseImagemClasses(Set<LiberacaoBaseImagemClasse> liberacaoBaseImagemClasses) {
        this.liberacaoBaseImagemClasses = liberacaoBaseImagemClasses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "baseImagemClasse")
    public Set<AlocacaoImagemClasse> getAlocacaoImagemClasses() {
        return this.alocacaoImagemClasses;
    }

    public void setAlocacaoImagemClasses(Set<AlocacaoImagemClasse> alocacaoImagemClasses) {
        this.alocacaoImagemClasses = alocacaoImagemClasses;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.descricao);
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
        final BaseImagemClasse other = (BaseImagemClasse) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "BaseImagemClasse{" + "id=" + id + ", usuario=" + usuario + ", titulo=" + titulo + ", descricao=" + descricao + '}';
    }

}
