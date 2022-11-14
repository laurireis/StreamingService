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
import hh.swd20.musicapp.domain.User;
import hh.swd20.musicapp.domain.UserRepository;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MusicappApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MusicappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicappApplication.class, args);
	}
	
	SimpleDateFormat fdate = new SimpleDateFormat("dd.MM.yyyy");
	
	@Bean
	public CommandLineRunner musicDemo(TrackRepository trepository, AlbumRepository arepository, GenreRepository grepository, PlaylistRepository prepository, UserRepository urepository) {
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
			Album album1 = new Album("TesseracT", "Polaris", fdate.parse("18.9.2015"));
			Album album2 = new Album("Polyphia", "Remember That You Will Die", fdate.parse("28.10.2022"));
			Album album3 = new Album("Matti ja Teppo", "Pidä itsestäsi huolta", fdate.parse("1.1.1982"));
			Album album4 = new Album("Kendrick Lamar", "good kid, m.A.A.d city", fdate.parse("22.10.2012"));
			Album album5 = new Album("Louie Blue", "Notes", fdate.parse("24.1.2020"));
			Album album6 = new Album("Plini", "Impulse Voices", fdate.parse("27.11.2020"));
			Album album7 = new Album("Northlane", "Alien", fdate.parse("2.8.2019"));
			Album album8 = new Album("Gorillaz", "Humanz", fdate.parse("28.4.2017"));
			arepository.save(album1);
			arepository.save(album2);
			arepository.save(album3);
			arepository.save(album4);
			arepository.save(album5);
			arepository.save(album6);
			arepository.save(album7);
			arepository.save(album8);
			
			log.info("Create a few playlists");
			Playlist playlist1 = new Playlist("Progressive Metal", "https://cms.kerrang.com/images/2021/03/13-essential-progressive-metal-albums-header.jpg");
			Playlist playlist2 = new Playlist("Iskelmä", "https://i.media.fi/incoming/q83i0r-2194169.JPG/alternates/FREE_1440/2194169.JPG");
			prepository.save(playlist1);
			prepository.save(playlist2);
			
			log.info("Create a few tracks");
			Track track1 = new Track("TesseracT", "Dystopia", "https://www.youtube.com/watch?v=lR5amOOvpwQ", genre3, album1, playlist1);
			Track track2 = new Track("Polyphia", "Chimera", "https://www.youtube.com/watch?v=_L5FLJ1H_Lk", genre3, album2, playlist1);
			Track track3 = new Track("Matti ja Teppo", "Mä joka päivä töitä teen", "https://www.youtube.com/watch?v=1-YiaQZz1zY", genre2, album3, playlist2);
			Track track4 = new Track("Kendrick Lamar", "good kid", "https://www.youtube.com/watch?v=dxkohu0iZPk", genre4, album4, null);
			Track track5 = new Track("Louie Blue", "Down the Road", "https://www.youtube.com/watch?v=QyR8zjWCn_U", genre2, album5, null);
			Track track6 = new Track("Plini", "The Glass Bead Game", "https://www.youtube.com/watch?v=V8IVroLfizI", genre3, album6, playlist1);
			Track track7 = new Track("Northlane", "Bloodline", "https://www.youtube.com/watch?v=jGba1gDibw4", genre3, album7, playlist1);
			Track track8 = new Track("Gorillaz", "Saturnz Barz", "https://www.youtube.com/watch?v=5qJp6xlKEug", genre1, album8, null);
			Track track9 = new Track("Tesseract", "Cages", "https://www.youtube.com/watch?v=MgcK1shEQPE", genre3, album1, playlist1);
			Track track10 = new Track("Plini", "Pan", "https://www.youtube.com/watch?v=tIBVpDWPnAI", genre3, album6, playlist1);
			trepository.save(track1);
			trepository.save(track2);
			trepository.save(track3);
			trepository.save(track4);
			trepository.save(track5);
			trepository.save(track6);
			trepository.save(track7);
			trepository.save(track8);
			trepository.save(track9);
			trepository.save(track10);
			
			// Create users admin/admin and user/user
			User user1 = new User("user", "$2a$10$xDSOHxQuLo4syde/Xy9aMOBoUxFVuzTTzbndyL1Jm27G/9qM6rp9m", "USER");
			User user2 = new User("admin", "$2a$10$6TyLJ3vgERNGGhoWKbzrxOiUF/vlFt5PE62DiF.2qvfEx8UfhwW0u", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
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