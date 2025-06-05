package bau.dev.mgca.resources;


import bau.dev.mgca.DTO.ExportadorDTO;
import bau.dev.mgca.services.ExportadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exportadores")
public class ExportadorResource {
    @Autowired
    private ExportadorService exportadorService;

    @PostMapping
    public ResponseEntity<String> createExportador(@RequestBody ExportadorDTO exportadorDTO){
        String text = exportadorService.createExportador(exportadorDTO);
        return ResponseEntity.ok(text);
    }
}
