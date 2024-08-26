package com.moiso.repository;

import com.moiso.entity.Announce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnounceRepository extends JpaRepository<Announce,Long> {

    @Query("SELECT a FROM Announce a WHERE a.title LIKE %:title%")
    List<Announce> findByTitle(@Param("title") String title);
}
