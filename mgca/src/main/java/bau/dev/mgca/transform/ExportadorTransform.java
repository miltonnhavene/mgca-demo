package bau.dev.mgca.transform;

import bau.dev.mgca.DTO.ExportadorDTO;
import bau.dev.mgca.entity.ExportadorEntity;
import org.springframework.stereotype.Component;

@Component
public class ExportadorTransform {
    public ExportadorDTO toDTO(ExportadorEntity exportadorEntity){
       if (exportadorEntity == null){
           return null;
       }
       ExportadorDTO dto = new ExportadorDTO();
       dto.setId(exportadorEntity.getId());
       dto.setNomeEmpresa(exportadorEntity.getNomeEmpresa());
       dto.setNuit(exportadorEntity.getNuit());
       dto.setEmail(exportadorEntity.getEmail());
       dto.setNumeroAlvara(exportadorEntity.getNumeroAlvara());
       dto.setTipoExportador(exportadorEntity.getTipoExportador());
       dto.setNuel(exportadorEntity.getNuel());
       dto.setActividadeComercial(exportadorEntity.getActividadeComercial());
       return dto;
    }

    public ExportadorEntity toEntity(ExportadorDTO exportadorDTO){
        if(exportadorDTO == null){
            return null;
        }
        ExportadorEntity entity = new ExportadorEntity();
        entity.setId(exportadorDTO.getId());
        entity.setNomeEmpresa(exportadorDTO.getNomeEmpresa());
        entity.setNuit(exportadorDTO.getNuit());
        entity.setEmail(exportadorDTO.getEmail());
        entity.setNumeroAlvara(exportadorDTO.getNumeroAlvara());
        entity.setTipoExportador(exportadorDTO.getTipoExportador());
        entity.setNuel(exportadorDTO.getNuel());
        entity.setActividadeComercial(exportadorDTO.getActividadeComercial());
        return entity;
    }


}
