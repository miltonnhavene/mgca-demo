package bau.dev.mgca.entity;

import bau.dev.mgca.config.enums.Decisao;
import bau.dev.mgca.config.enums.Estado;
import jakarta.persistence.*;

@Entity
@Table(name="avaliarProcesso")
public class AvaliarProcessoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Enumerated(EnumType.STRING)
    private Estado estado=Estado.Submetido;
    @Enumerated(EnumType.STRING)
    private Decisao decisao;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "id_processo", nullable = false)
    private ProcessoCadastroEntity processoCadastroEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Decisao getDecisao() {
        return decisao;
    }

    public void setDecisao(Decisao decisao) {
        this.decisao = decisao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ProcessoCadastroEntity getProcessoCadastroEntity() {
        return processoCadastroEntity;
    }

    public void setProcessoCadastroEntity(ProcessoCadastroEntity processoCadastroEntity) {
        this.processoCadastroEntity = processoCadastroEntity;
    }
}
