package bau.dev.mgca.resources;


import bau.dev.mgca.DTO.ExportadorDTO;
import bau.dev.mgca.entity.ExportadorEntity;
import bau.dev.mgca.services.ExportadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/exportadores")
public class ExportadorResource {
    @Autowired
    private ExportadorService exportadorService;

    @PostMapping
    public ResponseEntity<ExportadorDTO> createBook(@RequestBody ExportadorDTO exportadorDTO) {
        ExportadorDTO savedExportador = exportadorService.createExportador(exportadorDTO);
        return new ResponseEntity<>(savedExportador, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExportadorDTO> getExportadorById(@PathVariable Long id){
        try {
            ExportadorDTO dto = exportadorService.getExportadorById(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <ExportadorEntity> updateBook(@PathVariable Long id, @RequestBody ExportadorDTO exportadorDTO){
        ExportadorEntity updatedExportador = exportadorService.updateExportador(id, exportadorDTO);
        if(updatedExportador == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedExportador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteBook(@PathVariable Long id){
        exportadorService.deleteExportador(id);
        return ResponseEntity.noContent().build();
    }




}
