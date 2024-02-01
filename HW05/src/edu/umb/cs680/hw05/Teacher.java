package edu.umb.cs680.hw05;

public class Teacher implements Observer<String> {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(edu.umb.cs680.hw05.Observable<String> sender, String event) {
        System.out.println("Teacher " + name + " received announcement: " + event);
    }
}
