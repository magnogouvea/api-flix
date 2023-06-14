package alura.flix.demo.controller;


import alura.flix.demo.videos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;

@RestController
@RequestMapping("/videos")
public class VideosController {

  @Autowired
  private VideosRepository videosRepository;

  @GetMapping
  public Page<ListagemVideos> listarVideos(
    @PageableDefault(sort = {"id"})Pageable paginacao) {
    return videosRepository.findAll(paginacao).map(ListagemVideos::new);
  }

  @GetMapping("/{id}")
  public Videos listarPorId(@PathVariable Long id) {
    return videosRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Vídeo não encontrado"));
  }


  @Transactional
  @PostMapping
  public void cadastrarVideo(@RequestBody @Valid DadosCadastroVideos dados) {
    videosRepository.save(new Videos(dados));
  }
}
