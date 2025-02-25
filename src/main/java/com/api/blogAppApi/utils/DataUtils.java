package com.api.blogAppApi.utils;

import com.api.blogAppApi.models.BlogAppPostModel;
import com.api.blogAppApi.repositories.BlogAppPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataUtils {

    private final BlogAppPostRepository blogRepository;

    @Autowired
    public DataUtils(BlogAppPostRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    // @PostConstruct // Descomente na primeira execução para popular o banco de dados
    public void savePosts() {
        List<BlogAppPostModel> postList = new ArrayList<>();

        // Criando primeiro post
        BlogAppPostModel post1 = new BlogAppPostModel();
        post1.setAutor("Pokemon");
        post1.setTitulo("Docker");
        post1.setTexto(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived for not only five centuries, but also the leap into electronic typesetting, " +
                        "remaining essentially unchanged. It was popularized in the 1960s with the release of " +
                        "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                        "publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        );

        // Criando segundo post
        BlogAppPostModel post2 = new BlogAppPostModel();
        post2.setAutor("Ben10");
        post2.setTitulo("API REST");
        post2.setTexto(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived for not only five centuries, but also the leap into electronic typesetting, " +
                        "remaining essentially unchanged. It was popularized in the 1960s with the release of " +
                        "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                        "publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        );

        // Adicionando posts à lista
        postList.add(post1);
        postList.add(post2);

        // Salvando posts no banco de dados
        for (BlogAppPostModel post : postList) {
            BlogAppPostModel postSaved = blogRepository.save(post);
            System.out.println("Post salvo com ID: " + postSaved.getId());
        }
    }
}

