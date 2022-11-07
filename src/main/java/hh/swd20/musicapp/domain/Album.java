package hh.swd20.musicapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
	
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long albumId;
	private String artist;
	private String name;
	private String releaseDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
	private List<Track> tracks;
	
	// constructors
	public Album () {}
	
	public Album(String artist, String name, String releaseDate) {
		super();
		this.artist = artist;
		this.name = name;
		this.releaseDate = releaseDate;
	}
	
	// getters and setters
	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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
		return "Album [albumId=" + albumId + ", artist=" + artist + ", name=" + name + ", releaseDate=" + releaseDate
				+ "]";
	}
	
}
