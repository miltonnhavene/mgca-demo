package bau.dev.mgca.DTO;

import java.time.LocalDate;

public class RelatorioProcessoResponseDTO {
    private String nomeEmpresa;
    private Long idProcesso;
    private LocalDate dataSubmissao;
    private String estado;

    private long totalExportadores;
    private long totalProcessosSubmetidos;
    private long totalAprovados;
    private long totalReprovados;
    private long totalEmAnalise;

    public Long getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Long idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public LocalDate getDataSubmissao() {
        return dataSubmissao;
    }

    public void setDataSubmissao(LocalDate dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getTotalExportadores() {
        return totalExportadores;
    }

    public void setTotalExportadores(long totalExportadores) {
        this.totalExportadores = totalExportadores;
    }

    public long getTotalProcessosSubmetidos() {
        return totalProcessosSubmetidos;
    }

    public void setTotalProcessosSubmetidos(long totalProcessosSubmetidos) {
        this.totalProcessosSubmetidos = totalProcessosSubmetidos;
    }

    public long getTotalAprovados() {
        return totalAprovados;
    }

    public void setTotalAprovados(long totalAprovados) {
        this.totalAprovados = totalAprovados;
    }

    public long getTotalReprovados() {
        return totalReprovados;
    }

    public void setTotalReprovados(long totalReprovados) {
        this.totalReprovados = totalReprovados;
    }

    public long getTotalEmAnalise() {
        return totalEmAnalise;
    }

    public void setTotalEmAnalise(long totalEmAnalise) {
        this.totalEmAnalise = totalEmAnalise;
    }
}
