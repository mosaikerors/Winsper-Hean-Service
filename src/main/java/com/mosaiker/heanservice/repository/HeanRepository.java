package com.mosaiker.heanservice.repository;

import com.mosaiker.heanservice.entity.Hean;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeanRepository extends MongoRepository<Hean,String> {
  List<Hean> findAllByUId(Long uId);
  List<Hean> findAll();
  void deleteByHId(String hId);
  Hean findByHId(String hId);
  List<Hean> findAllByGeoStrBetween(Long from,Long to);
  List<Hean> findAllByCreatedTimeGreaterThanEqual(Long time);
}
