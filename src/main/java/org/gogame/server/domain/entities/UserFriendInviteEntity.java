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
@Table(name = "user_friend_invite")
public class UserFriendInviteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friend_inv_id_seq")
    @SequenceGenerator(name = "friend_inv_id_seq", allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Long friend_invite_id;

    @OneToOne()
    @JoinColumn(name = "user_sender_id", referencedColumnName = "user_id")
    private UserEntity user_sender_id;

    @OneToOne
    @JoinColumn(name = "user_receiver_id", referencedColumnName = "user_id")
    private UserEntity user_receiver_id;
}
