package br.edu.ifsc.fln.domain;


import jakarta.persistence.*;

@Entity
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne 
    @JoinColumn(name = "id_marca", nullable = false) 
    private Marca marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private ECategoria ecategoria;

    public Modelo() {}

    public Modelo(String descricao, Marca marca, ECategoria ecategoria) {
        this.descricao = descricao;
        this.marca = marca;
        this.ecategoria = ecategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public ECategoria getEcategoria() {
        return ecategoria;
    }

    public void setEcategoria(ECategoria ecategoria) {
        this.ecategoria = ecategoria;
    }
}
