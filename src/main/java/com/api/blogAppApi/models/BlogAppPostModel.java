package com.api.blogAppApi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>BlogAppPostModel</h1>
 * <p>
 * A classe {@code BlogAppPostModel} representa um modelo de entidade para posts em um sistema de blog.
 * Esta classe é mapeada como uma entidade JPA (Java Persistence API) e é usada para persistir informações
 * relacionadas a posts no banco de dados. Cada post contém informações como o autor, data de publicação,
 * título e o conteúdo do texto.
 *
 * <p>A classe implementa a interface {@link Serializable} para permitir que os objetos sejam serializados,
 * facilitando o armazenamento ou transmissão dos dados.</p>
 */
@Data
@Entity
public class BlogAppPostModel implements Serializable {

    /**
     * Número de série único para controle de versão da classe durante a serialização.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do post. Gerado automaticamente pelo provedor JPA utilizando a estratégia
     * de geração de identidade ({@code GenerationType.IDENTITY}). O tipo utilizado é {@code UUID}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Nome do autor do post. Este campo não possui restrição de unicidade e tem um comprimento máximo
     * de 70 caracteres.
     */
    @Column(nullable = false, length = 70)
    private String autor;

    /**
     * Data e hora de criação ou publicação do post. Este campo não possui restrição de unicidade.
     */
    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now(); // Data é definida no servidor

    /**
     * Título do post. Este campo não possui restrição de unicidade e tem um comprimento máximo
     * de 70 caracteres.
     */
    @Column(nullable = false, length = 70)
    private String titulo;

    /**
     * Conteúdo textual do post. Este campo é mapeado como um objeto de grande tamanho ({@code @Lob})
     * e é definido como um tipo de coluna de texto ({@code columnDefinition = "text"}).
     */
    @Lob
    @Column(columnDefinition = "text")
    private String texto;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
