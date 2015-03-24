package services.domain;

import jpa.Location;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocationAdapter extends XmlAdapter<String, Location> {

    @Override
    public Location unmarshal(String s) throws Exception {
        return null;
    }

    @Override
    public String marshal(Location location) throws Exception {

        return location.getCorridor() + "-" + location.getSide() + "-" + location.getModule();
    }
}
