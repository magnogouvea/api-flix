package alura.flix.demo.controller;


import alura.flix.demo.videos.DadosCadastroVideos;
import alura.flix.demo.videos.Videos;
import alura.flix.demo.videos.VideosRepository;
import alura.flix.demo.videos.listagemVideos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class VideosController {

  @Autowired
  private VideosRepository videosRepository;

  @GetMapping
  public Page<listagemVideos> listarVideos(
    @PageableDefault(sort = {"id"})Pageable paginacao) {
    return videosRepository.findAll(paginacao).map(listagemVideos::new);
  }

  @Transactional
  @PostMapping
  public void cadastrarVideo(@RequestBody @Valid DadosCadastroVideos dados) {
    videosRepository.save(new Videos(dados));
  }
}
