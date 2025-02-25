package com.api.blogAppApi.controllers;

import com.api.blogAppApi.dtos.impls.ComentarioDTO;
import com.api.blogAppApi.models.BlogAppPostModel;
import com.api.blogAppApi.models.PostComentarioModel;
import com.api.blogAppApi.services.BlogAppPostService;
import com.api.blogAppApi.services.PostComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/posts/{postId}/comentarios")
public class PostComentarioController {

    private final PostComentarioService comentarioService;
    private final BlogAppPostService postService;

    public PostComentarioController(PostComentarioService comentarioService, BlogAppPostService postService) {
        this.comentarioService = comentarioService;
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostComentarioModel> criarComentario(@PathVariable UUID postId, @RequestBody ComentarioDTO dto) {

        Optional<BlogAppPostModel> post = postService.buscarPostPorId(postId);
        if (post.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PostComentarioModel novoComentario = new PostComentarioModel();
        novoComentario.setComentario(dto.comentario());
        novoComentario.setPost(post.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.salvarComentario(novoComentario));
    }

    @GetMapping
    public ResponseEntity<List<PostComentarioModel>> listarComentariosDoPost(@PathVariable UUID postId) {
        return ResponseEntity.ok(comentarioService.listarComentariosPorPost(postId));
    }

    @GetMapping("/{comentarioId}")
    public ResponseEntity<PostComentarioModel> buscarComentario(@PathVariable UUID comentarioId, @PathVariable String postId) {
        Optional<PostComentarioModel> comentario = comentarioService.buscarComentarioPorId(comentarioId);
        return comentario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{comentarioId}")
    public ResponseEntity<Void> excluirComentario(@PathVariable UUID comentarioId, @PathVariable String postId) {

        comentarioService.excluirComentario(comentarioId);
        return ResponseEntity.noContent().build();
    }
}