package com.farm.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "goats")
public class Goat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_id", unique = true, nullable = false)
    private String tagId;

    @Column(nullable = false)
    private String gender; // DOE/BUCK/DOELING/BUCKLING

    private LocalDate dateOfBirth;

    private String color;

    private String photoUrl;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Double> breedComposition; // {"Boer": 90.0, "Barbari": 10.0}

    private Integer generationIndex; // 1..N

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sire_id")
    private Goat sire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dam_id")
    private Goat dam;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTagId() { return tagId; }
    public void setTagId(String tagId) { this.tagId = tagId; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public Map<String, Double> getBreedComposition() { return breedComposition; }
    public void setBreedComposition(Map<String, Double> breedComposition) { this.breedComposition = breedComposition; }
    public Integer getGenerationIndex() { return generationIndex; }
    public void setGenerationIndex(Integer generationIndex) { this.generationIndex = generationIndex; }
    public Goat getSire() { return sire; }
    public void setSire(Goat sire) { this.sire = sire; }
    public Goat getDam() { return dam; }
    public void setDam(Goat dam) { this.dam = dam; }
}
