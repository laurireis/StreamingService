package hh.swd20.musicapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.musicapp.domain.Album;
import hh.swd20.musicapp.domain.AlbumRepository;
import hh.swd20.musicapp.domain.Genre;
import hh.swd20.musicapp.domain.GenreRepository;
import hh.swd20.musicapp.domain.Playlist;
import hh.swd20.musicapp.domain.PlaylistRepository;
import hh.swd20.musicapp.domain.Track;
import hh.swd20.musicapp.domain.TrackRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MusicappApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MusicappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner musicDemo(TrackRepository trepository, AlbumRepository arepository, GenreRepository grepository, PlaylistRepository prepository) {
		return (args) -> {
			log.info("Create a few genres");
			Genre genre1 = new Genre("Other");
			Genre genre2 = new Genre("Pop");
			Genre genre3 = new Genre("Metal");
			Genre genre4 = new Genre("Rap");
			grepository.save(genre1);
			grepository.save(genre2);			
			grepository.save(genre3);
			grepository.save(genre4);
			
			log.info("Create a few albums");
			Album album1 = new Album("TesseracT", "Polaris", "18.9.2015");
			Album album2 = new Album("Polyphia", "Remember That You Will Die", "28.10.2022");
			Album album3 = new Album("Matti ja Teppo", "Pidä itsestäsi huolta", "1.1.1982");
			Album album4 = new Album("Kendrick Lamar", "good kid, m.A.A.d city", "22.10.2012");
			arepository.save(album1);
			arepository.save(album2);
			arepository.save(album3);
			arepository.save(album4);
			
			log.info("Create a few playlists");
			Playlist playlist1 = new Playlist("Progressive Metal");
			Playlist playlist2 = new Playlist("Iskelmä");
			prepository.save(playlist1);
			prepository.save(playlist2);
			
			log.info("Create a few tracks");
			Track track1 = new Track("TesseracT", "Dystopia", "https://www.youtube.com/watch?v=lR5amOOvpwQ", genre3, album1, playlist1);
			Track track2 = new Track("Polyphia", "Chimera", "https://www.youtube.com/watch?v=_L5FLJ1H_Lk", genre3, album2, null);
			Track track3 = new Track("Matti ja Teppo", "Mä joka päivä töitä teen", "https://www.youtube.com/watch?v=1-YiaQZz1zY", genre2, album3, playlist2);
			Track track4 = new Track("Kendrick Lamar", "good kid", "https://www.youtube.com/watch?v=dxkohu0iZPk", genre4, album4, null);
			trepository.save(track1);
			trepository.save(track2);
			trepository.save(track3);
			trepository.save(track4);
			
			log.info("Fetch all the genres");
			for (Genre genre : grepository.findAll()) {
				log.info(genre.toString());
			}
			
			log.info("Fetch all the albums");
			for (Album album : arepository.findAll()) {
				log.info(album.toString());
			}
			
			log.info("Fetch all the playlists");
			for (Playlist playlist : prepository.findAll()) {
				log.info(playlist.toString());
			}
			
			log.info("Fetch all the tracks");
			for (Track track : trepository.findAll()) {
				log.info(track.toString());
			}
		};
	}

}
