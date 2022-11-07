package hh.swd20.musicapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.musicapp.domain.Album;
import hh.swd20.musicapp.domain.AlbumRepository;
import hh.swd20.musicapp.domain.Genre;
import hh.swd20.musicapp.domain.GenreRepository;
import hh.swd20.musicapp.domain.PlaylistRepository;
import hh.swd20.musicapp.domain.Track;
import hh.swd20.musicapp.domain.TrackRepository;

@Controller
public class TrackController {
	
	@Autowired
	private TrackRepository trepository;
	
	@Autowired
	private AlbumRepository arepository;
	
	@Autowired
	private GenreRepository grepository;
	
	@Autowired
	private PlaylistRepository prepository;
	
	// Show all tracks
	@GetMapping(value = {"/", "/tracklist"})
	public String trackList(Model model) {
		model.addAttribute("tracks", trepository.findAll());
		return "tracklist";
	}
	
	// Add a new track
	@GetMapping(value = "/addtrack")
	public String addTrack(Model model) {
		model.addAttribute("track", new Track());
		model.addAttribute("albums", arepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		model.addAttribute("playlists", prepository.findAll());
		return "addtrack";
	}
	
	// Save the new track
	@PostMapping(value = "/savetrack")
	public String saveTrack(Track track) {
		trepository.save(track);
		return "redirect:tracklist";
	}
	
	// Add a new album
	@GetMapping(value = "/addalbum")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
		return "addalbum";
	}
	
	// Save the new album
	@PostMapping(value = "/savealbum")
	public String saveAlbum(Album album) {
		arepository.save(album);
		return "redirect:tracklist";
	}
	
	// Add a new genre
	@GetMapping(value = "/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	// Save the new genre
	@PostMapping(value = "/savegenre")
	public String saveGenre(Genre genre) {
		grepository.save(genre);
		return "redirect:tracklist";
	}
	
	// Delete a track
	@GetMapping(value = "/deletetrack/{id}")
	public String deleteTrack(@PathVariable("id") Long trackId, Model model) {
		trepository.deleteById(trackId);
		return "redirect:../tracklist";
	}
	
	// Edit a track
	@GetMapping(value = "/edittrack/{id}")
	public String editTrack(@PathVariable("id") Long trackId, Model model) {
		model.addAttribute("track", trepository.findById(trackId));
		model.addAttribute("albums", arepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		model.addAttribute("playlists", prepository.findAll());
		return "edittrack";
	}
	
}
