package com.qa.cne2022.persistance.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.cne2022.persistance.domain.Movie;


public interface MovieRepository extends JpaRepository  <Movie, Long> {

}
