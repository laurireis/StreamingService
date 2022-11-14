package hh.swd20.musicapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.musicapp.web.TrackController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MusicappApplicationTests {
	
	@Autowired
	private TrackController trackController;
	
	@Test
	public void contextLoads() {
		assertThat(trackController).isNotNull();
	}

}
