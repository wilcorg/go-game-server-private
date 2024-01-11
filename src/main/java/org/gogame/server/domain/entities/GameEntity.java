package org.gogame.server.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    @SequenceGenerator(name = "game_id_seq", allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Long game_id;

    private Long winner_id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game_id")
    private GameJournalEntity gameJournalEntity1;


    @OneToOne()
    @JoinColumn(name = "user_black_id", referencedColumnName = "user_id")
    private UserEntity user_black_id;

    @OneToOne
    @JoinColumn(name = "user_white_id", referencedColumnName = "user_id")
    private UserEntity user_white_id;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game_id")
    private MessageEntity messageEntity1;
}
