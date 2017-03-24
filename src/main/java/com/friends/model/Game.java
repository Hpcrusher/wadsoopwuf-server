package com.friends.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author David Liebl
 */

@Entity
@Table(name = "game")
public class Game extends AbstractIdEntity{

    @Column(name = "user_a", nullable = false)
    @Type(type = "com.friends.repository.converter.UuidType")
    private User userA;

    @Column(name = "user_b", nullable = false)
    @Type(type = "com.friends.repository.converter.UuidType")
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
