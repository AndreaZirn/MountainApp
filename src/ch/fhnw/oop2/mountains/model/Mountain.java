package ch.fhnw.oop2.mountains.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by andreazirn on 17/11/15.
 * Model class for a Mountain
 */

public class Mountain {

    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty hoehe = new SimpleIntegerProperty();
    private final DoubleProperty dominanz = new SimpleDoubleProperty();
    private final DoubleProperty schartenhoehe = new SimpleDoubleProperty();
    private final StringProperty kmBis = new SimpleStringProperty();
    private final StringProperty mBis = new SimpleStringProperty();
    private final StringProperty typ = new SimpleStringProperty();
    private final StringProperty region = new SimpleStringProperty();
    private final StringProperty kanton = new SimpleStringProperty();
    private final StringProperty gebiet = new SimpleStringProperty();
    private final StringProperty bildunterschrift = new SimpleStringProperty();

    public Mountain(String[] line) {
        setName(line[0]);
        setKmBis(line[1]);
        setmBis(line[2]);
        setTyp(line[3]);
        setRegion(line[4]);
        setKanton(line[5]);
        setGebiet(line[6]);
        setBildunterschrift(line[7]);
        setId(Integer.valueOf(line[8]));
        setDominanz(Double.valueOf(line[9]));
        setSchartenhoehe(Double.valueOf(line[10]));
        setHoehe(Integer.valueOf(line[11]));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Mountain mountain = (Mountain) o;

        return getId() == (mountain.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String infoAsLine() {
        return String.join("\t",
                Integer.toString(getId()),
                Integer.toString(getHoehe()),
                getName(),
                Double.toString(getDominanz()),
                Double.toString(getSchartenhoehe()),
                getKmBis(),
                getmBis(),
                getTyp(),
                getRegion(),
                getKanton(),
                getGebiet(),
                getBildunterschrift()
        );
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }
    public int getHoehe() {
        return hoehe.get();
    }

    public IntegerProperty hoeheProperty() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        this.hoehe.set(hoehe);
    }

    public double getDominanz() {
        return dominanz.get();
    }

    public DoubleProperty dominanzProperty() {
        return dominanz;
    }

    public void setDominanz(double dominanz) {
        this.dominanz.set(dominanz);
    }

    public double getSchartenhoehe() {
        return schartenhoehe.get();
    }

    public DoubleProperty schartenhoeheProperty() {
        return schartenhoehe;
    }

    public void setSchartenhoehe(double schartenhoehe) {
        this.schartenhoehe.set(schartenhoehe);
    }

    public String getKmBis() {
        return kmBis.get();
    }

    public StringProperty kmBisProperty() {
        return kmBis;
    }

    public void setKmBis(String kmBis) {
        this.kmBis.set(kmBis);
    }

    public String getmBis() {
        return mBis.get();
    }

    public StringProperty mBisProperty() {
        return mBis;
    }

    public void setmBis(String mBis) {
        this.mBis.set(mBis);
    }

    public String getTyp() {
        return typ.get();
    }

    public StringProperty typProperty() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ.set(typ);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getKanton() {
        return kanton.get();
    }

    public StringProperty kantonProperty() {
        return kanton;
    }

    public void setKanton(String kanton) {
        this.kanton.set(kanton);
    }

    public String getGebiet() {
        return gebiet.get();
    }

    public StringProperty gebietProperty() {
        return gebiet;
    }

    public void setGebiet(String gebiet) {
        this.gebiet.set(gebiet);
    }

    public String getBildunterschrift() {
        return bildunterschrift.get();
    }

    public StringProperty bildunterschriftProperty() {
        return bildunterschrift;
    }

    public void setBildunterschrift(String bildunterschrift) {
        this.bildunterschrift.set(bildunterschrift);
    }
}