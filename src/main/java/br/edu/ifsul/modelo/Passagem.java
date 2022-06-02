package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "passagem")
public class Passagem implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_passagem", sequenceName = "seq_passagem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_passagem", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da compra deve ser informado")
    @Column(name = "dataCompra", nullable = false)
    private Calendar dataCompra;
    @NotNull(message = "A bagagem deve ser informado")
    @Column(name = "bagagem", nullable = false)
    private Integer bagagem;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    @NotNull(message = "A classe deve ser informada")
    @ManyToOne
    @JoinColumn(name = "classe_id", referencedColumnName = "id", nullable = false)
    private Classe classe;
    
    @NotNull(message = "O voo agendado deve ser informado")
    @ManyToOne
    @JoinColumn(name = "voo_agendado_id", referencedColumnName = "id", nullable = false)
    private VooAgendado vooAgendado;
    
    public Passagem(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getBagagem() {
        return bagagem;
    }

    public void setBagagem(Integer bagagem) {
        this.bagagem = bagagem;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public VooAgendado getVooAgendado() {
        return vooAgendado;
    }

    public void setVooAgendado(VooAgendado vooAgendado) {
        this.vooAgendado = vooAgendado;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passagem passagem = (Passagem) o;
        return Objects.equals(id, passagem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
