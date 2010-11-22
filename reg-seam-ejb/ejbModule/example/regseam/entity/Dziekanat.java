package example.regseam.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Dziekanat extends Osoba {
private static final long serialVersionUID = 1L;
}
