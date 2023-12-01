package model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
@Data
@Entity
@Table(name = "Winery")
@NoArgsConstructor
@AllArgsConstructor
public class Winery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "Winery must have a name")
    @Column(unique = true)
    private String wineryName;

    private Long longitude;

    private Long latitude;

}
