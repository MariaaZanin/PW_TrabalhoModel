package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "voo")
public class Voo implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_aeroporto", sequenceName = "seq_aeroporto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aeroporto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descricao nao pode ser em branco")
//    @Length(max = 40, message = "A descricao nao pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;
    @NotNull(message = "O tempo estimado deve ser informado")
    @Column(name = "tempoEstimado", nullable = false, columnDefinition = "decimal(12,2)")
    private Double tempoEstimado;
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @NotBlank(message = "A periodicidade nao pode ser em branco")
    @Length(max = 40, message = "A periodicidade nao pode ter mais que {max} caracteres")
    @Column(name = "periodicidade", length = 40, nullable = false)
    private String periodicidade;
    
    @ManyToMany
//    @JoinTable(name = "escalas",
//            joinColumns =
//                @JoinColumn(name = "voo", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns =
//                @JoinColumn(name = "aeroporto", referencedColumnName = "id", nullable = false))
    private Set<Aeroporto> aeroporto = new HashSet<>();
    
    @OneToMany(mappedBy = "voo", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VooAgendado> voo_agendado = new ArrayList<>();
    
    public Voo(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public Set<Aeroporto> getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(Set<Aeroporto> aeroporto) {
        this.aeroporto = aeroporto;
    }

    public List<VooAgendado> getVoo_agendado() {
        return voo_agendado;
    }

    public void setVoo_agendado(List<VooAgendado> voo_agendado) {
        this.voo_agendado = voo_agendado;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voo voo = (Voo) o;
        return Objects.equals(id, voo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    public void adicionarVooAgendado(VooAgendado obj) {
        obj.setVoo(this);
        this.getVoo_agendado().add(obj);
    }

    public void removerVooAgendado(int index) {
        this.voo_agendado.remove(index);
    }
}
