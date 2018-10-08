package csc315.com.todolist;

public class Task {

    private int _id;
    private String _task;

    public Task() {}

    public Task(int id, String task) {
        this._id = id;
        this._task = task;
    }

    public Task (String task) {
        this._task = task;
    }

    public void setID(int id){
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setTask(String task) {
        this._task = task;
    }

    public String getTask() {
        return this._task;
    }

}
