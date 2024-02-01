package edu.umb.cs680.hw05;

public class Worker implements Observer<String> {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void update(edu.umb.cs680.hw05.Observable<String> sender, String event) {
        System.out.println("Worker " + name + " received announcement: " + event);
    }
}
