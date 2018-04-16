package cz.tul.data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Column(name = "CityName")
    private String CityName;
    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "StateName")
    private String StateName;

    public City(String cityName) {
        CityName = cityName;

    }

    public City() {
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }
}