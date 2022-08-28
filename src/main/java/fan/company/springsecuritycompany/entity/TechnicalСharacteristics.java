package fan.company.springsecuritycompany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechnicalСharacteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String RAM;

    private String CPU;

    private String screenDiagonal;

    private String SSD;

    private String HDD;

    private String videoСard;

    private String color;

    private double ogranicheniyaPoVesu;

    private boolean podgolovnik;

}
