package hh.swd20.musicapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String artist;
	private String name;
	
	
	// constructors
		public Track () {}
	
	public Track(Long id, String artist, String name) {
		super();
		this.id = id;
		this.artist = artist;
		this.name = name;
	}
	
	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "Track [id=" + id + ", artist=" + artist + ", name=" + name + "]";
	}
	
	
	
}
