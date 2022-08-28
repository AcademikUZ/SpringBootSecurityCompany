package fan.company.springsecuritycompany.projection;

import fan.company.springsecuritycompany.entity.TechnicalСharacteristics;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = TechnicalСharacteristics.class)
public interface CustomTechnicalCharacteristics {

    public Long getId();

    public String getRAM();

    public String getCPU();

    public String getScreenDiagonal();

    public String getSSD();

    public String getHDD();

    public String getVideoСard();

    public String getColor();

    public double getOgranicheniyaPoVesu();

    public boolean isPodgolovnik();

}
