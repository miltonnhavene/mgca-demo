package bau.dev.mgca.services.implments;

import bau.dev.mgca.DTO.RelatorioProcessoRequestDTO;
import bau.dev.mgca.DTO.RelatorioProcessoResponseDTO;
import bau.dev.mgca.config.enums.Decisao;
import bau.dev.mgca.config.enums.Estado;
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


    public ByteArrayInputStream gerarRelatorioGeral() {
        // relatorioProcessoResponseDTO.setTotalAprovados(avaliarProcessoRepository.fi);
//        long totalAprovados=relatorioProcessoResponseDTO.getTotalAprovados();
        RelatorioProcessoResponseDTO relatorioProcessoResponseDTO = new RelatorioProcessoResponseDTO();
        relatorioProcessoResponseDTO.setTotalExportadores(exportadorRepository.count());
        relatorioProcessoResponseDTO.setTotalProcessosSubmetidos(processoCadastroRepository.count());
        relatorioProcessoResponseDTO.setTotalAprovados(avaliarProcessoRepository.countByDecisao(Decisao.Deferido));
        relatorioProcessoResponseDTO.setTotalReprovados(avaliarProcessoRepository.countByDecisao(Decisao.Indeferido));

        long emAnalise = avaliarProcessoRepository.countByEstado(Estado.parecer)
                + avaliarProcessoRepository.countByEstado(Estado.conformidade)
                + avaliarProcessoRepository.countByEstado(Estado.Rever);

        relatorioProcessoResponseDTO.setTotalEmAnalise(emAnalise);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Relatório Simples de Processos"));
        document.add(new Paragraph("Este é um exemplo básico de PDF gerado em tempo de execução."));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Numero de Exportadores: "+relatorioProcessoResponseDTO.getTotalExportadores()));
        document.add(new Paragraph("Numero de Processos Submetidos: "+relatorioProcessoResponseDTO.getTotalProcessosSubmetidos()));
        document.add(new Paragraph("Numero de processos Aprovados: "+ relatorioProcessoResponseDTO.getTotalAprovados()));
        document.add(new Paragraph("Numero de processos Reprovados: "+ relatorioProcessoResponseDTO.getTotalReprovados()));
        document.add(new Paragraph(" Numero de processos em analise"+ relatorioProcessoResponseDTO.getTotalEmAnalise()));

        document.add(new Paragraph(" Um processo para exemplificar"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Exportador: " ));
        document.add(new Paragraph("Processo: "));
        document.add(new Paragraph("Documentos: "));
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
/// como Parametros

public ByteArrayInputStream gerarRelatorioParams(RelatorioProcessoRequestDTO relatorioProcessoRequestDTO) {
    List<AvaliarProcessoEntity> lista = avaliarProcessoRepository
            .buscarPorFiltros(
                    relatorioProcessoRequestDTO.getEstado(),
                    relatorioProcessoRequestDTO.getDataInicio(),
                    relatorioProcessoRequestDTO.getDataFim()
            );
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PdfWriter writer = new PdfWriter(out);
    PdfDocument pdf = new PdfDocument(writer);
    Document document = new Document(pdf);
    document.add(new Paragraph("Relatório Simples de Processos"));
    document.add(new Paragraph("Este é um exemplo básico de PDF gerado em tempo de execução."));
    document.add(new Paragraph(" "));
    document.add(new Paragraph("Relatório Filtrado por Estado e Intervalo de Datas"));
    document.add(new Paragraph("Estado: " + relatorioProcessoRequestDTO.getEstado()));
    document.add(new Paragraph("Data Início: " + relatorioProcessoRequestDTO.getDataInicio()));
    document.add(new Paragraph("Data Fim: " + relatorioProcessoRequestDTO.getDataFim()));
    document.add(new Paragraph("Total de Registros: " + lista.size()));
    document.add(new Paragraph(" "));

    for (AvaliarProcessoEntity avaliacao : lista) {
        document.add(new Paragraph("Exportador: " +
                avaliacao.getProcessoCadastroEntity().getExportadorEntity().getNomeEmpresa()));
        document.add(new Paragraph("Data Submissão: " +
                avaliacao.getProcessoCadastroEntity().getDataSubmissao()));
        document.add(new Paragraph("Decisão: " + avaliacao.getDecisao()));
        document.add(new Paragraph("Estado: " + avaliacao.getEstado()));
        document.add(new Paragraph("Observação: " + avaliacao.getObservacao()));
        document.add(new Paragraph("------------------------------------------------------------"));
    }



    document.close();
    return new ByteArrayInputStream(out.toByteArray());
}

    /// teste
    public ByteArrayInputStream gerarRelatorioSimples() {
        long id=1;
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
