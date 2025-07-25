package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.voll.api.model.person.User;

public interface UserResp extends JpaRepository<User, Long> {

    UserDetails findByLogin(String username);
    
}
