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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "vooAgendado")
public class VooAgendado implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_vooAgendado", sequenceName = "seq_vooAgendado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_vooAgendado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A aeronave nao pode ser em branco")
    @Length(max = 30, message = "A aeronave nao pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false)
    private String aeronave;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informado")
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "O total de passageiros deve ser informado")
    @Column(name = "totalPassageiros", nullable = false)
    private Integer totalPassageiros;
    
    @OneToMany(mappedBy = "vooAgendado", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Passagem> passagem = new ArrayList<>();
    
    @NotNull(message = "O voo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "voo_id", referencedColumnName = "id", nullable = false)
    private Voo voo;

    public VooAgendado(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Integer getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(Integer totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public List<Passagem> getPassagem() {
        return passagem;
    }

    public void setPassagem(List<Passagem> passagem) {
        this.passagem = passagem;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VooAgendado vooAgendado = (VooAgendado) o;
        return Objects.equals(id, vooAgendado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}