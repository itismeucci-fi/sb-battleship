package it.itismeucci.battleship.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldController {

	@GetMapping("/api/popola-griglie")
	public Map<String, List<Integer>> popolaGriglie() {
		Map<String, List<Integer>> griglie = new HashMap<>();
		griglie.put("player", generaPosizioniCasuali());
		griglie.put("computer", generaPosizioniCasuali());
		return griglie;
	}

	private List<Integer> generaPosizioniCasuali() {
		Random random = new Random();
		Set<Integer> posizioni = new HashSet<>();

		while (posizioni.size() < 10) { // per esempio 10 navi
			posizioni.add(random.nextInt(100)); // 0..99 per 10x10
		}

		return new ArrayList<>(posizioni);
	}

}
