package com.codewithkv.springbootjpa.Repository;

import com.codewithkv.springbootjpa.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {

    @Query("FROM AppUser p where p.username=:username AND p.password=:password")
    AppUser findUser(@Param("username") String username , @Param("password") String password);



}
