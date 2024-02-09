package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.V_annonceStatus;
import java.util.List;

@Repository
public interface V_annonceRepository extends JpaRepository<V_annonceStatus, Integer> {
  
    @Query("SELECT v FROM V_annonceStatus v WHERE v.states = :statu")
    List<V_annonceStatus> findByStatu(@Param("statu") int statu);

    @Query("SELECT v FROM V_annonceStatus v WHERE v.id_user = :id")
    List<V_annonceStatus> findHistorique(@Param("id") int id);

    //@Query("SELECT v FROM V_annonceStatus v WHERE v.id_user in (select id_user from favoris) and v.id_user=:id")
    @Query("SELECT v FROM V_annonceStatus v WHERE v.id_user in (select id_user from Favoris) and v.id_user=:id")
    List<V_annonceStatus> findListFavoris(@Param("id") int id_user);

    @Query("SELECT v FROM V_annonceStatus v WHERE v.prix between :prix1 and :prix2")
    List<V_annonceStatus> findPrice(@Param("prix1") double prix1,@Param("prix2") double prix2);

    @Query("SELECT v FROM V_annonceStatus v WHERE v.marque like :marque")
    List<V_annonceStatus> findMarque(@Param("marque") String marque);

    @Query("SELECT v FROM V_annonceStatus v WHERE v.marque like :marque and v.prix between :prix1 and :prix2")
    List<V_annonceStatus> findMarquePrix(@Param("marque") String marque,@Param("prix1") double prix1,@Param("prix2") double prix2);

}

