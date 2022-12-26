package pro.jaitl.spring.jpa.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.jaitl.spring.jpa.batch.entity.SequenceEntity;

@Repository
public interface SequenceRepository extends JpaRepository<SequenceEntity, Integer> {
}
