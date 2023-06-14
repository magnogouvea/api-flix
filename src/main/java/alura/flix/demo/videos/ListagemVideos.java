package alura.flix.demo.videos;

public record ListagemVideos(
        Long id,
        String titulo,
        String descricao,
        String url) {
  public ListagemVideos(Videos videos) {
    this(videos.getId(), videos.getTitulo(), videos.getDescricao(), videos.getUrl());
  }
}
