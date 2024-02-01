package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.Observer;
public class Student implements Observer<String> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(edu.umb.cs680.hw05.Observable<String> sender, String event) {
        System.out.println("Student " + name + " received announcement: " + event);
    }
}
