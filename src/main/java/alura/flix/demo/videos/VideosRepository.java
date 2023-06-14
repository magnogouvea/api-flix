package alura.flix.demo.videos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideosRepository extends JpaRepository<Videos, Long> {
}
