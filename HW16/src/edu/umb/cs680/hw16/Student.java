package edu.umb.cs680.hw16;

public class Student implements Observer<String> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(edu.umb.cs680.hw16.Observable<String> sender, String event) {
        System.out.println("Student " + name + " received announcement: " + event);
    }
}
