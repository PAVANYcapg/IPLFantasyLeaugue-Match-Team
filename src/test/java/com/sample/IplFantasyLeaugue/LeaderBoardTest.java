package com.sample.IplFantasyLeaugue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.LeaderBoardService;
import com.model.Bidder;
import com.model.LeaderBoard;

import junit.framework.Assert;
@SpringBootTest
class LeaderBoardTest {

	@Autowired
	LeaderBoardService leaderBoardService;
	
	@Test
	void testAdd() {
		LeaderBoard leaderBoard = new LeaderBoard();
		leaderBoard.setBidsParticipated(1);
		leaderBoard.setBidsWon(10);
		leaderBoard.setBidsLost(5);
		leaderBoard.setPercentile(65.2);
		leaderBoard.setBidder_ranking(1);
		leaderBoardService.add(leaderBoard);

		LeaderBoard to_be_tested = leaderBoardService.findItem(leaderBoard.getBidderId());
		Assert.assertEquals(1, to_be_tested.getBidsParticipated());


	}

	@Test
	void testFindItem() {
		LeaderBoard leaderBoard1 = new LeaderBoard();
		leaderBoard1.setBidsParticipated(2);
		leaderBoard1.setBidsWon(11);
		leaderBoard1.setBidsLost(5);
		leaderBoard1.setPercentile(67.2);
		leaderBoard1.setBidder_ranking(2);
		leaderBoardService.add(leaderBoard1);
		
		LeaderBoard to_be_tested =leaderBoardService.findItem(leaderBoard1.getBidderId()); 
		Assert.assertEquals(2, to_be_tested.getBidsParticipated());
	}

	@Test
	void testFindAllTeam() {
		LeaderBoard leaderBoard2 = new LeaderBoard();
		leaderBoard2.setBidsParticipated(5);
		leaderBoard2.setBidsWon(15);
		leaderBoard2.setBidsLost(8);
		leaderBoard2.setPercentile(75.2);
		leaderBoard2.setBidder_ranking(5);
		leaderBoardService.add(leaderBoard2);
		List<LeaderBoard>leaderBoardlist = leaderBoardService.findAllTeam();
		Assert.assertEquals(2, leaderBoardlist.size());

	}

	@Test
	void testUpdate() {
		LeaderBoard leaderBoard4 = new LeaderBoard();
		leaderBoard4.setBidsParticipated(5);
		leaderBoard4.setBidsWon(15);
		leaderBoard4.setBidsLost(8);
		leaderBoard4.setPercentile(75.2);
		leaderBoard4.setBidder_ranking(5);
		leaderBoardService.add(leaderBoard4);
		leaderBoard4.setBidderId(3);
		leaderBoardService.update(leaderBoard4);
		
	
		Assert.assertEquals(true,leaderBoardService.update(leaderBoard4) );
		}

	@Test
	void testDelete() {
		
		LeaderBoard leaderboard5=leaderBoardService.findItem(1);
		leaderBoardService.delete(leaderboard5.getBidderId());
		LeaderBoard leaderBoard6 = leaderBoardService.findItem(1);
       Assert.assertNull(leaderBoard6);
	}

}
