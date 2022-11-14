package hh.swd20.musicapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Playlist {
	
	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playlistId;
	private String name, coverLink;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
	private List<Track> tracks;
	
	// constructors
	public Playlist () {}
	
	public Playlist(String name, String coverLink) {
		super();
		this.name = name;
		this.coverLink = coverLink;
	}

	// getters and setters
	public Long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCoverLink() {
		return coverLink;
	}

	public void setCoverLink(String coverLink) {
		this.coverLink = coverLink;
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
		return "Playlist [playlistId=" + playlistId + ", name=" + name + ", coverLink=" + coverLink + "]";
	}
	
}