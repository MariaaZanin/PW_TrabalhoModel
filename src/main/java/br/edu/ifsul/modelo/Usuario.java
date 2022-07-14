package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @NotBlank(message = "O nome de usuario deve ser informado")
    @Length(max = 20, message = "O nome do usuario nao pode ser mais que {max} caracteres")
    @Column(name="nome_usuario", length = 20, nullable = false)
    private String nomdUsuaurio;
    @NotBlank(message = "A senha deve ser informado")
    @Length(max = 20, message = "A senha nao pode ser mais que {max} caracteres")
    @Column(name="senha", length = 20, nullable = false)
    private String senha;
    
    @ManyToMany
    @JoinTable(name = "permissoes",
            joinColumns =
                @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false),
            inverseJoinColumns =
                @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();

    public String getNomdUsuaurio() {
        return nomdUsuaurio;
    }

    public void setNomdUsuaurio(String nomdUsuaurio) {
        this.nomdUsuaurio = nomdUsuaurio;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }  
}