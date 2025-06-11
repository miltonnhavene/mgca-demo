package bau.dev.mgca.DTO;

import bau.dev.mgca.config.enums.Estado;

import java.time.LocalDate;

public class RelatorioProcessoRequestDTO {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Estado estado;


    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
