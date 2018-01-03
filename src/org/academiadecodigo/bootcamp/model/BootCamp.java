package org.academiadecodigo.bootcamp.model;

import java.util.*;

public class BootCamp {
    private int id;
    private String location;
    private Date start;
    private Date end;
    private Set<CodeCadet> cadets = new HashSet<>();

    public BootCamp(int id, String location, Date start, Date end) {
        this.id = id;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public void addCaddet(CodeCadet cadet){
        cadets.add(cadet);
    }

    public List<CodeCadet> findAllCodeCadets(){
        return new LinkedList<>(cadets);
    }



    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
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
}
