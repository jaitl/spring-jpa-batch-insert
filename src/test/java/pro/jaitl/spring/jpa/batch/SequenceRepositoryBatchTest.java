package pro.jaitl.spring.jpa.batch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.jaitl.spring.jpa.batch.entity.SequenceEntity;
import pro.jaitl.spring.jpa.batch.repository.SequenceRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SequenceRepositoryBatchTest {

  @Autowired
  private SequenceRepository repository;

  @Test
  public void test() {
    long size = 1000;
    List<SequenceEntity> sequenceEntities = new ArrayList<>();

    for (int i = 0; i < size; i += 1) {
      SequenceEntity entity = new SequenceEntity();
      entity.setName("Test identity number: " + i);
      entity.setTs(Instant.now());
      sequenceEntities.add(entity);
    }

    repository.saveAll(sequenceEntities);
    assertEquals(size, repository.count());
  }
}
