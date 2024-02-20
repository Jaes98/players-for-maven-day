package dat3.players.repository;

import dat3.players.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository.save(new Player("Lamar Jackson", "USA", "Quarterback"));
        playerRepository.save(new Player("Patrick Mahomes", "USA", "Quarterback"));
        playerRepository.save(new Player("Josh Allen", "USA", "Quarterback"));
    }
    @Test
    public void testAllPlayers() {
        assertEquals(3, playerRepository.count());
    }
    @Test
    public void testAddPlayer() {
        Player pNew = new Player("Jason Kelce", "USA", "Center");
        playerRepository.save(pNew);
        System.out.println(pNew);
        assertTrue(pNew.getId()>0);
    }

    public void alwaysFail() {
        assertTrue(false);
    }
}