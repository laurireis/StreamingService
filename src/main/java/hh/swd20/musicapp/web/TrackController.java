package hh.swd20.musicapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.musicapp.domain.Album;
import hh.swd20.musicapp.domain.AlbumRepository;
import hh.swd20.musicapp.domain.Genre;
import hh.swd20.musicapp.domain.GenreRepository;
import hh.swd20.musicapp.domain.Playlist;
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
	
	// Homepage
	@GetMapping(value = "/homepage")
	public String homepage(Model model) {
		model.addAttribute("playlists", prepository.findAll());
		return "homepage";
	}
	
	// Show all tracks
	@GetMapping(value = {"", "/tracklist"})
	public String trackList(Model model) {
		model.addAttribute("tracks", trepository.findAll());
		return "tracklist";
	}
	
	// Add a new track
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addtrack")
	public String addTrack(Model model) {
		model.addAttribute("track", new Track());
		model.addAttribute("albums", arepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		model.addAttribute("playlists", prepository.findAll());
		return "addtrack";
	}
	
	// Save the new track
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/savetrack")
	public String saveTrack(Track track) {
		trepository.save(track);
		return "redirect:tracklist";
	}
	
	// Add a new album
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addalbum")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
		return "addalbum";
	}
	
	// Save the new album
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/savealbum")
	public String saveAlbum(Album album) {
		arepository.save(album);
		return "redirect:tracklist";
	}
	
	// Add a new genre
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	// Save the new genre
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/savegenre")
	public String saveGenre(Genre genre) {
		grepository.save(genre);
		return "redirect:tracklist";
	}
	
	// Add a new playlist
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addplaylist")
	public String addPlaylist(Model model) {
		model.addAttribute("playlist", new Playlist());
		return "addplaylist";
	}
	
	// Save the new playlist
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/saveplaylist")
	public String savePlaylist(Playlist playlist) {
		prepository.save(playlist);
		return "redirect:tracklist";
	}
	
	// Delete a track
	@GetMapping(value = "/deletetrack/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTrack(@PathVariable("id") Long trackId, Model model) {
		trepository.deleteById(trackId);
		return "redirect:../tracklist";
	}
	
	// Edit a track
	@GetMapping(value = "/edittrack/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editTrack(@PathVariable("id") Long trackId, Model model) {
		model.addAttribute("track", trepository.findById(trackId));
		model.addAttribute("albums", arepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		model.addAttribute("playlists", prepository.findAll());
		return "edittrack";
	}
	
	/*// Show a certain playlist
	@GetMapping(value = "/playlist/{id}")
	public String showPlaylist(@PathVariable("id") Long playlistId, Model model) {
		model.addAttribute("tracks", trepository.findById(playlistId));
		return "playlist";
	}*/
	
	
	/*
	 * REST-methods
	 */
	
	// Show all tracks
	@GetMapping(value = "/tracks")
	public @ResponseBody List<Track> trackListRest() {
		return (List<Track>) trepository.findAll();
	}
	
	// Show a track by it's id
	@GetMapping(value = "/tracks/{id}")
	public @ResponseBody Optional<Track> findTrackRest(@PathVariable("id") Long trackId) {
		return trepository.findById(trackId);
	}
	
	// Show all albums
	@GetMapping(value = "/albums")
	public @ResponseBody List<Album> albumListRest() {
		return (List<Album>) arepository.findAll();
	}
	
	// Show an album by it's id
	@GetMapping(value = "/albums/{id}")
	public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("id") Long albumId) {
		return arepository.findById(albumId);
	}
	
	// Show all genres
	@GetMapping(value = "/genres")
	public @ResponseBody List<Genre> genreListRest() {
		return (List<Genre>) grepository.findAll();
	}
	
	// Show a genre by it's id
	@GetMapping(value = "/genres/{id}")
	public @ResponseBody Optional<Genre> findGenreRest(@PathVariable("id") Long genreId) {
		return grepository.findById(genreId);
	}
	
	// Show all playlists
	@GetMapping(value = "/playlists")
	public @ResponseBody List<Playlist> playlistsRest() {
		return (List<Playlist>) prepository.findAll();
	}
	
	// Show a playlist by it's id
	@GetMapping(value = "/playlists/{id}")
	public @ResponseBody Optional<Playlist> findPlaylistRest(@PathVariable("id") Long playlistId) {
		return prepository.findById(playlistId);
	}
	
}