package com.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



import com.model.Match;

@Service
public class MatchService {


		@Autowired
		MatchDAO matchdaoimpl;
		
		public void add(Match match) {
			matchdaoimpl.addMatch(match);
		}
		
		public Match find(int id) {
			return matchdaoimpl.findMatch(id);
		}
		
		public List<Match> findAll() {
			return matchdaoimpl.findAllMatch();
		}
		
		public boolean update(Match match) {
			return matchdaoimpl.updateMatch(match);
		}
		
		public boolean delete(int id) {
			return matchdaoimpl.deleteMatch(id);
		}

}
