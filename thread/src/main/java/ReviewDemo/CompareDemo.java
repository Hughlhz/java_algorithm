package ReviewDemo;

public class CompareDemo implements Comparable{
    int age;
    String name;
    int gender;

    public CompareDemo(int age, String name, int gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CompareDemo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        CompareDemo o2 = (CompareDemo) o;
        int nameCompare = this.name.compareTo(o2.name);
        if(nameCompare!=0)  return nameCompare;
        int ageCompare = Integer.compare(this.age, o2.age);
        if (ageCompare != 0) {
            return ageCompare;
        }
        return Integer.compare(this.gender, o2.gender);
    }
}
