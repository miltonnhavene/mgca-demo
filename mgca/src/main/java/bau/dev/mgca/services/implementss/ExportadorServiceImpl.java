package bau.dev.mgca.services.implementss;

import bau.dev.mgca.DTO.ExportadorDTO;
import bau.dev.mgca.entity.ExportadorEntity;
import bau.dev.mgca.repository.ExportadorRepository;
import bau.dev.mgca.services.ExportadorService;
import bau.dev.mgca.transform.ExportadorTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportadorServiceImpl implements ExportadorService {
    @Autowired
    private ExportadorRepository exportadorRepository;

    @Autowired
    private ExportadorTransform mapper;


    @Override
    public String createExportador(ExportadorDTO exportadorDTO) {
        ExportadorEntity exportadorEntity = mapper.toEntity(exportadorDTO);
        exportadorRepository.save(exportadorEntity);
        return "Exportado salvo";
    }
}
