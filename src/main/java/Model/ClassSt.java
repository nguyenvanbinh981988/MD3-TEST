package Model;

public class ClassSt {
    private int classId;
    private String className;
    private int number;

    public ClassSt(String className, int number) {
        this.className = className;
        this.number = number;
    }

    public ClassSt(int classId, String className, int number) {
        this.classId = classId;
        this.className = className;
        this.number = number;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
