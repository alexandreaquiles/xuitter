package br.com.xuitter.xuitter_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Xuit {

    public enum XuitType {
        ORIGINAL, REXUIT, QUOTE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 42)
    private String content;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ORIGINAL', 'REXUIT', 'QUOTE')")
    private XuitType type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_xuit_id")
    private Xuit originalXuit;

    @NotNull
    private LocalDateTime createdAt;

    @Deprecated
    protected Xuit() {
    }

    public Xuit(String content, XuitType type, Xuit originalXuit, User author) {
        this.content = content;
        this.type = type;
        this.originalXuit = originalXuit;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public XuitType getType() {
        return type;
    }

    public User getAuthor() {
        return author;
    }

    public Optional<Xuit> getOriginalXuit() {
        return Optional.ofNullable(originalXuit);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
