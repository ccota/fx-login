package org.academiadecodigo.bootcamp.model;

import java.text.SimpleDateFormat;
import java.util.*;

public class BootCamp {
    private int id;
    private String location;
    private Calendar start;
    private Calendar end;
    private Set<CodeCadet> cadets = new HashSet<>();

    public BootCamp(int id, String location, Calendar start, Calendar end) {
        this.id = id;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public void addCaddet(CodeCadet cadet){
        cadets.add(cadet);
    }

    public Set<CodeCadet> getCadets() {
        return cadets;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Calendar getStart() {
        return start;
    }

    public Calendar getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "BootCamp{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", cadets=" + cadets +
                '}';
    }

    public void removeCadet(CodeCadet codeCadet) {
        cadets.remove(codeCadet);
    }
}
