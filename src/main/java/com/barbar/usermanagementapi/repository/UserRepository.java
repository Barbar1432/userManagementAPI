package com.barbar.usermanagementapi.repository;
import com.barbar.usermanagementapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    // The UserRepository interface extends JpaRepository to provide CRUD operations and more for User entities

}
