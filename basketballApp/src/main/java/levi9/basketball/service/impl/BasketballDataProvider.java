package levi9.basketball.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import levi9.basketball.model.AllDataPlayer;
import levi9.basketball.model.Player;
import levi9.basketball.model.Players;
import levi9.basketball.model.Stats;
import levi9.basketball.model.Team;
import levi9.basketball.service.PlayerService;
import levi9.basketball.service.StatsService;
import levi9.basketball.service.TeamService;

@Transactional
@Service
public class BasketballDataProvider {
	private Map<String, Object> cachedResources = new HashMap<String, Object>();

	private Long count = 1L;
	private Long countTeam = 1L;

	@Autowired
	PlayerService playerService;

	@Autowired
	TeamService teamService;

	@Autowired
	StatsService statsService;

	@SuppressWarnings("unused")
	public ArrayList<Stats> parseJson() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Players players = mapper.readValue(new File("src/main/resources/stats.json"), Players.class);

		ArrayList<AllDataPlayer> nova = players.getPlayers();

		Player player = new Player();
		Stats stats = new Stats();
		Team team = new Team();
		ArrayList<Stats> sta = new ArrayList();

		for (AllDataPlayer p : nova) {

			team.setId(countTeam++);
			team.setTeam(p.getTeam());
			player.setStats(count);
			stats.setId(count++);
			stats.setAsts(p.getAsts());
			stats.setBlk(p.getBlk());
			stats.setDreb(p.getDreb());
			stats.setFga(p.getFga());
			stats.setFgm(p.getFgm());
			stats.setFta(p.getFta());
			stats.setFtm(p.getFtm());
			stats.setGp(p.getGp());
			stats.setMin(p.getMin());
			stats.setOreb(p.getOreb());
			stats.setPf(p.getPf());
			stats.setPts(p.getPts());
			stats.setReb(p.getReb());
			stats.setStl(p.getStl());
			stats.setTo(p.getTo());
			stats.setTpa(p.getTpa());
			stats.setTpm(p.getTpm());

			player.setId(p.getId());
			player.setFirstname(p.getFirstname());
			player.setLastname(p.getLastname());
			ArrayList<String> po = new ArrayList();
			po = p.getPos();

			// PRVA POZICIJA
			player.setPos1(po.get(0));

			// DRUGA POZICIJA
			if (po.size() > 1) {
				player.setPos2(po.get(1));
			}

			player.setLeag(p.getLeag());
			player.setYear(p.getYear());
			player.setTeam(p.getTeam());
			teamService.save(team);
			statsService.save(stats);
			playerService.save(player);
		}

		return sta;
	}

	// Convert Json to Obj
	@PostConstruct
	private void initializeData() throws Exception {
		cachedResources.put("players", loadPlayers());
		cachedResources.put("stats", loadStats());
	}

	private Object loadPlayers() throws Exception {
		try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("players.json")) {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(input, Object.class);
		} catch (IOException e) {
			throw new Exception();
		}
	}

	private Object loadStats() throws Exception {
		try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("stats.json")) {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(input, Object.class);
		} catch (IOException e) {
			throw new Exception();
		}
	}

	public Object getPlayers() {
		return cachedResources.get("players");
	}

	public Object getStats() {
		return cachedResources.get("stats");
	}
}
