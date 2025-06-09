package bau.dev.mgca.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExportadorDTO {
    private Long id;
    private String nomeEmpresa;
    private String nuit;
    private String email;
    private String numeroAlvara;
    private String tipoExportador;
    private String tipoProduto;
    private Integer nuel;
    private String actividadeComercial;



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

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getTipoExportador() {
        return tipoExportador;
    }

    public void setTipoExportador(String tipoExportador) {
        this.tipoExportador = tipoExportador;
    }

    public String getNumeroAlvara() {
        return numeroAlvara;
    }

    public void setNumeroAlvara(String numeroAlvara) {
        this.numeroAlvara = numeroAlvara;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


}
