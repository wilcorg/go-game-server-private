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
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turn_id_seq")
    @SequenceGenerator(name = "turn_id_seq", allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Long message_id;

    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private GameEntity game_id;

    @OneToOne()
    @JoinColumn(name = "user_rx_id", referencedColumnName = "user_id")
    private UserEntity user_rx_id;

    @OneToOne
    @JoinColumn(name = "user_tx_id", referencedColumnName = "user_id")
    private UserEntity user_tx_id;

    @Column(nullable = false, length = 2137)
    private String text;
}
