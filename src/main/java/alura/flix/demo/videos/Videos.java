package alura.flix.demo.videos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Videos {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String descricao;
  private String url;

  public Videos (DadosCadastroVideos dados) {
    this.titulo = dados.titulo();
    this.descricao = dados.descricao();
    this.url = dados.url();
  }
}
