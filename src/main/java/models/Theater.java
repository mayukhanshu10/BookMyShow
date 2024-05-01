package models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String nameTheater;
    private Region region;
    List<Screen> screens;
}
