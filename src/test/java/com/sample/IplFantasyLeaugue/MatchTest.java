package com.sample.IplFantasyLeaugue;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.MatchService;
import com.model.Match;

import junit.framework.Assert;

@SpringBootTest
class MatchTest {
	
	@Autowired
	MatchService matchservice;

	@Test
	void testAdd() {
		Match match = new Match();
		match.setTeamOne("RCB");
		match.setTeamTwo("CSK");
		String str="2022-03-04";
		Date d = Date.valueOf(str);
		match.setDate(d);
		match.setStadium("chinaswamy stadium");
		match.setWinner("RCB");
		matchservice.add(match);
		
		Match match_to_be_tested = matchservice.find(match.getMatchid());
		Assert.assertEquals("RCB", match_to_be_tested.getTeamOne());

	}

	@Test
	void testFind() {
		Match match1 = new Match();
		match1.setTeamOne("SRH");
		match1.setTeamTwo("DC");
		String str1="2022-11-06";
		Date d2 = Date.valueOf(str1);
		match1.setDate(d2);
		match1.setStadium("Rajiv gandhi stadium");
		match1.setWinner("DC");
		matchservice.add(match1);
		
		Match match_to_be_tested = matchservice.find(match1.getMatchid());
		Assert.assertEquals("SRH", match_to_be_tested.getTeamOne());
	
	}

	@Test
	void testFindAll() {
		Match match2 = new Match();
		match2.setTeamOne("LSG");
		match2.setTeamTwo("GT");
		String str2="2022-11-08";
		Date d3 = Date.valueOf(str2);
		match2.setDate(d3);
		match2.setStadium("Wankede stadium");
		match2.setWinner("Gt");
		matchservice.add(match2);
		
		Match match3 = new Match();
		match3.setTeamOne("RR");
		match3.setTeamTwo("KKR");
		String str3="2022-12-09";
		Date d4 = Date.valueOf(str3);
		match3.setDate(d4);
		match3.setStadium("Narendra modi stadium");
		match3.setWinner("RR");
		matchservice.add(match3);
		
		List<Match> matchList = matchservice.findAll();
		Assert.assertEquals(matchList.get(1).getTeamOne(),"LSG");
	}

	@Test
	void testUpdate() {
		Match match4 = new Match();
		match4.setTeamOne("MI");
		match4.setTeamTwo("KKR");
		String str4="2022-05-09";
		Date d5 = Date.valueOf(str4);
		match4.setDate(d5);
		match4.setStadium("Brabourne stadium");
		match4.setWinner("MI");
		matchservice.add(match4);
		match4.setMatchid(3);
		matchservice.update(match4);
		
		Assert.assertEquals(true, matchservice.update(match4));
	}

	@Test
	void testDelete() {
		Match match5 = matchservice.find(1);
		matchservice.delete(1);
		
		Match match6 = matchservice.find(1);
		Assert.assertNull(match6);
	}
}
