package pro.jaitl.spring.jpa.batch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.jaitl.spring.jpa.batch.entity.IdentityEntity;
import pro.jaitl.spring.jpa.batch.repository.IdentityRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IdentityRepositoryBatchTest {

  @Autowired
  private IdentityRepository repository;

  @Test
  public void test() {
    long size = 1000;
    List<IdentityEntity> identityEntities = new ArrayList<>();

    for (int i = 0; i < size; i += 1) {
      IdentityEntity entity = new IdentityEntity();
      entity.setName("Test identity number: " + i);
      entity.setTs(Instant.now());
      identityEntities.add(entity);
    }

    repository.saveAll(identityEntities);
    assertEquals(size, repository.count());
  }
}
