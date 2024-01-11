package org.gogame.server.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "leaderboard")
public class LeaderboardEntity {

    @Id
    @SequenceGenerator(name = "leaderboard_id_seq", allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Long user_pos;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user_id;

    @Range(min = 0)
    @ColumnDefault("0")
    private Long score;
}
