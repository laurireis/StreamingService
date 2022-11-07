package hh.swd20.musicapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track, Long> {
	
	List<Track> findByName(String name);
	
}