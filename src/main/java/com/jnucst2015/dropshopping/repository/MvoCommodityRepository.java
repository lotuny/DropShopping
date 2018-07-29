package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MvoCommodityRepository extends JpaRepository<MvoCommodity, Integer>
{/*
    @Query("SELECT c FROM MvoCommodity c WHERE c.company_id = ?1")
    List<MvoCommodity> getMvoCommoditiesByCompany_idIs(Integer company_id);*/

    @Query(value = "SELECT * FROM mvo_commodity c WHERE c.name LIKE CONCAT('%',:keyName,'%')",nativeQuery=true)
    List<MvoCommodity> LIKEquery(@Param("keyName") String keyName);


    @Query(value = "SELECT * FROM mvo_commodity c WHERE c.company_id = ?1", nativeQuery = true)
    List<MvoCommodity> findMvoCommoditiesByCompany_idIs(Integer company_id);


    @Query(value = "SELECT * FROM mvo_commodity ORDER BY creation_time DESC LIMIT ?1", nativeQuery = true)
    List<MvoCommodity> getMvoCommoditiesRecently(Integer count);

    @Query(value = "SELECT * FROM mvo_commodity WHERE id = ?1 AND company_id = ?2", nativeQuery = true)
    MvoCommodity getMvoCommoditiesByIdIsAndCompany_idIs(Integer id, Integer company_id);
}
