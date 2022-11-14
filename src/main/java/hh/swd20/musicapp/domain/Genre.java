package hh.swd20.musicapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genreId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Track> tracks;
	
	// constructors
	public Genre () {}
	
	public Genre(String name) {
		super();
		this.name = name;
	}
	
	// getters and setters
	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	// toString
	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", name=" + name + "]";
	}
	
}