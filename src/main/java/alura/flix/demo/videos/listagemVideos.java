package alura.flix.demo.videos;

public record listagemVideos(
        Long id,
        String titulo,
        String descricao,
        String url) {
  public listagemVideos(Videos videos) {
    this(videos.getId(), videos.getTitulo(), videos.getDescricao(), videos.getUrl());
  }
}
