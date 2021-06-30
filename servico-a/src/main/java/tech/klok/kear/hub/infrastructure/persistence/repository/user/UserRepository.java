package tech.klok.kear.hub.infrastructure.persistence.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.klok.kear.hub.domain.adesao.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE u.username = :username")
    public Optional<UserModel> findByUsername(@Param("username") String username);
}
