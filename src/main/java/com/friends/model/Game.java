package com.friends.model;

import javax.persistence.*;

/**
 * @author David Liebl
 */

@Entity
@Table(name = "game")
public class Game extends AbstractIdEntity{

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id_a")
    private User userA;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id_b")
    private User userB;

    @Column(name = "a_is_drawing", nullable = false)
    private Boolean userAIsDrawing;

    @Column(name = "word", nullable = false)
    private String word;

    @Column(name = "picture", nullable = false)
    private String picture;

    public User getUserA() {
        return userA;
    }

    public void setUserA(User userA) {
        this.userA = userA;
    }

    public User getUserB() {
        return userB;
    }

    public void setUserB(User userB) {
        this.userB = userB;
    }

    public Boolean getUserAIsDrawing() {
        return userAIsDrawing;
    }

    public void setUserAIsDrawing(Boolean userAIsDrawing) {
        this.userAIsDrawing = userAIsDrawing;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
