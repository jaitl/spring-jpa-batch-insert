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
    public void test1() {
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

    @Test
    public void test2() {
        for (int k = 0; k < 10; k += 1) {
            List<SequenceEntity> sequenceEntities = new ArrayList<>();
            for (int i = 0; i < 100; i += 1) {
                SequenceEntity entity = new SequenceEntity();
                entity.setName("Test identity number: " + (k + i));
                entity.setTs(Instant.now());
                sequenceEntities.add(entity);
            }
            repository.saveAll(sequenceEntities);
        }
        assertEquals(1000, repository.count());
    }

    @Test
    public void test3() {
        for (int k = 0; k < 20; k += 1) {
            List<SequenceEntity> sequenceEntities = new ArrayList<>();
            for (int i = 0; i < 50; i += 1) {
                SequenceEntity entity = new SequenceEntity();
                entity.setName("Test identity number: " + (k + i));
                entity.setTs(Instant.now());
                sequenceEntities.add(entity);
            }
            repository.saveAll(sequenceEntities);
        }
        assertEquals(1000, repository.count());
    }

    @Test
    public void test4() {
        long size = 1000;
        for (int i = 0; i < size; i += 1) {
            SequenceEntity entity = new SequenceEntity();
            entity.setName("Test identity number: " + i);
            entity.setTs(Instant.now());
            repository.save(entity);
        }
        assertEquals(size, repository.count());
    }
}
