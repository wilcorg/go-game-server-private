package org.gogame.server.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_list")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Long user_id;


    @Column(length=64, nullable = false, unique = true)
    private String nickname;

    @Column(length=64, nullable = false)
    private String password_hash;

    @Column(length=128, nullable = false, unique = true)
    private String email;

    private java.sql.Timestamp join_date;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_black_id")
    private GameEntity gameEntity1;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_white_id")
    private GameEntity gameEntity2;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_rx_id")
    private MessageEntity messageEntity1;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_tx_id")
    private MessageEntity messageEntity2;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_a_id")
    private UserFriendEntity userFriendEntity1;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_b_id")
    private UserFriendEntity userFriendEntity2;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_sender_id")
    private UserFriendInviteEntity userFriendInviteEntity1;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_receiver_id")
    private UserFriendInviteEntity userFriendInviteEntity2;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_id")
    private LeaderboardEntity leaderboardEntity1;



    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_id")
    private UserLobbyEntity userLobbyEntity1;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_id")
    private UserAvatarEntity userAvatarEntity1;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_sender_id")
    private UserPlayInviteEntity userPlayInviteEntity1;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user_receiver_id")
    private UserPlayInviteEntity userPlayInviteEntity2;
}
