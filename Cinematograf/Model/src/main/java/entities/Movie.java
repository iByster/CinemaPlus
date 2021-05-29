package entities;

import javax.persistence.Column;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name = "Movies")
public class Movie extends Entity {
    @Column(name = "title", unique = true, nullable = false)
    private String title;
//    @Temporal(TemporalType.TIME)
    @Column(name = "duration", nullable = false, columnDefinition = "varchar(8)")
    private String duration;
    @Column(name = "rating", nullable = false)
    private Integer rating;
    @Column(name = "description")
    private String description;
    @Column(name = "movieType")
    private String movieType;

    public Movie(){}


    public Movie(String title, String duration, Integer rating, String description, String movieType) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.movieType = movieType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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
