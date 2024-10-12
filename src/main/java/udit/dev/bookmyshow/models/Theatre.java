package udit.dev.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;

    @ManyToOne
    private City city;

    private String address;

    @OneToMany
    private List<Screen> screens;
}

/*

   1          1
Theatre ---- City => M:1
   M          1

   1           M
Theatre ---- Screen => 1:M
  1             1


 */