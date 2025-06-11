package bau.dev.mgca.services;

import bau.dev.mgca.DTO.RelatorioProcessoRequestDTO;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;



public interface RelatorioExportadorService {

    public ByteArrayInputStream gerarRelatorioSimples();
    public ByteArrayInputStream gerarRelatorioGeral();
    public ByteArrayInputStream gerarRelatorioParams(RelatorioProcessoRequestDTO relatorioProcessoRequestDTO);
}
