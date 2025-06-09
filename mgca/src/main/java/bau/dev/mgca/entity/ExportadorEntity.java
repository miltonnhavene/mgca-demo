package bau.dev.mgca.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="exportador")
public class ExportadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomeEmpresa;
    private String nuit;
    private String email;
    private String numeroAlvara;
    private String tipoExportador;
    private String tipoProduto;
    private Integer nuel;
    private String actividadeComercial;

    @OneToMany(
            mappedBy = "exportadorEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProcessoCadastroEntity> processos = new ArrayList<>();


    public List<ProcessoCadastroEntity> getProcessos() {
        return processos;
    }


    public void setProcessos(List<ProcessoCadastroEntity> processos) {
        this.processos = processos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActividadeComercial() {
        return actividadeComercial;
    }

    public void setActividadeComercial(String actividadeComercial) {
        this.actividadeComercial = actividadeComercial;
    }

    public Integer getNuel() {
        return nuel;
    }

    public void setNuel(Integer nuel) {
        this.nuel = nuel;
    }

    public String getTipoExportador() {
        return tipoExportador;
    }

    public void setTipoExportador(String tipoExportador) {
        this.tipoExportador = tipoExportador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroAlvara() {
        return numeroAlvara;
    }

    public void setNumeroAlvara(String numeroAlvara) {
        this.numeroAlvara = numeroAlvara;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
