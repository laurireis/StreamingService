package hh.swd20.musicapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Track {
	
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trackId;
	private String artist;
	private String name;
	private String link;
	
	@ManyToOne
	@JsonIgnoreProperties("tracks")
	@JoinColumn(name = "genreId")
	private Genre genre;
	
	@ManyToOne
	@JsonIgnoreProperties("tracks")
	@JoinColumn(name = "albumId")
	private Album album;
	
	@ManyToOne
	@JsonIgnoreProperties("tracks")
	@JoinColumn(name = "playlistId")
	private Playlist playlist;
	
	// constructors
	public Track () {}
	
	public Track(String artist, String name, String link, Genre genre, Album album, Playlist playlist) {
		super();
		this.artist = artist;
		this.name = name;
		this.link = link;
		this.genre = genre;
		this.album = album;
		this.playlist = playlist;
	}
	
	// getters and setters
	public Long getTrackId() {
		return trackId;
	}


	public void setTrackId(Long trackId) {
		this.trackId = trackId;
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
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	// toString
	@Override
	public String toString() {
		return "Track [id=" + trackId + ", artist=" + artist + ", name=" + name + "]";
	}
	
}
