package bau.dev.mgca.transform;

import bau.dev.mgca.DTO.RelatorioProcessoRequestDTO;
import bau.dev.mgca.DTO.RelatorioProcessoResponseDTO;
import bau.dev.mgca.config.enums.Decisao;
import bau.dev.mgca.entity.AvaliarProcessoEntity;
import bau.dev.mgca.repository.AvaliarProcessoRepository;
import org.springframework.stereotype.Component;

@Component
public class RelatorioProcessoTransform {

    public RelatorioProcessoResponseDTO toDto(AvaliarProcessoEntity avaliarProcessoEntity)
    {
        if(avaliarProcessoEntity==null){
            return null;
        }
        RelatorioProcessoResponseDTO dto= new RelatorioProcessoResponseDTO();
        dto.setIdProcesso(avaliarProcessoEntity.getProcessoCadastroEntity().getId());
        dto.setEstado(avaliarProcessoEntity.getEstado().toString());
        dto.setNomeEmpresa(avaliarProcessoEntity.getProcessoCadastroEntity().getExportadorEntity().getNomeEmpresa());
        dto.setDataSubmissao(avaliarProcessoEntity.getProcessoCadastroEntity().getDataSubmissao());

        return dto;
    }


}
