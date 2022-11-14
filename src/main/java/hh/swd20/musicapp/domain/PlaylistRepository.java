package hh.swd20.musicapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
	List<Playlist> findByName(String name);
}