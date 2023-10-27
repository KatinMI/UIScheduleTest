package com.test.model;

import java.util.Objects;

/**
 * Data class for lecture
 */
public class Lecture {
    private String name;
    private String lecturer;
    private String auditorium;
    private String type;

    public Lecture(String name, String lecturer, String auditorium, String type) {
        this.name = name;
        this.lecturer = lecturer;
        this.auditorium = auditorium;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(name, lecture.name) && Objects.equals(lecturer, lecture.lecturer) && Objects.equals(auditorium, lecture.auditorium) && Objects.equals(type, lecture.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lecturer, auditorium, type);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + name + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", auditorium='" + auditorium + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
