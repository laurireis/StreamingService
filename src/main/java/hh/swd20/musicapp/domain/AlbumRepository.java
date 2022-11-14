package hh.swd20.musicapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
	List<Album> findByName(String name);
}