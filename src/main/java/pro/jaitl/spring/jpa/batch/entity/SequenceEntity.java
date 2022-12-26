package pro.jaitl.spring.jpa.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sequence_table")
public class SequenceEntity {
  @Id
  @SequenceGenerator(name = "sequence_id_auto_gen", allocationSize = 100)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_auto_gen")
  private Integer id;

  private String name;

  private Instant ts;
}
