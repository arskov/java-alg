package com.github.akovalchuk;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ListSortTest {

    static class User {
        String name;
        int age;
        User(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String toString() {
            return "User: name=" + name + ", age" + age;
        }
    }

    @Test
    public void testThis() throws Exception {
        assertTrue(true);
        System.out.println("benchmark");
        var list1 = new ArrayList<User>();
        list1.add(new User("a", 1));
        list1.add(new User("b", 1));
        list1.add(new User("c", 1));
        list1.add(new User("d", 1));
        list1.sort((a, b) -> Integer.compare(a.age, b.age));
        System.out.println(list1);
        // Arrays.sort(list.toArray());
        var list2 = new LinkedList<User>();
        list2.add(new User("a", 1));
        list2.add(new User("b", 1));
        list2.add(new User("c", 1));
        list2.add(new User("d", 1));
        list2.sort((a, b) -> Integer.compare(a.age, b.age));
        //Collections.sort();

    }
    
}
