package com.friends.repository;

import com.friends.model.Game;
import com.friends.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author David Liebl
 */

@Repository
public interface GameRepository extends JpaRepository<Game, UUID>, JpaSpecificationExecutor<Game> {

    List<Game> findByUserAAndUserAIsDrawing(User userA, boolean userAIsDrawing);

    List<Game> findByUserBAndUserAIsDrawing(User user, boolean userAIsDrawing);
}
