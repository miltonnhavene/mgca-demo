package bau.dev.mgca.entity;

import bau.dev.mgca.config.enums.TipoDcumento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="documentoAnexo")
public class DocumentoAnexoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDcumento tipoDcumento;
    private String caminhoFicheiro;
    private LocalDateTime dataUpload=LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_processo", nullable = false)
    private ProcessoCadastroEntity processoCadastroEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDcumento getTipoDcumento() {
        return tipoDcumento;
    }

    public void setTipoDcumento(TipoDcumento tipoDcumento) {
        this.tipoDcumento = tipoDcumento;
    }

    public String getCaminhoFicheiro() {
        return caminhoFicheiro;
    }

    public void setCaminhoFicheiro(String caminhoFicheiro) {
        this.caminhoFicheiro = caminhoFicheiro;
    }

    public LocalDateTime getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDateTime dataUpload) {
        this.dataUpload = dataUpload;
    }

    public ProcessoCadastroEntity getProcessoCadastroEntity() {
        return processoCadastroEntity;
    }

    public void setProcessoCadastroEntity(ProcessoCadastroEntity processoCadastroEntity) {
        this.processoCadastroEntity = processoCadastroEntity;
    }
}
