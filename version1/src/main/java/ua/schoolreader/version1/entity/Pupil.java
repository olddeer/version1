package ua.schoolreader.version1.entity;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

@Entity
public class Pupil  implements UserDetails {
    @Id
    @Column(name = "pupil_id")
    private int pupilId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(Role.USER);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @ManyToOne(fetch =FetchType.EAGER)
  @JoinColumn(name="class_id")
    private Class clas;

    public Pupil() {
    }



    @OneToMany(mappedBy = "pupil")

    private Set<TaskPupil> tasksPupil = new HashSet<>();

    public Pupil(int pupilId, String name, String surname, Integer countStars) {
        this.pupilId = pupilId;

        this.name = name;
        this.surname = surname;
        this.countStars = countStars;
    }

    public Set<TaskPupil> getTasksPupil() {
        return tasksPupil;
    }

    public void setTasksPupil(Set<TaskPupil> tasksPupil) {
        this.tasksPupil = tasksPupil;
    }

    private String name;
    private String surname;
    @Column(name = "count_stars")
    private Integer countStars;
    private String username;
    private String password;

    public Pupil(int pupilId, Class clas, String name, String surname, Integer countStars, String username, String password) {
        this.pupilId = pupilId;
        this.clas = clas;
        this.name = name;
        this.surname = surname;
        this.countStars = countStars;
        this.username = username;
        this.password = password;
    }

    public Class getClas() {
        return clas;
    }

    public void setClas(Class clas) {
        this.clas = clas;
    }


    public int getPupilId() {
        return pupilId;
    }

    public void setPupilId(int pupilId) {
        this.pupilId = pupilId;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public Integer getCountStars() {
        return countStars;
    }

    public void setCountStars(Integer countStars) {
        this.countStars = countStars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return pupilId == pupil.pupilId &&

                Objects.equals(name, pupil.name) &&
                Objects.equals(surname, pupil.surname) &&
                Objects.equals(countStars, pupil.countStars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pupilId,  name, surname, countStars);
    }
}
