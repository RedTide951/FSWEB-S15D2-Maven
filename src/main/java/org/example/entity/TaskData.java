package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String param) {
        switch (param.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Invalid person: " + param);
        }
    }

    public Set<Task> getUnion(Set<Task> param1, Set<Task> param2) {
        Set<Task> unified = new HashSet<>();
        unified.addAll(param1);
        unified.addAll(param2);
        return unified;
    }

    public Set<Task> getIntersection(Set<Task> param1, Set<Task> param2) {
        Set<Task> intersection = new HashSet<>(param1);
        intersection.retainAll(param2);
        return intersection;
    }

    public Set<Task> getDifferences(Set<Task> param1, Set<Task> param2) {
        param1.removeAll(param2);
        return param1;
    }
}
