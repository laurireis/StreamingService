package hh.swd20.musicapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.musicapp.domain.Album;
import hh.swd20.musicapp.domain.AlbumRepository;
import hh.swd20.musicapp.domain.Genre;
import hh.swd20.musicapp.domain.GenreRepository;
import hh.swd20.musicapp.domain.Playlist;
import hh.swd20.musicapp.domain.PlaylistRepository;
import hh.swd20.musicapp.domain.Track;
import hh.swd20.musicapp.domain.TrackRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {
	
	@Autowired
	private TrackRepository trepository;
	
	@Autowired
	private AlbumRepository arepository;
	
	@Autowired
	private GenreRepository grepository;
	
	@Autowired
	private PlaylistRepository prepository;
	
	SimpleDateFormat fdate = new SimpleDateFormat("dd.MM.yyyy");
	
	@Test
	public void findByTrackNameShouldReturnTrack() {
		List<Track> tracks = trepository.findByName("Chimera");
		assertThat(tracks).hasSize(1);
		assertThat(tracks.get(0).getArtist()).isEqualTo("Polyphia");
	}
	
	@Test
	public void createNewTrack() {
		Track track = new Track("Jaakko Teppo", "Jälkitauti", null, null, null, null);
		trepository.save(track);
		assertThat(track.getArtist()).isNotNull();
	}
	
	@Test
	public void findByAlbumNameShouldReturnAlbum() {
		List<Album> albums = arepository.findByName("Remember That You Will Die");
		assertThat(albums).hasSize(1);
		assertThat(albums.get(0).getArtist()).isEqualTo("Polyphia");
	}
	
	@Test
	public void createNewAlbum() throws ParseException {
		Album album = new Album("Jaakko Teppo", "Ruikonperän Multakurkku", fdate.parse("1.1.1980"));
		arepository.save(album);
		assertThat(album.getArtist()).isNotNull();
	}
	
	@Test
	public void findByNameShouldReturnGenre() {
		List<Genre> genres = grepository.findByName("Metal");
		assertThat(genres).hasSize(1);
		assertThat(genres.get(0).getGenreId()).isEqualTo(3);
	}
	
	@Test
	public void createNewGenre() {
		Genre genre = new Genre("Jazz");
		grepository.save(genre);
		assertThat(genre.getGenreId()).isNotNull();
	}
	
	@Test
	public void findByNameShouldReturnPlaylist() {
		List<Playlist> playlists = prepository.findByName("Iskelmä");
		assertThat(playlists).hasSize(1);
		assertThat(playlists.get(0).getPlaylistId()).isEqualTo(2);
	}
	
	@Test
	public void createNewPlaylist() {
		Playlist playlist = new Playlist("Best of hip-hop", null);
		prepository.save(playlist);
		assertThat(playlist.getPlaylistId()).isNotNull();
	}

}