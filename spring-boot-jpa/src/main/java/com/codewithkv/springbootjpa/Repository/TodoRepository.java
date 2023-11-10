package com.codewithkv.springbootjpa.Repository;

import com.codewithkv.springbootjpa.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
