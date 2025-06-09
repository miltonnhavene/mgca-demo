package bau.dev.mgca.DTO;

import bau.dev.mgca.config.enums.Estado;

import java.time.LocalDate;

public class RelatorioProcessoRequestDTO {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Estado estado;
}
