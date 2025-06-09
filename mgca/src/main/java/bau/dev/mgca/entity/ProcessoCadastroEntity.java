package bau.dev.mgca.entity;

import bau.dev.mgca.config.enums.Estado;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="processoCadastro")
public class ProcessoCadastroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataSubmissao=LocalDate.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exportador",  nullable = false)
    private ExportadorEntity exportadorEntity;
    @OneToMany(mappedBy = "processoCadastroEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvaliarProcessoEntity> avaliacoes = new ArrayList<>();
    @OneToMany(mappedBy = "processoCadastroEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentoAnexoEntity> documentos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataSubmissao() {
        return dataSubmissao;
    }

    public void setDataSubmissao(LocalDate dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public ExportadorEntity getExportadorEntity() {
        return exportadorEntity;
    }

    public void setExportadorEntity(ExportadorEntity exportadorEntity) {
        this.exportadorEntity = exportadorEntity;
    }

    public List<DocumentoAnexoEntity> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoAnexoEntity> documentos) {
        this.documentos = documentos;
    }

    public List<AvaliarProcessoEntity> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliarProcessoEntity> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}