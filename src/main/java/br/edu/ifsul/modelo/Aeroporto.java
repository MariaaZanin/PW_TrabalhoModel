package br.edu.ifsul.modelo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "aeroporto")
public class Aeroporto implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_aeroporto", sequenceName = "seq_aeroporto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aeroporto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome nao pode ser em branco")
    @Length(max = 40, message = "O nome nao pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @NotNull(message = "O campo operacao noturna deve ser informado")
    @Column(name = "operacaoNoturna", nullable = false)
    private Boolean operacaoNoturna;
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;

    public Aeroporto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getOperacaoNoturna() {
        return operacaoNoturna;
    }

    public void setOperacaoNoturna(Boolean operacaoNoturna) {
        this.operacaoNoturna = operacaoNoturna;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return Objects.equals(id, aeroporto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
