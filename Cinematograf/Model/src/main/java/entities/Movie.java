package entities;

import java.time.LocalTime;

public class Movie extends Entity<Long> {
    private String title;
    private LocalTime duration;
    private Integer rating;
    private String description;

    public Movie(String title, LocalTime duration, Integer rating, String description) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
