package testTasks.entity;

import java.util.Objects;

public class TestEntity {

    private  int id;
    private  String name;

    public TestEntity() {
    }

    public TestEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
