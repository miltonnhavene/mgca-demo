package bau.dev.mgca.services.implments;

import bau.dev.mgca.DTO.RelatorioProcessoResponseDTO;
import bau.dev.mgca.entity.AvaliarProcessoEntity;
import bau.dev.mgca.entity.DocumentoAnexoEntity;
import bau.dev.mgca.entity.ProcessoCadastroEntity;
import bau.dev.mgca.repository.AvaliarProcessoRepository;
import bau.dev.mgca.repository.ExportadorRepository;
import bau.dev.mgca.repository.ProcessoCadastroRepository;
import bau.dev.mgca.services.RelatorioExportadorService;
import bau.dev.mgca.transform.ExportadorTransform;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RelatorioExportadorServiceImplements implements RelatorioExportadorService {

    @Autowired
    private ExportadorRepository exportadorRepository;
    @Autowired
    private ProcessoCadastroRepository processoCadastroRepository;
    @Autowired
    private AvaliarProcessoRepository avaliarProcessoRepository;

    @Autowired
    private AvaliarProcessoEntity avaliarProcessoEntity;

    @Autowired
    private RelatorioProcessoResponseDTO relatorioProcessoResponseDTO;

    public ByteArrayInputStream gerarRelatorioGeral() {
//       relatorioProcessoResponseDTO.setTotalAprovados(avaliarProcessoRepository.fi);
//        long totalAprovados=relatorioProcessoResponseDTO.getTotalAprovados();
        relatorioProcessoResponseDTO.setTotalAprovados(exportadorRepository.count());
        relatorioProcessoResponseDTO.setTotalProcessosSubmetidos(processoCadastroRepository.count());
        long totalProcessos= relatorioProcessoResponseDTO.getTotalProcessosSubmetidos();
        long totalExportadores= relatorioProcessoResponseDTO.getTotalExportadores();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Relatório Simples de Processos"));
        document.add(new Paragraph("Este é um exemplo básico de PDF gerado em tempo de execução."));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Numero de processos: "));
        document.add(new Paragraph("Numero de processos Avaliados: "));
        document.add(new Paragraph(" Um processo para exemplificar"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Exportador: " ));
        document.add(new Paragraph("Processo: "));
        document.add(new Paragraph("Documentos: "));
        return new ByteArrayInputStream(out.toByteArray());
    }
    public ByteArrayInputStream gerarRelatorioSimples() {
        long id=1;
       // Optional<ProcessoCadastroEntity> optionalProcesso = processoCadastroRepository.findById(id);
        //Optional<ProcessoCadastroEntity>optionalProcessoCadastroEntity = processoCadastroRepository.findAll();
        long processoCadastroNUmero = processoCadastroRepository.count();
        long numeroProcessoAvaliados = avaliarProcessoRepository.count();
        Optional<AvaliarProcessoEntity>optionalAvaliarProcesso = avaliarProcessoRepository.findById(id);
        List<DocumentoAnexoEntity> documentos = optionalAvaliarProcesso.get().getProcessoCadastroEntity().getDocumentos();

        String documentosStr = documentos.stream()
                .map(doc ->
                        ", Tipo: " + doc.getTipoDcumento() )
                .collect(Collectors.joining("\n"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Relatório Simples de Processos"));
        document.add(new Paragraph("Este é um exemplo básico de PDF gerado em tempo de execução."));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Numero de processos: "+ processoCadastroNUmero));
        document.add(new Paragraph("Numero de processos Avaliados: "+ numeroProcessoAvaliados));
        document.add(new Paragraph(" Um processo para exemplificar"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Exportador: "+optionalAvaliarProcesso.get().getProcessoCadastroEntity().getExportadorEntity().getNomeEmpresa()));
        document.add(new Paragraph("Processo: "+optionalAvaliarProcesso.get().getDecisao()));
        document.add(new Paragraph("Documentos: "+ documentosStr));

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }




}
