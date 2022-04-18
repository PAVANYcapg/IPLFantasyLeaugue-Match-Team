package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.model.Match;

@Repository
public interface MatchDAO {
	
	public void addMatch(Match match);
	public Match findMatch(int id);
	public List<Match> findAllMatch();
	public boolean updateMatch(Match match);
	public boolean deleteMatch(int id);
	
}
