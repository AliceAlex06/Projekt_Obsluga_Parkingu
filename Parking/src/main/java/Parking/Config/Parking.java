package Parking.Config;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Parking {
    @Id
    @GeneratedValue
    @Column(name = "idParkowania")
    private int idParkowania;
    @Column(name = "idSamochodu")
    private int idSamochodu;
    @Column(name = "dataParkowania")
    private Date dataParkowania;

    public Parking() {
    }

    public Parking(int idParkowania, int idSamochodu, Date dataParkowania) {
        this.idParkowania = idParkowania;
        this.idSamochodu = idSamochodu;
        this.dataParkowania = dataParkowania;
    }

    public int getIdParkowania() {
        return idParkowania;
    }

    public void setIdParkowania(int idParkowania) {
        this.idParkowania = idParkowania;
    }

    public int getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(int idSamochodu) {
        this.idSamochodu = idSamochodu;
    }

    public Date getDataParkowania() {
        return dataParkowania;
    }

    public void setDataParkowania(Date dataParkowania) {
        this.dataParkowania = dataParkowania;
    }
}
