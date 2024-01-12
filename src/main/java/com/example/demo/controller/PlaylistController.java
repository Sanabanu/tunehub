package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class PlaylistController {
	  @Autowired
	  SongService songService;
	  @Autowired
	  PlaylistService playlistService;
      @GetMapping("/createPlaylist")
      public String createPlaylist(Model model) {
    	  
    	 List<Song> songList =songService.fetchAllSongs();
    	 model.addAttribute("songs", songList);
          return "createPlaylist";
      }
      @PostMapping("/addPlaylist")
      public String addPlaylist(@ModelAttribute Playlist playlist) {

          playlistService.addPlaylist(playlist);
          return "adminHome";
      }
      
      
}
