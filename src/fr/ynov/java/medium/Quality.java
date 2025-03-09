package fr.ynov.java.medium;

import java.util.Objects;

public class Quality{
    private int id;
    private String name;
    Quality(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id,this.name);
    }


    public static void main(String[] args) {
        Quality q1 = new Quality(1,"test");
        Quality q2 = new Quality(1,"test");
        Quality q3 = null;
        System.out.println(q1.equals(q2));
        System.out.println(q1.equals(q3));
        System.out.println(q1.hashCode());
        System.out.println(q2.hashCode());
    }
}
