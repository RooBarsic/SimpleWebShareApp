package com.company.servingwebcontent.models.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@Getter
@Setter
public class StudentDto {

    @Id
    @JsonProperty("id")
    @Column(name = "id", nullable = false)
    public Long id;

    @JsonProperty("name")
    @Column(name = "name")
    public String name;

    @JsonProperty("average_mark")
    @Column(name = "average_mark")
    public Double averageMark;
}
