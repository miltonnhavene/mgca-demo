package bau.dev.mgca.resources;

import bau.dev.mgca.services.RelatorioExportadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relatorio")
public class RelatorioResources {
    @Autowired
    RelatorioExportadorService relatorioExportadorService;
    @GetMapping
    public ResponseEntity<InputStreamResource> baixarPdf() {
        var pdfStream = relatorioExportadorService.gerarRelatorioSimples();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdfStream));
    }
}
