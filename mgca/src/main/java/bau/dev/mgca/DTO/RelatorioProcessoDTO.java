package bau.dev.mgca.DTO;

import java.time.LocalDate;
import java.util.List;

public class RelatorioProcessoDTO {
    private String nomeEmpresa;
    private LocalDate dataSubmissao;
    private String estado;
    private String decisao;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDecisao() {
        return decisao;
    }

    public void setDecisao(String decisao) {
        this.decisao = decisao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataSubmissao() {
        return dataSubmissao;
    }

    public void setDataSubmissao(LocalDate dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }
}
